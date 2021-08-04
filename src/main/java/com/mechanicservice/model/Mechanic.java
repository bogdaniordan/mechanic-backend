package com.mechanicservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "mechanic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ServiceType specialization;
    private String picture;
    @OneToMany
    private List<Car> assignedCars;
    private String description;


    public Mechanic(String name, ServiceType serviceType, String description) {
        this.name = name;
        this.specialization = serviceType;
        this.assignedCars = new ArrayList<>();
        this.description = description;
    }

    public void addPicture(String picture) {
        this.picture = picture;
    }

    public void assignCar(Car car) {
        assignedCars.add(car);
    }


}
