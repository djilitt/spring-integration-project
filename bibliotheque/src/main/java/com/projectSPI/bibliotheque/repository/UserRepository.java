package com.projectSPI.bibliotheque.repository;

import com.projectSPI.bibliotheque.entity.Livre;
import com.projectSPI.bibliotheque.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findBynameContaining(String name);
}