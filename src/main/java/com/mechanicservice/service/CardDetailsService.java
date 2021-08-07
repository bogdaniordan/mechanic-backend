package com.mechanicservice.service;

import com.mechanicservice.model.CardDetails;
import com.mechanicservice.model.Customer;
import com.mechanicservice.repository.CardDetailsRepository;
import com.mechanicservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardDetailsService {

    private final CardDetailsRepository cardDetailsRepository;
    private final CustomerService customerService;

    public void addCardDetails(CardDetails cardDetails, Long customerId) {
        cardDetailsRepository.save(cardDetails);
        Customer customer = customerService.findById(customerId);
        customer.setCardDetails(cardDetails);
        customerService.saveCustomer(customer);
    }

    public CardDetails getCardDetailsByCustomerId(Long id) {
        return customerService.findById(id).getCardDetails();
    }
}
