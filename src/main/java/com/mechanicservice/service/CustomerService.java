package com.mechanicservice.service;

import com.mechanicservice.model.Car;
import com.mechanicservice.model.CardDetails;
import com.mechanicservice.model.User;
import com.mechanicservice.model.Customer;
import com.mechanicservice.repository.CarRepository;
import com.mechanicservice.repository.CardDetailsRepository;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardDetailsRepository cardDetailsRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find customer with id: " + id));
    }

    public Customer saveCustomer(Customer customer, Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find car with id: " + carId));
        customer.setOwnedCar(car);
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
        Customer customerToUpdate = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find customer with id: " + customerId));
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        customerToUpdate.setCity(customer.getCity());
        customerToUpdate.setStreet(customer.getStreet());
        return customerRepository.save(customerToUpdate);
    }

    public CardDetails addCardDetails(CardDetails cardDetails, Long customerId) {
        cardDetailsRepository.save(cardDetails);
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("No customer with id : "+ customerId));
        customer.setCardDetails(cardDetails);
        customerRepository.save(customer);
        return cardDetails;
    }
}
