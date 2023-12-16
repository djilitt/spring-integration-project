package com.projectSPI.bibliotheque.controller;

import com.projectSPI.bibliotheque.DTO.BorrowRequestDTO;
import com.projectSPI.bibliotheque.entity.Emprunt;
import com.projectSPI.bibliotheque.entity.Livre;
import com.projectSPI.bibliotheque.entity.User;
import com.projectSPI.bibliotheque.repository.EmpruntRepository;
import com.projectSPI.bibliotheque.repository.LivreRepository;
import com.projectSPI.bibliotheque.repository.UserRepository;
import com.projectSPI.bibliotheque.service.LivreEmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.github.javafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntRepository empruntRepository;

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private UserRepository userRepository;

    private final LivreEmpruntService livreEmpruntService;

    public EmpruntController(LivreEmpruntService livreEmpruntService) {
        this.livreEmpruntService = livreEmpruntService;
    }

    @PostMapping("/Emprunt")
    public ResponseEntity<?> borrowBook(@RequestBody BorrowRequestDTO borrowRequest) {
        livreEmpruntService.processBorrowRequest(borrowRequest);
        return ResponseEntity.ok().body("Book borrowed successfully");
    }

//    @GetMapping("/generateRandomData")
//    public ResponseEntity<String> generateRandomEmpruntData() {
//        try {
//            List<Emprunt> randomEmprunts = new ArrayList<>();
//            Faker faker = new Faker();
//
//            // Assuming you have repositories for User and Livre
//            List<User> users = userRepository.findAll();
//            List<Livre> livres = livreRepository.findAll();
//
//            for (int i = 0; i < 10; i++) {
//                User randomUser = getRandomElement(users, faker);
//                Livre randomLivre = getRandomElement(livres, faker);
//
//                LocalDate randomCheckoutDate = faker.date().future(180, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//                LocalDate randomReturnDate = randomCheckoutDate.plusDays(faker.number().numberBetween(7, 30));
//
//                Emprunt emprunt = new Emprunt();
//                emprunt.setUser(randomUser);
//                emprunt.setLivre(randomLivre);
//                emprunt.setCheckoutDate(randomCheckoutDate);
//                emprunt.setReturnDate(randomReturnDate);
//
//                randomEmprunts.add(emprunt);
//            }
//
//            // Save the generated Emprunts to the repository
//            empruntRepository.saveAll(randomEmprunts);
//
//            return new ResponseEntity<>("Random data inserted successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to insert random data", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    // Helper method to get a random element from a list
//    private <T> T getRandomElement(List<T> list, Faker faker) {
//        return list.get(faker.number().numberBetween(0, list.size()));
//    }


}
