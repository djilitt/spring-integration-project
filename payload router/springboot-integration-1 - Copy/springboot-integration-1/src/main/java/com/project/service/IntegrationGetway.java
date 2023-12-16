package com.project.service;


import com.project.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;


@MessagingGateway
public interface IntegrationGetway {


    @Gateway(requestChannel = "integration.gateway.channel")
    public String sendMessage(String message);

    @Gateway(requestChannel = "integration.student.gateway.channel")
    public String processStudentDetails(Student Student);
}


