package com.projectSPI.bibliotheque.service;

import com.projectSPI.bibliotheque.DTO.BorrowRequestDTO;
import com.projectSPI.bibliotheque.entity.Emprunt;
import com.projectSPI.bibliotheque.entity.Livre;
import com.projectSPI.bibliotheque.entity.User;
import com.projectSPI.bibliotheque.repository.EmpruntRepository;
import com.projectSPI.bibliotheque.repository.LivreRepository;
import com.projectSPI.bibliotheque.repository.UserRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LivreEmpruntService {
    private final LivreRepository livreRepository;
    private final EmpruntRepository empruntRepository;
    private final UserRepository    userRepository;

    public LivreEmpruntService(LivreRepository livreRepository, EmpruntRepository empruntRepository, UserRepository userRepository) {
        this.livreRepository = livreRepository;
        this.empruntRepository = empruntRepository;
        this.userRepository = userRepository; // Initialize the UserRepository

    }

    @Transactional
    public void processBorrowRequest(BorrowRequestDTO borrowRequest) {
        // 1. Check if the book is available
        Livre book = livreRepository.findById(borrowRequest.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"));
        if (!book.isDisponibilite()) {
            throw new RuntimeException("Book is not available");
        }

        // 2. Update the book's availability
        book.setDisponibilite(false);
        livreRepository.save(book);

        // 3. Create an Emprunt record
        Emprunt emprunt = new Emprunt();
        // Assuming you have a method to find a User by ID
        User user = userRepository.findById(borrowRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Set properties of emprunt based on borrowRequest
        emprunt.setUser(user);
        emprunt.setLivre(book);
        emprunt.setCheckoutDate(borrowRequest.getCheckoutDate());
        emprunt.setReturnDate(borrowRequest.getReturnDate()); // Only set this if your DTO includes a return date

        empruntRepository.save(emprunt);
    }
}
