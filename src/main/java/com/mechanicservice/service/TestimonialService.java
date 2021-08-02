package com.mechanicservice.service;

import com.mechanicservice.model.Car;
import com.mechanicservice.model.Customer;
import com.mechanicservice.model.Mechanic;
import com.mechanicservice.model.Testimonial;
import com.mechanicservice.repository.CarRepository;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.MechanicRepository;
import com.mechanicservice.repository.TestimonialRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialService {
    @Autowired
    private TestimonialRepository testimonialRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MechanicRepository mechanicRepository;

    public List<Testimonial> getTestimonialsByMechanic(Long id) {
        return testimonialRepository.getTestimonialsByMechanic_Id(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find testimonials for mechanic with id: " + id));
    }


    public Testimonial addTestimonial(Testimonial testimonial, Long carId, Long customerId, Long mechanicId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find car with id: " + carId));
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find customer with id: " + customerId));
        Mechanic mechanic = mechanicRepository.findById(mechanicId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find mechanic with id: " + mechanicId));
        testimonial.setMechanic(mechanic);
        testimonial.setCustomer(customer);
        testimonial.setCar(car);
        return testimonialRepository.save(testimonial);
    }
}
