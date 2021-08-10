package com.mechanicservice.service;

import com.mechanicservice.model.*;
import com.mechanicservice.repository.AppointmentRepository;
import com.mechanicservice.repository.CarRepository;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.MechanicRepository;
import com.mechanicservice.util.Email;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDate;
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


    public Boolean carHasBeenRepaired(Long carId) {
        if (appointmentRepository.getAppointmentsByCar_Id(carId).isPresent()) {
            List<Appointment> appointments = appointmentRepository.getAppointmentsByCar_Id(carId).get();
            if (appointments.size() == 0) {
                return false;
            }
            LocalDate mostRecentDate = appointments.stream()
                    .map(date -> LocalDate.parse(date.getLocalDate()))
                    .max(LocalDate::compareTo)
                            .orElse(null);
            if (LocalDate.now().compareTo(mostRecentDate) >= 0)
            setCarStatus(carId, RepairedStatus.REPAIRED);
            return true;
        }
        return false;
    }
}
