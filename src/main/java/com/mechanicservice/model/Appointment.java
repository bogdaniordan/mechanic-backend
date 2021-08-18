package com.mechanicservice.model;

import com.mechanicservice.enums.AppointmentStatus;
import com.mechanicservice.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private String localDate;
    private String time;
    private String notes;
    private int durationInDays;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus = AppointmentStatus.NEW;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Mechanic mechanic;
    @OneToOne
    private Car car;
    @OneToMany
    private List<Message> messages = new ArrayList<>();

    public Appointment(ServiceType requiredservice, String localDate, String time, String notes) {
        this.requiredservice = requiredservice;
        this.localDate = localDate;
        this.time = time;
        this.notes = notes;
        price = requiredservice.getPrice();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

}
