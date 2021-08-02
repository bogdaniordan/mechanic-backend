package com.mechanicservice.service;

import com.mechanicservice.model.*;
import com.mechanicservice.repository.AppointmentRepository;
import com.mechanicservice.repository.CarRepository;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.MechanicRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MechanicRepository mechanicRepository;

    @Autowired
    private CarRepository carRepository;

    public Appointment addNewAppointment(Appointment appointment, Long customerId, Long mechanicId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer with id " + customerId));
        Mechanic mechanic = mechanicRepository.findById(mechanicId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find mechanic with id: " + mechanicId));
        Car car = customer.getOwnedCar();
        car.setRepairedstatus(RepairedStatus.GETTING_REPAIRED);
        carRepository.save(car);
        appointment.assignCustomer(customer);
        appointment.assignMechanic(mechanic);
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentByCustomerId(Long id) {
        return appointmentRepository.getAppointmentByCustomer_Id(id)
                .orElseThrow(() -> new ResourceNotFoundException("No appointment for customer with id: " + id));
    }
}
