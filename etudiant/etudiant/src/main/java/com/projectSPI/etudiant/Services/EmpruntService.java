package com.projectSPI.etudiant.Services;

import com.projectSPI.etudiant.DTO.BorrowRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class EmpruntService {

    private static final Logger logger = LoggerFactory.getLogger(EmpruntService.class);

    @Autowired
    @Qualifier("requestChannel")
    private MessageChannel requestChannel;

    public boolean borrowBook(Integer studentMatricule, Long userId, Long bookId, LocalDate checkoutDate, LocalDate returnDate) {
        BorrowRequestDTO requestDTO = new BorrowRequestDTO();
        requestDTO.setStudentMatricule(studentMatricule);
        requestDTO.setUserId(userId);
        requestDTO.setBookId(bookId);
        requestDTO.setCheckoutDate(checkoutDate);
        requestDTO.setReturnDate(returnDate);

        CompletableFuture<Boolean> future = new CompletableFuture<>();
        Message<BorrowRequestDTO> message = MessageBuilder.withPayload(requestDTO)
                .setHeader("Content-Type", "application/json")
                .setHeader("ResponseFuture", future)
                .build();
        logger.info("Sending borrow request: {}", requestDTO);

        try {
            this.requestChannel.send(message);
            // Wait for the response with a timeout
            return true; // Adjust the timeout as needed
        } catch (MessagingException e) {
            logger.error("Error sending message to LMS", e);
            return false;
        }
    }
}
