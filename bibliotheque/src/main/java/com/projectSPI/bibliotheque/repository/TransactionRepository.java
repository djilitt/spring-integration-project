package com.projectSPI.bibliotheque.repository;

import com.projectSPI.bibliotheque.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Custom methods if needed
}