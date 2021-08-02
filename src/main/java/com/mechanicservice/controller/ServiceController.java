package com.mechanicservice.controller;

import com.mechanicservice.model.CarService;
import com.mechanicservice.model.ServiceType;
import com.mechanicservice.model.ServiceTypeDTO;
import com.mechanicservice.service.CarServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    CarServiceService carServiceService;

    @GetMapping("/{mechanicId}")
    public ResponseEntity<CarService> getServiceByMechanicId(@PathVariable Long mechanicId) {
        log.info("Fetching service by mechanic with id: " + mechanicId);
        CarService carService = carServiceService.getServiceByMechanic(mechanicId);
        return new ResponseEntity<>(carService, HttpStatus.OK);
    }

    @PostMapping("/mechanic/{mechanic-id}/car/{car-id}/customer/{customerId}")
    public ResponseEntity<CarService> addNewService(@RequestBody CarService newCarService,
                                                    @PathVariable("car-id") Long carId,
                                                    @PathVariable("mechanic-id") Long mechanicId,
                                                    @PathVariable Long customerId) {
        log.info("Creating a new car service.");
        CarService carService = carServiceService.createNewCarService(newCarService, carId, mechanicId, customerId);
        return new ResponseEntity<>(carService, HttpStatus.CREATED);
    }


    @GetMapping("/services-by-mechanic-id/{mechanicId}")
    public ResponseEntity<List<CarService>> getAllServices(@PathVariable Long mechanicId) {
        log.info("Fetching all car services.");
        List<CarService> carServices = carServiceService.getAllByMechanicId(mechanicId);
        return new ResponseEntity<>(carServices, HttpStatus.OK);
    }


    @GetMapping("/services-by-customer/{customerId}")
    public ResponseEntity<List<CarService>> getAllServicesByCustomer(@PathVariable Long customerId) {
        log.info("fetching services with customer id: " + customerId);
        List<CarService> carServices = carServiceService.getByCustomerId(customerId);
        return new ResponseEntity<>(carServices, HttpStatus.OK);
    }

    @GetMapping("/get-service-types")
    public ResponseEntity<List<ServiceTypeDTO>> getAllServiceTypes() {
        List<ServiceTypeDTO> serviceTypeDTOS = new ArrayList<>();
        for (ServiceType serviceType: ServiceType.values()) {
            serviceTypeDTOS.add(new ServiceTypeDTO(serviceType));
        }
        return new ResponseEntity<>(serviceTypeDTOS, HttpStatus.OK);
    }

}
