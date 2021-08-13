package com.mechanicservice.service;

import com.mechanicservice.enums.Rating;
import com.mechanicservice.model.Car;
import com.mechanicservice.model.Customer;
import com.mechanicservice.model.Mechanic;
import com.mechanicservice.model.Testimonial;
import com.mechanicservice.repository.CarRepository;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.MechanicRepository;
import com.mechanicservice.repository.TestimonialRepository;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class TestimonialService {

    private final TestimonialRepository testimonialRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final MechanicService mechanicService;

    public List<Testimonial> getTestimonialsByMechanic(Long id) {
        return testimonialRepository.getTestimonialsByMechanic_Id(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find testimonials for mechanic with id: " + id));
    }


    public Testimonial addTestimonial(Testimonial testimonial, Long carId, Long customerId, Long mechanicId) {
        Car car = carService.findById(carId);
        Customer customer = customerService.findById(customerId);
        Mechanic mechanic = mechanicService.findById(mechanicId);
        testimonial.setMechanic(mechanic);
        testimonial.setCustomer(customer);
        testimonial.setCar(car);
        return testimonialRepository.save(testimonial);
    }

    public boolean canIsReviewed(Long id) {
        List<Testimonial> testimonials = testimonialRepository.getTestimonialsByCarId(id)
                .orElseThrow(() -> new ResourceNotFoundException(""));
        return testimonials.size() > 0;
    }

    public HashMap<Rating, Integer> getCountedRatings(Long mechanicId) {
        HashMap<Rating, Integer> map = new HashMap<>();
        for(Testimonial testimonial: getTestimonialsByMechanic(mechanicId)) {
            if (!map.containsKey(testimonial.getRating())) {
                map.put(testimonial.getRating(), 1);
            } else {
                map.replace(testimonial.getRating(), map.get(testimonial.getRating()) + 1);
            }
        }
        return map;
    }
}
