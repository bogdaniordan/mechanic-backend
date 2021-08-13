package com.mechanicservice.controller;

import com.mechanicservice.model.Message;
import com.mechanicservice.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/messages")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/by-appointment/{id}")
    public ResponseEntity<List<Message>> getMessagesByAppointment(@PathVariable Long id) {
        return new ResponseEntity<>(messageService.getMessagesByAppointment(id), HttpStatus.OK);
    }

    @PostMapping("/{appointmentId}")
    public ResponseEntity<Message> addMessage(@RequestBody Message message,
                                              @PathVariable Long appointmentId) {
        log.info("Adding a new message to the chat of appointment with id: " + appointmentId);
        return new ResponseEntity<>(messageService.addMessage(message, appointmentId), HttpStatus.OK);
    }
}
