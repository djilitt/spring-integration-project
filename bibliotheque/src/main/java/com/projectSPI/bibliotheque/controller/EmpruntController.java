package com.projectSPI.bibliotheque.controller;

import com.projectSPI.bibliotheque.entity.Emprunt;
import com.projectSPI.bibliotheque.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpruntController {
    @Autowired
    private EmpruntRepository  EmpruntRepository;

    @GetMapping("/Emprunt")
    public ResponseEntity<List<Emprunt>> getAllEmprunt() {
        List<Emprunt> emprunts = EmpruntRepository.findAll();
        return new ResponseEntity<>(emprunts, HttpStatus.OK);
    }
    
}
