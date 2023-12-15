package com.projectSPI.bibliotheque.repository;

import com.projectSPI.bibliotheque.entity.Livre;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByTitleContaining(String title);

}
