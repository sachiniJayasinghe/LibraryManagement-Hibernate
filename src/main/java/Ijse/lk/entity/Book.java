package Ijse.lk.entity;

import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "book_id",length = 30)
    private String book_id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "availability")
    private String availability;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id")
    private Branch branch;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "book")
    private List<BorrowingBooksDetail> borrowingBooksDetails = new ArrayList<>();

    public Book(String book_id, String title, String author, String genre, String availability, Branch branch, List<BorrowingBooksDetail> borrowingBooksDetails) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
        this.branch = branch;
        this.borrowingBooksDetails = borrowingBooksDetails;
    }

    public Book() {

    }

    public Book(String bookId, String title, String author, String genre, String availability, Branch branch) {
        this.book_id = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
        this.branch = branch;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<BorrowingBooksDetail> getBorrowingBooksDetails() {
        return borrowingBooksDetails;
    }

    public void setBorrowingBooksDetails(List<BorrowingBooksDetail> borrowingBooksDetails) {
        this.borrowingBooksDetails = borrowingBooksDetails;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id='" + book_id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availability='" + availability + '\'' +
                ", branch=" + branch +
                ", borrowingBooksDetails=" + borrowingBooksDetails +
                '}';
    }
}
