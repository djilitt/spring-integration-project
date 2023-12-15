package com.projectSPI.etudiant.Services;

import com.projectSPI.etudiant.DTO.BorrowRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmpruntService {

    private static final Logger logger = LoggerFactory.getLogger(EmpruntService.class);

    @Autowired
    private MessageChannel requestChannel;

    public boolean borrowBook(Long userId, Long bookId, LocalDate checkoutDate, LocalDate returnDate) {
        BorrowRequestDTO requestDTO = new BorrowRequestDTO();
        requestDTO.setUserId(userId);
        requestDTO.setBookId(bookId);
        requestDTO.setCheckoutDate(checkoutDate);
        requestDTO.setReturnDate(returnDate);

        Message<BorrowRequestDTO> message = MessageBuilder.withPayload(requestDTO)
                .setHeader("Content-Type", "application/json")
                .build();

        try {
            this.requestChannel.send(message);
            // If you have a mechanism to check the response, include it here
            return true; // Indicates successful operation
        } catch (MessagingException e) {
            logger.error("Error sending message to LMS", e);
            return false; // Indicates failure
        }
    }
}
