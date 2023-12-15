package com.projectSPI.bibliotheque.controller;

import com.projectSPI.bibliotheque.DTO.BorrowRequestDTO;
import com.projectSPI.bibliotheque.entity.Emprunt;
import com.projectSPI.bibliotheque.repository.EmpruntRepository;
import com.projectSPI.bibliotheque.service.LivreEmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpruntController {
    @Autowired
    private EmpruntRepository  EmpruntRepository;

    private final LivreEmpruntService livreEmpruntService;

    public EmpruntController(LivreEmpruntService livreEmpruntService) {
        this.livreEmpruntService = livreEmpruntService;
    }
    @PostMapping("/Emprunt")
    public ResponseEntity<?> borrowBook(@RequestBody BorrowRequestDTO borrowRequest) {
        try {
            livreEmpruntService.processBorrowRequest(borrowRequest);
            return ResponseEntity.ok().body("Book borrowed successfully");
        } catch (RuntimeException e) {
            // Return an error response if there is a runtime exception (e.g., book/user not found, book not available)
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        // You might want to handle other types of exceptions as well
    }
    
}
