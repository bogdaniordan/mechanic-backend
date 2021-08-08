package com.mechanicservice.service;

import com.mechanicservice.model.Car;
import com.mechanicservice.model.CardDetails;
import com.mechanicservice.model.User;
import com.mechanicservice.model.Customer;
import com.mechanicservice.repository.CarRepository;
import com.mechanicservice.repository.CardDetailsRepository;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final CardDetailsRepository cardDetailsRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find customer with id: " + id));
    }

    public Customer saveCustomer(Customer customer, String username) {
        System.out.println(customer);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find user with username: " + username));
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<User> getAllCredentials() {
        return userRepository.findAll();
    }

    public User addCredentials(User user) {
        return this.userRepository.save(user);
    }

    public Customer customerByUserId(Long id) {
        return customerRepository.findCustomerByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer with user id: " + id));
    }

    public Customer customerByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find user"));
        return customerRepository.findCustomerByUserId(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer with customer id: " + user.getId()));
    }

    public Customer updateCustomer(Customer customer, Long customerId) {
        Customer customerToUpdate = findById(customerId);
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        customerToUpdate.setCity(customer.getCity());
        customerToUpdate.setStreet(customer.getStreet());
        customerToUpdate.setJobPosition(customer.getJobPosition());
        customerToUpdate.setGender(customer.getGender());
        customerToUpdate.setAge(customer.getAge());
        return customerRepository.save(customerToUpdate);
    }


    public Long getCustomerIdByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find user"));
        Customer customer = customerRepository.findCustomerByUserId(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer with customer id: " + user.getId()));
        return customer.getId();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find the customer with id: " + id));
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
