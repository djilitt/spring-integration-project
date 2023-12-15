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



	}

}