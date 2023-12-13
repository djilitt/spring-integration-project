package com.projectSPI.etudiant.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Etudiants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nom;
    private String Matricule;
    private String Departement;

    // No-argument constructor is required by JPA
    public Etudiants() {
    }

    // Constructor with fields
    public Etudiants(String prenom, String nom, String matricule, String departement) {
        this.prenom = prenom;
        this.nom = nom;
        this.Matricule = matricule;
        this.Departement = departement;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        this.Matricule = matricule;
    }

    public String getDepartement() {
        return Departement;
    }

    public void setDepartement(String departement) {
        this.Departement = departement;
    }
}
