package com.project.service;


import com.project.model.Student;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @ServiceActivator(inputChannel = "student.channel.1")
    public void recieveMessage(Message<?> message) throws MessagingException {
        System.out.println("###student.channel.1##");
        System.out.println(message);
        System.out.println(message.getPayload());
    }


    @ServiceActivator(inputChannel = "student.channel.2")
    public void recieveMessage1(Message<?> message) throws MessagingException{
        System.out.println("###student.channel.2##");
        System.out.println(message);
        System.out.println(message.getPayload());
    }

}
