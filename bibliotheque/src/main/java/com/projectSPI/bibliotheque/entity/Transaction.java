package com.projectSPI.bibliotheque.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Livre livre;

    private LocalDate checkoutDate;
    private LocalDate returnDate;
    // other fields and getters/setters
}