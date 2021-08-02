package com.mechanicservice.service;

import com.mechanicservice.model.CarService;
import com.mechanicservice.repository.CarRepository;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.MechanicRepository;
import com.mechanicservice.repository.ServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class CarServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    MechanicRepository mechanicRepository;

    @Autowired
    CustomerRepository customerRepository;

    public CarService getServiceByMechanic(Long id) {
        return serviceRepository.getServiceByMechanicId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find service!"));
    }

    public List<CarService> getAllServices() {
        return serviceRepository.findAll();
    }

    public CarService createNewCarService(CarService carService, Long carId, Long mechanicId, Long customerId) {
        carService.assignCar(carRepository.findById(carId)
                        .orElseThrow(() -> new ResourceNotFoundException("Car not found!")));
        carService.assignMechanic(mechanicRepository.findById(mechanicId).
                orElseThrow(() -> new ResourceNotFoundException("Mechanic not found!")));
        carService.assignCustomer(customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer with id: " + customerId)));
        return serviceRepository.save(carService);
    }

    public List<CarService> getAllByMechanicId(Long id) {
        return serviceRepository.getServicesByMechanic_Id(id).
                orElseThrow(() -> new ResourceNotFoundException("Could not find services with this mechanic id: " + id));
    }


    public List<CarService> getByCustomerId(Long id) {
        return serviceRepository.getServicesByCustomerId(id).
                orElseThrow(() -> new ResourceNotFoundException("Could not find services with this customer id: " + id));
    }
}
