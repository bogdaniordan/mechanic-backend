package com.mechanicservice.service;

import com.mechanicservice.aws.BucketName;
import com.mechanicservice.aws.FileStore;
import com.mechanicservice.dto.ServiceTypeDTO;
import com.mechanicservice.model.Customer;
import com.mechanicservice.model.Mechanic;
import com.mechanicservice.model.ServiceType;
import com.mechanicservice.repository.MechanicRepository;
import com.mechanicservice.util.FileChecker;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MechanicService {

    private MechanicRepository mechanicRepository;
    private FileStore fileStore;

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
//            Optional<List<CarService>> servicesByMechanic = serviceRepository.getServicesByMechanic_Id(id);
//            servicesByMechanic.ifPresent(carServices -> serviceRepository.deleteAll(carServices));
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

    public void save(Mechanic mechanic) {
        mechanicRepository.save(mechanic);
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


    public Long getMechanicIdByEmail(String email) {
        Mechanic mechanic = mechanicRepository.getMechanicByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find mechanic with email: " + email));
        return mechanic.getId();
    }

    public Mechanic getMechanicByName(String name) {
        return mechanicRepository.getMechanicByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find mechanic with name: " + name));
    }


    public byte[] downloadImage(Long mechanicId) {
        // path = bucketName + bucketFolder + key
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), mechanicId);
        String imageURL = findById(mechanicId).getPicture();
        return fileStore.download(path, imageURL);
    }


    public void uploadMechanicProfileImage(Long mechanicId, MultipartFile file) {
        FileChecker.isFileEmpty(file);
        FileChecker.isImage(file);
        Mechanic mechanic = findById(mechanicId);
        Map<String, String> metadata = FileChecker.extractMetadata(file);
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), mechanic.getId());
        String filename = file.getOriginalFilename();
        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            mechanic.setPicture(filename);
            mechanicRepository.save(mechanic);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


}
