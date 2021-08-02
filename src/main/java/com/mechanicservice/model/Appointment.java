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
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ServiceType requiredservice;

    @Column(name = "price")
    private int price;

    @Column(name = "date")
    private String localDate;

    @Column(name = "time")
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
