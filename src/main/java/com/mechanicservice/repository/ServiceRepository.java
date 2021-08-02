package com.mechanicservice.repository;

import com.mechanicservice.model.CarService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<CarService, Long> {

    Optional<CarService> getServiceByMechanicId(Long mechanic_id);

    Optional<List<CarService>> getServicesByMechanic_Id(Long mechanic_id);

    Optional<List<CarService>> getServicesByCustomerId(Long customer_id);
}
