package com.mycompany.invoice.customer.repository;

import com.mycompany.invoice.core.entity.customer.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

}