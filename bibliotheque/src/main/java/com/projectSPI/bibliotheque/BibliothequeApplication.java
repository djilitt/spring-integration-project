package com.projectSPI.bibliotheque;

import com.projectSPI.bibliotheque.controller.LivreController;
import com.projectSPI.bibliotheque.entity.Livre;
import com.projectSPI.bibliotheque.repository.LivreRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

import static com.projectSPI.bibliotheque.controller.LivreController.*;


@SpringBootApplication
public class BibliothequeApplication {


	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);

			Livre livre = new Livre();

			// Définition des valeurs

			livre.setTitle("Titre du livre");
			livre.setAuteur("Auteur du livre");


			// Vérification des valeurs
		// Vérification des valeurs en les imprimant dans la console

		System.out.println("Titre du livre : " + livre.getTitle());
		System.out.println("Auteur du livre : " + livre.getAuteur());


	}

}
