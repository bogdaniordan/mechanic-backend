package com.mechanicservice.service;

import com.mechanicservice.model.Appointment;
import com.mechanicservice.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private final AppointmentService appointmentService;

    public List<Message> getMessagesByAppointment(Long appointmentId) {
        Appointment appointment = appointmentService.findById(appointmentId);
        return appointment.getMessages();
    }
}
