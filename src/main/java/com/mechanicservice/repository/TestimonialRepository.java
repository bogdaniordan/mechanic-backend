package com.mechanicservice.repository;

import com.mechanicservice.model.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
    Optional<List<Testimonial>> getTestimonialsByMechanic_Id(Long mechanic_id);

    Optional<List<Testimonial>> getTestimonialsByCarId(Long car_id);
}
