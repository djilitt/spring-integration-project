package com.projectSPI.bibliotheque.controller;

import com.projectSPI.bibliotheque.entity.User;
import com.projectSPI.bibliotheque.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name){
        try{
            List<User> users = new ArrayList<User>();
//            if(name == null) {
//                System.out.println("name === nulll");
//                UserRepository.findAll().forEach(users::add);
//            }
//            else {
//                System.out.println("name != nulll");
//                UserRepository.findBynameContaining(name).forEach(users::add);
//            }

            if(users.isEmpty()){
                System.out.println("usres is empty");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                System.out.println("usres is not empty");

                return  new ResponseEntity<List<User>>(users,HttpStatus.OK);

            }
        }catch (Exception e){

            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}