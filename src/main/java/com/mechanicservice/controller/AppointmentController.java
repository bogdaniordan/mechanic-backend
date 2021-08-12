package com.mechanicservice.controller;

import com.mechanicservice.enums.AppointmentStatus;
import com.mechanicservice.model.Appointment;
import com.mechanicservice.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/appointments")
@AllArgsConstructor
public class AppointmentController {

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
    public ResponseEntity<List<Appointment>> getByCustomerId(@PathVariable Long customerId) {
        log.info("fetching appointment with customer id: " + customerId);
        List<Appointment> appointments = appointmentService.getAppointmentsByCustomerId(customerId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/get-by-mechanic/{id}")
    public ResponseEntity<List<Appointment>> getByMechanicId(@PathVariable Long id) {
        log.info("Fetching appointments made with mechanic: " + id);
        List<Appointment> appointments = appointmentService.getByMechanicId(id);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/set-as-seen/{id}")
    public ResponseEntity<Appointment> setAsSeen(@PathVariable Long id) {
        log.info("Setting as seen appointments with id: " + id);
        return new ResponseEntity<>(appointmentService.setStatus(id, AppointmentStatus.SEEN), HttpStatus.OK);
    }
}
