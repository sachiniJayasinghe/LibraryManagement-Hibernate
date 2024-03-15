package Ijse.lk.dto;


import java.time.LocalDate;

public class BorrowingBooksDetailDto {
    private String borrowId;
    private LocalDate BorrowDate;

    private LocalDate returnDate;
    private double cost;
    private String id;


    private String bookId;


    public BorrowingBooksDetailDto(String borrowId, LocalDate borrowDate, LocalDate returnDate, double cost, String id, String bookId) {
        this.borrowId = borrowId;
        BorrowDate = borrowDate;
        this.returnDate = returnDate;
        this.cost = cost;
        this.id = id;
        this.bookId = bookId;
    }

    public BorrowingBooksDetailDto() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "BorrowingBooksDetailDto{" +
                "borrowId='" + borrowId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", id='" + id + '\'' +
                ", BorrowDate=" + BorrowDate +
                ", returnDate=" + returnDate +
                ", cost=" + cost +
                '}';
    }
}