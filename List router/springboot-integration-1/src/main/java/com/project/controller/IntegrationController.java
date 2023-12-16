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

    @PostMapping("/student")
    public void processStudentDetail(@RequestBody Student student){
        integrationGetway.process(student);
    }


}
