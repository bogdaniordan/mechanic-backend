package com.mechanicservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "card_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cardOwner;
    @Size(min = 12)
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    public CardDetails(String cardOwner, String cardNumber, String expirationDate, String cvv) {
        this.cardOwner = cardOwner;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }
}
