package com.project.controller;

import com.project.model.Address;
import com.project.model.Student;
import com.project.service.IntegrationGetway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/integrate")
public class IntegrationController {
    @Autowired
    private IntegrationGetway integrationGetway;

    @PostMapping("/student")
    public void processStudentDetails(@RequestBody Student student){
        integrationGetway.process(student);
    }

    @PostMapping("/address")
    public void processAddressDetails(@RequestBody Address address){
        integrationGetway.process(address);
    }

}
