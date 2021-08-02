package com.mechanicservice.controller;


import com.mechanicservice.model.CardDetails;
import com.mechanicservice.model.User;
import com.mechanicservice.model.Customer;
import com.mechanicservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        log.info("Fetching all customers");
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        log.info("Fetching customer with id: " + id);
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/{car-id}")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer, @PathVariable("car-id") Long carId) {
        log.info("Adding customer with id: " + customer.getId());
        Customer savedCustomer = customerService.saveCustomer(customer, carId);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        log.info("Updating customer with id: " + customer.getId());
        Customer savedCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
    }

    @GetMapping("/credentials")
    public ResponseEntity<List<User>> getAllCredentials() {
        log.info("Fetching all user credentials");
        List<User> credentials =  customerService.getAllCredentials();
        return new ResponseEntity<>(credentials, HttpStatus.OK);
    }

    @PostMapping("/credentials")
    public ResponseEntity<User> saveCredentials(@RequestBody User user) {
        log.info("Saving new user credentials");
        User newUser = customerService.addCredentials(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/by-user-id/{id}")
    public ResponseEntity<Customer> customerByUserId(@PathVariable Long id) {
        log.info("Retrieving customer by user id: " + id);
        Customer customer = customerService.customerByUserId(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/customer-by-username/{username}")
    public ResponseEntity<Customer> customerByUsername(@PathVariable String username) {
        log.info("Fetching customer with username: " + username);
        Customer customer = customerService.customerByUsername(username);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/update-customer-details/{customerId}")
    public ResponseEntity<Customer> updateCustomerDetails(@RequestBody Customer customer, @PathVariable Long customerId) {
        log.info("Updating customer with id: " + customerId);
        Customer updatedCustomer = customerService.updateCustomer(customer, customerId);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @PostMapping("/add-payment-details/{customerId}")
    public ResponseEntity<CardDetails> addCardDetails(@RequestBody CardDetails cardDetails, @PathVariable Long customerId) {
        log.info("Adding card details to customer with id: " + customerId);
        CardDetails cardDetails1 = customerService.addCardDetails(cardDetails, customerId);
        return new ResponseEntity<>(cardDetails, HttpStatus.CREATED);
    }



}
