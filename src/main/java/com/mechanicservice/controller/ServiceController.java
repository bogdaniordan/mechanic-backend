package com.mechanicservice.controller;

import com.mechanicservice.dto.ServiceTypeDTO;
import com.mechanicservice.model.ServiceType;
import com.mechanicservice.service.MechanicService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/services")
@AllArgsConstructor
public class ServiceController {

    private final MechanicService mechanicService;

    @GetMapping("/get-service-types")
    public ResponseEntity<List<ServiceTypeDTO>> getAllServiceTypes() {
        List<ServiceTypeDTO> serviceTypeDTOS = new ArrayList<>();
        for (ServiceType serviceType: ServiceType.values()) {
            serviceTypeDTOS.add(new ServiceTypeDTO(serviceType));
        }
        return new ResponseEntity<>(serviceTypeDTOS, HttpStatus.OK);
    }

    @GetMapping("/most-needed-service")
    public ResponseEntity<ServiceTypeDTO> getMostNeededSpecialization() {
        log.info("Fetching most needed specialization.");
        return new ResponseEntity<>(mechanicService.getMostNeededSpecialization(),  HttpStatus.OK);
    }

}
