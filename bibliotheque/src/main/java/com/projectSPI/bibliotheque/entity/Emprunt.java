package com.projectSPI.bibliotheque.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Livre livre;

    private Integer studentMatricule;
    private LocalDate checkoutDate;
    private LocalDate returnDate;

    public Long getId() {
        return id;
    }

    // Constructor for LMS User
    public Emprunt(User user, Livre livre, LocalDate checkoutDate, LocalDate returnDate) {
        this.user = user;
        this.livre = livre;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    // Constructor for External System (SMS) Student
    public Emprunt(Integer studentMatricule, Livre livre, LocalDate checkoutDate, LocalDate returnDate) {
        // Assuming you have a field to store external system identifier
        this.studentMatricule = studentMatricule;
        this.livre = livre;
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStudentMatricule() {
        return studentMatricule;
    }

    public void setStudentMatricule(Integer studentMatricule) {
        this.studentMatricule = studentMatricule;
    }
}