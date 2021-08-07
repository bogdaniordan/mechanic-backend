package com.mechanicservice.controller;

import com.mechanicservice.model.Appointment;
import com.mechanicservice.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/mechanic/{mechanicId}/customer/{customerId}/car/{carId}")
    public ResponseEntity<Appointment> makeAppointment(@RequestBody Appointment appointment,
                                                       @PathVariable Long customerId,
                                                       @PathVariable Long mechanicId,
                                                       @PathVariable Long carId) throws MessagingException {
        log.info("Creating a new appointment for car: " + carId);
        Appointment newAppointment = appointmentService.addNewAppointment(appointment, customerId, mechanicId, carId);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<Appointment> getByCustomerId(@PathVariable Long customerId) {
        log.info("fetching appointment with customer id: " + customerId);
        Appointment appointment = appointmentService.getAppointmentByCustomerId(customerId);
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @GetMapping("/get-by-mechanic/{id}")
    public ResponseEntity<List<Appointment>> getByMechanicId(@PathVariable Long id) {
        log.info("Fetching appointments made with mechanic: " + id);
        List<Appointment> appointments = appointmentService.getByMechanicId(id);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
