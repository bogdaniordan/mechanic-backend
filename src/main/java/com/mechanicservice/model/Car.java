package com.mechanicservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brandName;
    @OneToOne
    @JoinColumn(name = "id")
    private Mechanic assignedMechanic;
    @Enumerated(EnumType.STRING)
    private FuelType fuel;
    @Enumerated(EnumType.STRING)
    private RepairedStatus repairedstatus;
    @Enumerated(EnumType.STRING)
    private ServiceType requiredservice;


    public Car(String brandName, RepairedStatus repairedStatus, ServiceType requiredServices, FuelType fuel) {
        this.brandName = brandName;
        this.repairedstatus = repairedStatus;
        this.requiredservice = requiredServices;
        this.fuel = fuel;
    }

    public void assignMechanic(Mechanic mechanic) {
        this.assignedMechanic = mechanic;
    }
}
