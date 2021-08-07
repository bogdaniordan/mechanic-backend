package com.mechanicservice.service;

import com.mechanicservice.model.CarService;
import com.mechanicservice.model.Mechanic;
import com.mechanicservice.model.ServiceType;
import com.mechanicservice.repository.MechanicRepository;
import com.mechanicservice.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MechanicService {

    private MechanicRepository mechanicRepository;
    private ServiceRepository serviceRepository;

    public List<Mechanic> getAllMechanics() {
        return mechanicRepository.findAll();
    }

    public Mechanic getMechanic(Long id) {
        return mechanicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find mechanic with id: " + id));
    }

    public Mechanic addMechanic(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    public Mechanic updateMechanic(Mechanic mechanicDetails, Long id) {
        Mechanic mechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find mechanic with id: " + id));
        mechanic.setName(mechanicDetails.getName());
        mechanic.setSpecialization(mechanicDetails.getSpecialization());
        return mechanicRepository.save(mechanic);
    }

    public Mechanic deleteById(Long id) {
        if (mechanicRepository.findById(id).isPresent()) {
            Mechanic mechanic = mechanicRepository.findById(id).get();
            Optional<List<CarService>> servicesByMechanic = serviceRepository.getServicesByMechanic_Id(id);
            servicesByMechanic.ifPresent(carServices -> serviceRepository.deleteAll(carServices));
            mechanicRepository.delete(mechanic);
            return mechanic;
        }
        return null;
    }


    public List<Mechanic> getMechanicsBySpecialization(String specialization) {
        return mechanicRepository.getMechanicBySpecialization(Enum.valueOf(ServiceType.class, specialization))
                .orElseThrow(() -> new ResourceNotFoundException("Could not find any mechanic with specialization: " + specialization));
    }

    public Mechanic findById(Long id) {
        return mechanicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find mechanic with id: " + id));
    }
}
