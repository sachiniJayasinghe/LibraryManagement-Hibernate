package Ijse.lk.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class BorrowingBooksDetailPK implements Serializable {
    @Column(name = "user_id")
    private String userId;

    @Column(name = "book_id")
    private String bookId;

    public BorrowingBooksDetailPK() {
    }

    public BorrowingBooksDetailPK(String userId, String bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BorrowingBooksDetailPK{" +
                "userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}
