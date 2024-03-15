package Ijse.lk.entity;

import Ijse.lk.embedded.BorrowingBooksDetailPK;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "borrowingBooksDetails")
public class BorrowingBooksDetail {

    @Id
    @Column(name = "borrow_id",length = 30)
    private String borrowId;

    @Column(name = "borrowDate")
    private LocalDate BorrowDate ;

    @Column(name = "returnDate")
    private LocalDate returnDate ;

    @Column(name = "cost")
    private double cost;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User users;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    public BorrowingBooksDetail() {
    }

    public BorrowingBooksDetail(String borrowId, LocalDate borrowDate, LocalDate returnDate, double cost, User users, Book book) {
        this.borrowId = borrowId;
        BorrowDate = borrowDate;
        this.returnDate = returnDate;
        this.cost = cost;
        this.users = users;
        this.book = book;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
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

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BorrowingBooksDetail{" +
                "borrowId='" + borrowId + '\'' +
                ", BorrowDate=" + BorrowDate +
                ", returnDate=" + returnDate +
                ", cost=" + cost +
                '}';
    }
}
