package com.mechanicservice.controller;


import com.mechanicservice.model.Car;
import com.mechanicservice.service.AppointmentService;
import com.mechanicservice.service.CarService;
import com.mechanicservice.util.DiscountCar;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;
    private final AppointmentService appointmentService;

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        log.info("Fetching car with id: " + id);
        Car car = carService.getCar(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        log.info("Fetching all the cars in the db.");
        List<Car> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping("/{mechanic-id}")
    public ResponseEntity<Car> addCarAndAssignIt(@RequestBody Car car, @PathVariable("mechanic-id") Long mechanicId) {
        log.info("Adding a new car to the db.");
        Car savedCar = carService.saveCar(car, mechanicId);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        log.info("Updating car with id: " + car.getId());
        Car savedCar = carService.updateCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.OK);
    }

    @PutMapping("/assign-to-mechanic/{mechanic-id}")
    public ResponseEntity<Car> assignExistingCarToMechanic(@RequestBody Car car, @PathVariable("mechanic-id") Long mechanicId) {
        log.info("Assigning car to mechanic with id: " + mechanicId);
        Car updatedCar = carService.saveCar(car, mechanicId);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);

    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<Car> updateCarRepairedStatus(@PathVariable Long id) {
        log.info("Updating repair status of car with id: " + id);
        Car updatedCar = carService.updateCarRepairStatus(id);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/delete-car/{carId}/from-customer/{customerId}")
    public ResponseEntity<String> deleteCar(@PathVariable Long carId, @PathVariable Long customerId)  {
        if (carService.removeAndDeleteCar(carId, customerId)) {
            return ResponseEntity.ok("Deleted car with id: " + carId);
        }
        return ResponseEntity.ok("Couldn't delete car with id: " + carId);
    }


    @PutMapping("/replace-customer-car/{id}")
    public ResponseEntity<Car> replaceCustomerCar(@RequestBody Car car, @PathVariable("id") Long id) {
        log.info("Replacing car of customer with id: " + id);
        Car newCar = carService.replaceCustomerCar(car, id);
        return new ResponseEntity<>(newCar,HttpStatus.CREATED);
    }

    @GetMapping("/cars-by-customer/{id}")
    public ResponseEntity<List<Car>> getCarsByCustomerId(@PathVariable Long id) {
        log.info("Getting cars for customer with id: " + id);
        List<Car> cars = carService.getCarsByCustomerId(id);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping("/add-car-to-customer/{customerId}")
    public void addCarToCustomer(@RequestBody Car car, @PathVariable Long customerId) {
        log.info("Adding a new car to the collection of customer with id: " + customerId);
        carService.addCarToCustomer(car, customerId);
    }

    @PostMapping("/car-brand-discounted/{id}")
    public ResponseEntity<Boolean> carIsDiscounted(@RequestBody String carBrand,
                                                   @PathVariable Long id) {
        log.info("Checking if car with id: " + id + " is discounted.");
        return new ResponseEntity<>(carService.carIsDiscounted(carBrand, id), HttpStatus.OK);
    }

//    @GetMapping("/discounted-car")
//    public ResponseEntity<String> getDiscountedCar() {
//        log.info("Fetching discounted car brand.");
//        return new ResponseEntity<>(DiscountCar.getRandomCarBrand(), HttpStatus.OK);
//    }

    @GetMapping("/car-has-repaired/{id}")
    public ResponseEntity<Boolean> casHasBeenRepaired(@PathVariable Long id) {
        log.info("Checking if the car with id " + id + " has been had an appointment and setting it's status to repaired");
        return new ResponseEntity<>(appointmentService.carHasBeenRepaired(id), HttpStatus.OK);
    }
}
