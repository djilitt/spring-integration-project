package com.projectSPI.etudiant.DTO;

import java.time.LocalDate;

public class BorrowRequestDTO {

    private String StudentMatricule;

    private Long userId;

    private Long bookId;
    private LocalDate checkoutDate;
    private LocalDate returnDate;


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    public String getStudentMatricule() {
        return StudentMatricule;
    }

    public void setStudentMatricule(String studentMatricule) {
        StudentMatricule = studentMatricule;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
