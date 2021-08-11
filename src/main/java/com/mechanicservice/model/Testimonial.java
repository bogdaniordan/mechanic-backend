package com.mechanicservice.model;

import com.mechanicservice.enums.Rating;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "testimonial")
@Data
@NoArgsConstructor
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Rating rating;
    private String comment;
    @ManyToOne
    private Car car;
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    @ManyToOne
    private Mechanic mechanic;
    @ManyToOne
    private Customer customer;

    public Testimonial(Rating rating, String comment, ServiceType serviceType) {
        this.rating = rating;
        this.comment = comment;
        this.serviceType = serviceType;
    }
}
