package com.mechanicservice.service;

import com.mechanicservice.aws.BucketName;
import com.mechanicservice.aws.FileStore;
import com.mechanicservice.model.Car;
import com.mechanicservice.model.Customer;
import com.mechanicservice.model.Mechanic;
import com.mechanicservice.enums.RepairedStatus;
import com.mechanicservice.repository.CarRepository;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.MechanicRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final MechanicRepository mechanicRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final FileStore fileStore;

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
        car.setRepairedstatus(RepairedStatus.GETTING_REPAIRED);
        return carRepository.save(car);
    }

    public Car replaceCustomerCar(Car car, Long id) {
        carRepository.save(car);
        Customer customer = customerService.findById(id);
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

    public void saveCarInDB(Car car) {
        carRepository.save(car);
    }

    public Boolean carIsDiscounted(String carBrand, Long carId) {
        return findById(carId).getBrandName().equals(carBrand.substring(0, carBrand.length() - 1));
    }

    public byte[] downloadImage(Long carId) {
        // path = bucketName + bucketFolder + key
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), carId);
        String imageURL = findById(carId).getPicture();
        return fileStore.download(path, imageURL);
    }
}
