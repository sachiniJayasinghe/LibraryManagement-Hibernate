package Ijse.lk.dto;

import Ijse.lk.embedded.BorrowingBooksDetailPK;


import javax.persistence.Column;
import java.time.LocalDate;

public class BorrowingBooksDetailDto {
    private String borrowId;

    private String bookId;

    private String userId;
    private LocalDate BorrowDate ;

    private LocalDate returnDate ;

    private double cost;
    public BorrowingBooksDetailDto() {
    }

    public BorrowingBooksDetailDto(String borrowId, String bookId, String userId, LocalDate borrowDate, LocalDate returnDate) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.userId = userId;
        BorrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public BorrowingBooksDetailDto(String borrowId, String bookId, String userId, LocalDate borrowDate, LocalDate returnDate, Double cost) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.userId = userId;
        BorrowDate = borrowDate;
        this.returnDate = returnDate;
        this.cost = cost;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        BorrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowingBooksDetailDto{" +
                "borrowId='" + borrowId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", BorrowDate=" + BorrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}

