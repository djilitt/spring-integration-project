package com.projectSPI.bibliotheque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String title;

    private String auteur;

    private String date_entre;
    private boolean Disponibilite;

    public  Livre(){

    }
    public Livre(String title, String auteur, String date_entre,boolean  Dispo) {
        this.title=title;
        this.auteur=auteur;
        this.date_entre=date_entre;
        this.Disponibilite=Dispo;

    }

    public int getId() {
        return id;
    }

    public boolean isDisponibilite() {
        return Disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        Disponibilite = disponibilite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDate() {
        return date_entre;
    }

    public void setDate(String date_entre) {
        this.date_entre = date_entre;
    }

}
