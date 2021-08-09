package com.mechanicservice.service;

import com.mechanicservice.dto.ServiceTypeDTO;
import com.mechanicservice.model.CarService;
import com.mechanicservice.model.Mechanic;
import com.mechanicservice.model.ServiceType;
import com.mechanicservice.repository.MechanicRepository;
import com.mechanicservice.repository.ServiceRepository;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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


    public ServiceTypeDTO getMostNeededSpecialization() {
        return new ServiceTypeDTO(getMostNeededService());
    }

    public ServiceType getMostNeededService() {
        HashMap<ServiceType, Integer> mechanicsPerSpecialization = new HashMap<>();
        for (ServiceType serviceType: ServiceType.values()) {
            if (!mechanicsPerSpecialization.containsKey(serviceType)) {
                mechanicsPerSpecialization.put(serviceType, 1);
            } else {
                mechanicsPerSpecialization.replace(serviceType, mechanicsPerSpecialization.get(serviceType) + 1);
            }
        }
        return chooseMostNeededService(mechanicsPerSpecialization);
    }

    public ServiceType chooseMostNeededService(HashMap<ServiceType, Integer> mechanicsPerSpecialization) {
        ServiceType serviceType = ServiceType.getRandomServiceType();
        int maxMechanicsNumber = mechanicsPerSpecialization.get(serviceType);
        for (Map.Entry<ServiceType, Integer> entry: mechanicsPerSpecialization.entrySet()) {
            if (entry.getValue() < maxMechanicsNumber) {
                serviceType = entry.getKey();
                maxMechanicsNumber = entry.getValue();
            }
        }
        return serviceType;
    }

    public Boolean hireMechanic(Mechanic mechanic) {
        if (getMostNeededService() == mechanic.getSpecialization()) {
            mechanic.setPosition("Junior Mechanic");
            mechanicRepository.save(mechanic);
            return true;
        }
        List<Mechanic> mechanics = mechanicRepository.findAll().stream().filter(midMechanic -> midMechanic.getPosition().equals("Mid-level Mechanic")).collect(Collectors.toList());
        if (mechanics.size() > 0) {
            Mechanic midLevelMechanic = mechanics.get(0);
            if (mechanic.getExperience() >= midLevelMechanic.getExperience() && mechanic.getAutomotiveRepair() >= midLevelMechanic.getAutomotiveRepair() && mechanic.getBrakeRepair() >= midLevelMechanic.getBrakeRepair() && mechanic.getEngineRepair() >= midLevelMechanic.getEngineRepair() && mechanic.getImportantParts() >= midLevelMechanic.getImportantParts()) {
                mechanic.setPosition("Mid-level Mechanic");
                mechanicRepository.save(mechanic);
                return true;
            }
        }
        return false;
    }
}
