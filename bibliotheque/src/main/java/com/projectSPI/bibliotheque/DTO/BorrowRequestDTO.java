package com.projectSPI.bibliotheque.DTO;

import java.time.LocalDate;

public class BorrowRequestDTO {

    private Long userId;
    private  Long bookId;
    private LocalDate checkoutDate;
    private LocalDate returnDate;

    public  long getBookId() {
        return bookId;

    }

    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public  LocalDate getCheckoutDate() {
        return checkoutDate;
    }



    public  LocalDate getReturnDate() {
        return returnDate;
    }


}
