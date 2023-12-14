package com.projectSPI.bibliotheque;

import com.projectSPI.bibliotheque.entity.Livre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BibliothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);

			Livre livre = new Livre();

			// Définition des valeurs
			livre.setId(1);
			livre.setTitle("Titre du livre");
			livre.setAuteur("Auteur du livre");

			// Vérification des valeurs
	}

}
