package com.project.service;


import com.project.model.Address;
import com.project.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;


@MessagingGateway
public interface IntegrationGetway {


    @Gateway(requestChannel = "router.channel")
    public <T> void process(T object);
}


