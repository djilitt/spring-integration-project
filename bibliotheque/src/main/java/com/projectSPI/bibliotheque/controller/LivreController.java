package com.projectSPI.bibliotheque.controller;

import com.projectSPI.bibliotheque.entity.Livre;
import com.projectSPI.bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class LivreController {

    @Autowired
    private LivreRepository livreRepository;

    @GetMapping("/livre")
    public ResponseEntity<List<Livre>> getAllLivres(@RequestParam(required = false) String title){
        try{
            List<Livre> livres = new ArrayList<Livre>();
            if(title == null) {
                livreRepository.findAll().forEach(livres::add);
            }
            else {
                System.out.println("title != nulll");
                livreRepository.findByTitleContaining(title).forEach(livres::add);
            }
            if(livres.isEmpty()){
                System.out.println("livre is empty");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                System.out.println("livre is not empty");

                return  new ResponseEntity<List<Livre>>(livres,HttpStatus.OK);

            }
        }catch (Exception e){

            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/generateRandomNames")
//    public List<String> generateRandomNames() {
//        List<String> randomNames = new ArrayList<>();
//        Faker faker = new Faker();
//
//        for (int i = 0; i < 10; i++) {
//            String randomName = faker.name().fullName();
//            randomNames.add(randomName);
//        }
//
//        // Print the generated names
//        for (String name : randomNames) {
//            System.out.println(name);
//        }
//
//        return randomNames;
//    }
//
//
//    @GetMapping("/generateRandomData")
//    public ResponseEntity<String> generateRandomData() {
//        try {
//            List<Livre> randomLivres = new ArrayList<>();
//            Faker faker = new Faker();
//            Random random = new Random();
//
//            for (int i = 0; i < 10; i++) {
//                String randomTitle = faker.book().title();
//                String randomAuteur = faker.book().author();
//                String randomDate = faker.date().birthday().toString();
//                boolean randomDisponibilite = random.nextBoolean();
//
//                Livre livre = new Livre(randomTitle, randomAuteur, randomDate, randomDisponibilite);
//                randomLivres.add(livre);
//            }
//
//            // Save the generated Livres to the repository
//            livreRepository.saveAll(randomLivres);
//
//            return new ResponseEntity<>("Random data inserted successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to insert random data", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


    @GetMapping("/livre/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable("id") long id){
        Optional<Livre> livre= livreRepository.findById(id);
        if(livre.isPresent()){
            return new ResponseEntity<Livre>(livre.get(), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }


//    @PostMapping("Livre")
//    public ResponseEntity<Livre> createLivre(@RequestBody Livre livre){
//        try{
//            Livre _livre = livreRepository
//                    .save(new Livre(livre.getTitle(),livre.getAuteur(),livre.getDate()));
//            return new ResponseEntity<Livre>(_livre,HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
