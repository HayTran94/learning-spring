package com.example.controller;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    long currentId = 0;
    @Autowired
    public CustomerRepository customerRepository;

    @GetMapping("/customer/get")
    public Customer getCustomer(@RequestParam(value = "id") Long id) {
        Optional<Customer> byId = customerRepository.findById(id);
        return byId.orElse(null);
    }

    @PostMapping("/customer/create")
    public Customer createCustomer() {
        currentId ++;
        return customerRepository.save(new Customer("firstName " + currentId, "lastName " + currentId));
    }

    @GetMapping("/customer/search")
    public List<Customer> searchCustomer(@RequestParam(value = "firstName") String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @DeleteMapping("/customer/delete")
    public void deleteCustomer(@RequestParam(value = "id") Long id) {
        customerRepository.deleteById(id);
    }

    @GetMapping("/customer/get-all")
    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

}
