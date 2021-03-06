package com.mechanicservice.service;

import com.mechanicservice.enums.AppointmentStatus;
import com.mechanicservice.enums.RepairedStatus;
import com.mechanicservice.model.*;
import com.mechanicservice.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerService customerService;
    private final MechanicService mechanicService;
    private final CarService carService;

    public Appointment addNewAppointment(Appointment appointment, Long customerId, Long mechanicId, Long carId) throws MessagingException {
        Customer customer = customerService.findById(customerId);
        Mechanic mechanic = mechanicService.findById(mechanicId);
        Car car = setCarStatus(carId, RepairedStatus.GETTING_REPAIRED);
        appointment.setCustomer(customer);
        appointment.setMechanic(mechanic);
        appointment.setCar(car);
//        Email.send(customer.getEmail(), customer, appointment);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByCustomerId(Long id) {
        return appointmentRepository.getAppointmentsByCustomer_Id(id)
                .orElseThrow(() -> new ResourceNotFoundException("No appointment for customer with id: " + id));
    }

    private Car setCarStatus(Long carId, RepairedStatus repairedStatus) {
        Car car = carService.findById(carId);
        car.setRepairedstatus(repairedStatus);
        carService.saveCarInDB(car);
        return car;
    }

    public List<Appointment> getByMechanicId(Long id) {
        return appointmentRepository.getAppointmentsByMechanic_Id(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find appointment with mechanic id: " + id));
    }

    public Appointment setStatus(Long id, AppointmentStatus appointmentStatus) {
        Appointment appointment = findById(id);
        if (appointmentStatus == AppointmentStatus.DONE) {
            appointment.getCar().setRepairedstatus(RepairedStatus.REPAIRED);
        }
        appointment.setAppointmentStatus(appointmentStatus);
        return appointmentRepository.save(appointment);
    }

    public Appointment findById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find appointment with id: " + id));
    }

    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public long newAppointments() {
        return appointmentRepository.findAll().stream().filter(appointment -> appointment.getAppointmentStatus() == AppointmentStatus.NEW).count();
    }
}
