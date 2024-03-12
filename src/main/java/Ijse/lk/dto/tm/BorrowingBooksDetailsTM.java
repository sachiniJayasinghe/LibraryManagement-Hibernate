package Ijse.lk.dto.tm;

import java.time.LocalDate;

/**
 * @author : L.H
 * @date : 2024-03-11
 * @since : 0.1.0
 **/
public class BorrowingBooksDetailsTM {
    private String borrowId;

    private String bookId;

    private String userId;
    private LocalDate BorrowDate ;

    private LocalDate returnDate ;

    public BorrowingBooksDetailsTM() {
    }

    public BorrowingBooksDetailsTM(String borrowId, String bookId, String userId, LocalDate borrowDate, LocalDate returnDate) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.userId = userId;
        BorrowDate = borrowDate;
        this.returnDate = returnDate;
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
        return "BorrowingBooksDetailsTM{" +
                "borrowId='" + borrowId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", BorrowDate=" + BorrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
