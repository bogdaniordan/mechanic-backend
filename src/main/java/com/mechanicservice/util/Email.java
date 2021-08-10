package com.mechanicservice.util;

import com.mechanicservice.model.Appointment;
import com.mechanicservice.model.Customer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    public static void send(String recipient, Customer customer, Appointment appointment) throws MessagingException {
        System.out.println("Preparing to send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        // below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        String myEmail = "bogdan.iordan47@gmail.com";
        String pass = "password123";


        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, pass);
            }
        });

        Message message = prepareMessage(session, myEmail, recipient, customer, appointment);
        assert message != null;
        Transport.send(message);
        System.out.println("Message sent");

    }

    // add one with user and password for registration

    private static Message prepareMessage(Session session, String myEmail, String recipient, Customer customer, Appointment appointment) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Welcome to PetBox !");
            message.setText("Hello " + customer.getName() +  " and thank you for using Nea Bebe car services, you have an appointment with " +appointment.getMechanic() + " for the following service: " + appointment.getRequiredservice().upperCaseName);
            return message;
        } catch (Exception e) {
            System.out.println("error");
            return null;
        }
    }
}
