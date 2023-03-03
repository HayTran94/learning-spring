package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    long currentId = 0;
    @Autowired
    public CustomerRepository customerRepository;

    @GetMapping("/get")
    public Customer getCustomer(@RequestParam(value = "id") Long id) {
        Optional<Customer> byId = customerRepository.findById(id);
        return byId.orElse(null);
    }

    @PostMapping("/create")
    public Customer createCustomer() {
        currentId ++;
        return customerRepository.save(new Customer("firstName " + currentId, "lastName " + currentId));
    }

    @GetMapping("/search")
    public List<Customer> searchCustomer(@RequestParam(value = "firstName") String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestParam(value = "id") Long id) {
        customerRepository.deleteById(id);
    }

    @GetMapping("/get-all")
    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

}
