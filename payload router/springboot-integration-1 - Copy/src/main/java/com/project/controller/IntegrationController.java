package com.project.controller;

import com.project.model.Student;
import com.project.service.IntegrationGetway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/integrate")
public class IntegrationController {
    @Autowired
    private IntegrationGetway integrationGetway;

    @GetMapping(value = "{name}")
    public String getMessageFromIntegrationService(@PathVariable("name") String name){
        return integrationGetway.sendMessage(name);
    }

    @PostMapping
    public  String processstudentDetails(@RequestBody Student student){
        return integrationGetway.processStudentDetails(student);
    }

}
