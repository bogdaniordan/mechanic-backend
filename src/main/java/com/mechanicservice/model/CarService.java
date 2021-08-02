package com.mechanicservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ServiceType servicetype;
    @OneToOne
    private Car car;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Mechanic mechanic;
    private Date date;


    public CarService(ServiceType serviceType, Date date) {
        this.servicetype = serviceType;
        this.date = date;
    }

    public void assignCar(Car car) {
        this.car = car;
    }

    public void assignCustomer(Customer customer) {
        this.customer = customer;
    }

    public void assignMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }
}
