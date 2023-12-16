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
    public boolean processBorrowRequest(BorrowRequestDTO borrowRequest) {
        // 1. Check if the book is available
        Livre book = livreRepository.findById(borrowRequest.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"));
        if (!book.isDisponibilite()) {
            System.out.println("Book is not available") ;
            return false;

        }


        else {
        // 2. Update the book's availability
        book.setDisponibilite(false);
        livreRepository.save(book);

        // 3. Create an Emprunt record
        Emprunt emprunt;
        if (borrowRequest.getUserId() != null) {
            // Borrowing by LMS User
            User user = userRepository.findById(borrowRequest.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            emprunt = new Emprunt(user, book, borrowRequest.getCheckoutDate(), borrowRequest.getReturnDate());
            System.out.println("user 36awhlne");
            empruntRepository.save(emprunt);
        } if(borrowRequest.getStudentMatricule() != null) {
            // Borrowing by External System Student
            // Assume studentMatricule is provided in BorrowRequestDTO
            emprunt = new Emprunt(borrowRequest.getStudentMatricule(), book, borrowRequest.getCheckoutDate(), borrowRequest.getReturnDate());
            System.out.println(" 36awlne matricule");
            empruntRepository.save(emprunt);
        }
        else{
            System.out.println("dele");
        }
    return true;

    }}


}
