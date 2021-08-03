package com.mechanicservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
//    @OneToOne
//    @JoinColumn(name = "ownedcar_id")
//    private Car ownedCar;
    @OneToMany
    private List<Car> cars = new ArrayList<>();
    @OneToOne
    private User user;
    private String email;
    private String phoneNumber;
    private String street;
    private String city;
    private String picture;

    @OneToOne
    private CardDetails cardDetails;

    public Customer(String name, String email, String phoneNumber, String street, String city, String picture) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.picture = picture;
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
