package com.mycompany.invoice.customer.api;

import com.mycompany.invoice.core.entity.customer.Customer;
import com.mycompany.invoice.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customer")
public class CustomerRessource {

    /**
     * ATTRIBUTS
     */
    private ICustomerRepository customerRepository;

    /**
     * CONSTRUCTEUR
     */
    @Autowired
    public CustomerRessource(ICustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    /**
     * METHODS
     */
    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id){
        System.out.println(" ----- CustomerRessource/getCustomerById ----- ");

        // Récupérer les données depuis le service
        Customer customer = customerRepository.findById(id).orElseThrow(()->
            new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        // Retourner les données
        return customer;
    }

    // @RequestBody : Convertir  le format JSON En objet Java
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        System.out.println(" ----- CustomerRessource/createCustomer ----- ");

        customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    /**
     * GETTERS/SETTERS
     */
    public ICustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}