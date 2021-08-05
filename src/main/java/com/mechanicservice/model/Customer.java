package com.mechanicservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @OneToMany
    private List<Car> cars = new ArrayList<>();
    @OneToOne
    private User user;
    @Size(min=3, max=25)
    @NotNull
    private String email;
    @Size(min=7, max=15)
    @NotNull
    private String phoneNumber;
    @Size(min=5, max=30)
    @NotNull
    private String street;
    @Max(30)
    @NotNull
    private String city;
    private String picture;
    @Max(15)
    @NotNull
    private String jobPosition;
    @Max(10)
    @NotNull
    private String gender;

    @OneToOne
    private CardDetails cardDetails;

    public Customer(String name, String email, String phoneNumber, String street, String city, String picture, String jobPosition, String gender) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.picture = picture;
        this.jobPosition = jobPosition;
        this.gender = gender;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }
}
