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
    private String localDate;
    private String time;
    private String notes;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Mechanic mechanic;
    @OneToOne
    private Car car;

    public Appointment(ServiceType requiredservice, String localDate, String time, String notes) {
        this.requiredservice = requiredservice;
        this.localDate = localDate;
        this.time = time;
        this.notes = notes;
    }
}
