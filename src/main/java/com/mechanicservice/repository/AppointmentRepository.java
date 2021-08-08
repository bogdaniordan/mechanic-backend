package com.mechanicservice.repository;

import com.mechanicservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<List<Appointment>> getAppointmentsByCustomer_Id(Long customer_id);
    Optional<List<Appointment>> getAppointmentsByMechanic_Id(Long mechanic_id);
}
