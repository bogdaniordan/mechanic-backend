package com.mechanicservice.controller;


import com.mechanicservice.enums.Rating;
import com.mechanicservice.model.Testimonial;
import com.mechanicservice.service.TestimonialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    @GetMapping("/{mechanicId}")
    public ResponseEntity<List<Testimonial>> getTestimonialsByMechanic(@PathVariable Long mechanicId) {
        log.info("Fetching testimonials for mechanic with id: " + mechanicId);
        List<Testimonial> testimonials = testimonialService.getTestimonialsByMechanic(mechanicId);
        return new ResponseEntity<>(testimonials, HttpStatus.OK);
    }

    @PostMapping("/create-testimonial/{mechanicId}/{customerId}/{carId}")
    public ResponseEntity<Testimonial> addNewTestimonial(@RequestBody Testimonial testimonial,
                                                         @PathVariable Long carId,
                                                         @PathVariable Long customerId,
                                                         @PathVariable Long mechanicId) {
        log.info("Adding a new testimonial.");
        Testimonial newTestimonial = testimonialService.addTestimonial(testimonial, carId, customerId, mechanicId);
        return new ResponseEntity<>(newTestimonial, HttpStatus.CREATED);
    }

    @GetMapping("/reviewed-car/{id}")
    public ResponseEntity<Boolean> carHasBeenReviewed(@PathVariable Long id) {
        log.info("Checking if car with id " + id + " has been reviewed.");
        return new ResponseEntity<>(testimonialService.canIsReviewed(id), HttpStatus.OK);
    }

    @GetMapping("/mapped-ratings/{mechanicId}")
    public ResponseEntity<HashMap<Rating, Integer>> getMappedRatings(@PathVariable Long mechanicId) {
        log.info("Fetching ratings for mechanic with id: "+ mechanicId);
        return new ResponseEntity<>(testimonialService.getCountedRatings(mechanicId), HttpStatus.OK);
    }

    @GetMapping("/all-ratings")
    public ResponseEntity<List<Rating>> getAllRatings() {
        return new ResponseEntity<>(List.of(Rating.values()), HttpStatus.OK);
    }


}
