package com.mechanicservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ServiceType requiredservice;
    private int price;
    @Column(name = "date")
    private String localDate;
    private String time;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Mechanic mechanic;

    public Appointment(ServiceType requiredservice, String localDate, String time) {
        this.requiredservice = requiredservice;
        this.localDate = localDate;
        this.time = time;
        price = requiredservice.price;
    }

    public void assignCustomer(Customer customer) {
        this.customer = customer;
    }

    public void assignMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }
}
