package com.mechanicservice.controller;

import com.mechanicservice.model.Mechanic;
import com.mechanicservice.service.MechanicService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/mechanics")
@AllArgsConstructor
public class MechanicController {

    private MechanicService mechanicService;

    @GetMapping
    public ResponseEntity<List<Mechanic>> getAllMechanics() {
        log.info("Fetching all mechanics.");
        List<Mechanic> mechanics = mechanicService.getAllMechanics();
        return new ResponseEntity<>(mechanics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mechanic> getMechanic(@PathVariable Long id) {
        log.info("Fetching mechanic with id: " + id);
        Mechanic mechanic = mechanicService.getMechanic(id);
        return new ResponseEntity<>(mechanic, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Mechanic> addMechanic(@RequestBody Mechanic mechanic) {
        log.info("Saving a new mechanic");
        Mechanic savedMechanic = mechanicService.addMechanic(mechanic);
        return new ResponseEntity<>(savedMechanic, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mechanic> updateMechanic(@RequestBody Mechanic mechanic,
                                                   @PathVariable Long id) {
        log.info("Updating mechanic with id: " + mechanic.getId());
        Mechanic updatedMechanic = mechanicService.updateMechanic(mechanic, id);
        return new ResponseEntity<>(updatedMechanic, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMechanic(@PathVariable Long id)  {
        log.info("Trying to delete mechanic with id:"  + id);
        Mechanic mechanic = mechanicService.deleteById(id);
        if (mechanic == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-specialization/{specialization}")
    public ResponseEntity<List<Mechanic>> getMechanicsBySpecialization(@PathVariable String specialization) {
        log.info("Fetching mechanics with specialization: " + specialization);
        List<Mechanic> mechanics = mechanicService.getMechanicsBySpecialization(specialization);
        return new ResponseEntity<>(mechanics, HttpStatus.OK);
    }

    @PostMapping("/hire-mechanic")
    public ResponseEntity<Boolean> hireMechanic(@RequestBody Mechanic mechanic) {
        Boolean hired = mechanicService.hireMechanic(mechanic);
        return new ResponseEntity<>(hired, HttpStatus.OK);
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<Mechanic> getByName(@PathVariable String name) {
        return new ResponseEntity<>(mechanicService.getMechanicByName(name), HttpStatus.OK);
    }

    @GetMapping("/image/{mechanicId}/download")
    public byte[] downloadImage(@PathVariable Long mechanicId) {
        log.info("Fetching image for mechanic: " + mechanicId);
        return mechanicService.downloadImage(mechanicId);
    }

    @PostMapping(
            path = "/image/upload/{mechanicId}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadMechanicProfileImage(@PathVariable("mechanicId") Long mechanicId,
                                           @RequestParam("file") MultipartFile file) {
        log.info("Uploading image for mechanic with id: " + mechanicId);
        mechanicService.uploadMechanicProfileImage(mechanicId, file);
    }
}
