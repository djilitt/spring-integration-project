package com.projectSPI.etudiant.Controllers;

import com.projectSPI.etudiant.DTO.BorrowRequestDTO;
import com.projectSPI.etudiant.Entities.Etudiants;
import com.projectSPI.etudiant.Repositories.EtudiantRepository;
import com.projectSPI.etudiant.Services.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EtudiantController {

    @Autowired
    private EtudiantRepository EtudiantRepository;

    @Autowired
    private EmpruntService empruntService;


    @GetMapping("/Etudiant")
    public ResponseEntity<List<Etudiants>> getAllEtudiants() {
        List<Etudiants> etudiants = EtudiantRepository.findAll();
        if (etudiants.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(etudiants);
        }
    }

    @GetMapping("/Etudiant/{id}")
    public ResponseEntity<Etudiants> getEtudiantById(@PathVariable("id") long id){
        Optional<Etudiants> Etudiant= EtudiantRepository.findById(id);
        if(Etudiant.isPresent()){
            return new ResponseEntity<Etudiants>(Etudiant.get(), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }
    @PostMapping("/EmpruntSms")
    public ResponseEntity<String> borrowBook(@RequestBody BorrowRequestDTO borrowRequestDTO) {
        boolean success = empruntService.borrowBook(borrowRequestDTO.getStudentMatricule(),borrowRequestDTO.getUserId(), borrowRequestDTO.getBookId(), borrowRequestDTO.getCheckoutDate(), borrowRequestDTO.getReturnDate());
        System.out.println(borrowRequestDTO.getStudentMatricule());
        if (success) {
            return ResponseEntity.ok("Borrow request processed successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to process borrow request.");
        }
    }

}
