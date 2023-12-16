package com.projectSPI.bibliotheque.controller;

import com.projectSPI.bibliotheque.entity.User;
import com.projectSPI.bibliotheque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name) {
        try {
            List<User> users = new ArrayList<>();
            if (name == null) {
                userRepository.findAll().forEach(users::add);
            } else {
                userRepository.findBynameContaining(name).forEach(users::add);
            }

            if (users.isEmpty()) {
                System.out.println("users is empty");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                System.out.println("users is not empty");
                return new ResponseEntity<>(users, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/generateRandomData")
//    public ResponseEntity<String> generateRandomUserData() {
//        try {
//            List<User> randomUsers = new ArrayList<>();
//            Faker faker = new Faker();
//
//            for (int i = 0; i < 10; i++) {
//                String randomName = faker.name().fullName();
//                String randomEmail = faker.internet().emailAddress();
//
//                User user = new User();
//                user.setName(randomName);
//                user.setEmail(randomEmail);
//
//                randomUsers.add(user);
//            }
//
//            // Save the generated Users to the repository
//            userRepository.saveAll(randomUsers);
//
//            return new ResponseEntity<>("Random data inserted successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to insert random data", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
