package com.mechanicservice.controller;

import com.mechanicservice.model.CardDetails;
import com.mechanicservice.model.Customer;
import com.mechanicservice.service.CardDetailsService;
import com.mechanicservice.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/card-details")
@AllArgsConstructor
public class CardDetailsController {

    private CardDetailsService cardDetailsService;


    @PostMapping("/add-payment-details/{customerId}")
    public ResponseEntity<CardDetails> addCardDetails(@RequestBody CardDetails cardDetails, @PathVariable Long customerId) {
        log.info("Adding card details to customer with id: " + customerId);
        cardDetailsService.addCardDetails(cardDetails, customerId);
        return new ResponseEntity<>(cardDetails, HttpStatus.CREATED);
    }


    @GetMapping("/get-card/{customerId}")
    public ResponseEntity<CardDetails> getCardDetails(@PathVariable  Long customerId) {
        log.info("Fetching card details for customer with id: " + customerId);
        return new ResponseEntity<>(cardDetailsService.getCardDetailsByCustomerId(customerId), HttpStatus.OK);
    }
}
