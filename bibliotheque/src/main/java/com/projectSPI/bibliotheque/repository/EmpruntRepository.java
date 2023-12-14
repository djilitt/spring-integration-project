package com.projectSPI.bibliotheque.repository;

import com.projectSPI.bibliotheque.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    // Custom methods if needed
}