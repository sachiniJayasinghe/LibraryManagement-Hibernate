package Ijse.lk.dto.tm;

import java.time.LocalDate;

public class BorrowingBooksDetailsTM {
    private String borrowId;

    private LocalDate BorrowDate ;

    private LocalDate returnDate ;
    private double cost;
    private String bookId;

    private String userId;

    public BorrowingBooksDetailsTM(String borrowId, LocalDate borrowDate, LocalDate returnDate, double cost, String userId, String bookId) {
        this.borrowId = borrowId;
        this.BorrowDate = borrowDate;
        this.returnDate = returnDate;
        this.cost =cost;
        this.bookId = bookId;
        this.userId = userId;
    }

    public BorrowingBooksDetailsTM() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BorrowingBooksDetailsTM{" +
                "borrowId='" + borrowId + '\'' +
                ", BorrowDate=" + BorrowDate +
                ", returnDate=" + returnDate +
                ", cost=" + cost +
                '}';
    }
}
