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
    private int experience;
    private int automotiveRepair;
    private int engineRepair;
    private int importantParts;
    private int brakeRepair;
    private String phoneNumber;
    private String email;
    private String position;

    public Mechanic(String name, ServiceType specialization, String picture, String description, int experience, int automotive_repair, int engine_repair, int important_parts, int brake_repair, String phoneNumber, String position) {
        this.name = name;
        this.specialization = specialization;
        this.picture = picture;
        this.description = description;
        this.experience = experience;
        this.automotiveRepair = automotive_repair;
        this.engineRepair = engine_repair;
        this.importantParts = important_parts;
        this.brakeRepair = brake_repair;
        this.phoneNumber = phoneNumber;
        this.email = nameToEmail(name);
        this.position = position;
        assignedCars = new ArrayList<>();
    }


    private String nameToEmail(String name) {
        StringBuilder email = new StringBuilder();
        for(int i = 0; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i))) {
                email.append(Character.toLowerCase(name.charAt(i)));
            } else {
                email.append("_");
            }
        }
        email.append("@gmail.com");
        return email.toString();
    }
}
