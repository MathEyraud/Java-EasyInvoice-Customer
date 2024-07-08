package com.mycompany.invoice.customer.api;

import com.mycompany.invoice.core.entity.customer.Address;
import com.mycompany.invoice.core.entity.customer.Customer;
import com.mycompany.invoice.customer.repository.IAddressRepository;
import com.mycompany.invoice.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/address")
public class AddressRessource {

    /**
     * ATTRIBUTS
     */
    private IAddressRepository addressRepository;

    /**
     * CONSTRUCTEUR
     */
    @Autowired
    public AddressRessource(IAddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    /**
     * METHODS
     */
    @GetMapping
    public Iterable<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") Long id){
        System.out.println(" ----- AddressRessource/getAddressById ----- ");

        // Récupérer les données depuis le service
        Address address = addressRepository.findById(id).orElseThrow(()->
            new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        // Retourner les données
        return address;
    }

    // @RequestBody : Convertir  le format JSON En objet Java
    @PostMapping
    public ResponseEntity<Address> createCustomer(@RequestBody Address address){
        System.out.println(" ----- AddressRessource/createCustomer ----- ");

        addressRepository.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

    /**
     * GETTERS/SETTERS
     */
    public IAddressRepository getAddressRepository() {
        return addressRepository;
    }

    public void setAddressRepository(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}