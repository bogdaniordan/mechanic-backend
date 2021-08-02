package com.mechanicservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "card_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "card_owner")
    private String cardOwner;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "expiration_month")
    private String expirationMonth;
    @Column(name = "expiration_year")
    private String expirationYear;

    public CardDetails(String cardOwner, String cardNumber, String expirationMonth, String expirationYear) {
        this.cardOwner = cardOwner;
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }
}
