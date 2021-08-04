package com.mechanicservice.service;

import com.mechanicservice.model.Car;
import com.mechanicservice.model.Customer;
import com.mechanicservice.model.Mechanic;
import com.mechanicservice.model.RepairedStatus;
import com.mechanicservice.repository.CarRepository;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.MechanicRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final MechanicRepository mechanicRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCar(Long id) {
        return findById(id);
    }

    public Car saveCar(Car car, Long mechanicId) {
        Mechanic mechanic = mechanicRepository.findById(mechanicId)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find mechanic with id: " + mechanicId));
        car.assignMechanic(mechanic);
        System.out.println(car.getAssignedMechanic().toString());
        return carRepository.save(car);
    }

    public Car updateCar(Car car) { return carRepository.save(car);}

    public boolean removeAndDeleteCar(Long carId, Long customerId) {
        Car car = findById(carId);
        if (car != null) {
            customerService.findById(customerId).removeCar(car);
            carRepository.delete(car);
            return true;
        }
        return false;

    }

    public Car updateCarRepairStatus(Long id) {
        Car car = findById(id);
        car.setRepairedstatus(RepairedStatus.REPAIRED);
        return carRepository.save(car);
    }

    public Car replaceCustomerCar(Car car, Long id) {
        carRepository.save(car);
        Customer customer = customerService.findById(id);
//        customer.setOwnedCar(car);
        customer.setCars(List.of(car));
        customerRepository.save(customer);
        return car;
    }

    public List<Car> getCarsByCustomerId(Long id) {
        return customerService.findById(id).getCars();
    }

    public void addCarToCustomer(Car car, Long id) {
        carRepository.save(car);
        Customer customer = customerService.findById(id);
        customer.addCar(car);
        customerRepository.save(customer);
    }

    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find customer id: " + id));
    }
}
