package com.mechanicservice.service;

import com.mechanicservice.model.Appointment;
import com.mechanicservice.model.Message;
import com.mechanicservice.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private final AppointmentService appointmentService;
    private final MessageRepository messageRepository;

    public List<Message> getMessagesByAppointment(Long appointmentId) {
        Appointment appointment = appointmentService.findById(appointmentId);
        return appointment.getMessages();
    }

    public Message addMessage(Message message, Long appointmentId) {
        messageRepository.save(message);
        Appointment appointment = appointmentService.findById(appointmentId);
        appointment.addMessage(message);
        appointmentService.save(appointment);
        return message;
    }
}
