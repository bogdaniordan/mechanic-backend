package com.mechanicservice.controller;

import com.mechanicservice.model.Appointment;
import com.mechanicservice.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/{mechanicId}/{customerId}")
    public ResponseEntity<Appointment> makeAppointment(@RequestBody Appointment appointment,
                                                       @PathVariable Long customerId,
                                                       @PathVariable Long mechanicId) {
        log.info("Creating a new appointment.");
        Appointment newAppointment = appointmentService.addNewAppointment(appointment, customerId, mechanicId);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<Appointment> getByCustomerId(@PathVariable Long customerId) {
        log.info("fetching appointment with customer id: " + customerId);
        Appointment appointment = appointmentService.getAppointmentByCustomerId(customerId);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }
}
