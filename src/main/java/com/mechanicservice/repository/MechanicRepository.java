package com.mechanicservice.repository;

import com.mechanicservice.model.Mechanic;
import com.mechanicservice.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
    Optional<List<Mechanic>> getMechanicBySpecialization(ServiceType specialization);
    Optional<Mechanic> getMechanicByEmail(String email);
    Optional<Mechanic> getMechanicByName(String name);
}
