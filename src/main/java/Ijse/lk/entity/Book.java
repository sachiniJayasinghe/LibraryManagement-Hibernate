package Ijse.lk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "book_id")
    private Long book_id;
    @Column(name = "title")

    private String title;
    @Column(name = "author")

    private String author ;

    @Column(name = "genre")

    private String genre;

    @Column(name = "availability")


    private Long availability;

    public Book() {

    }

    public Book(Long book_id, String title, String author, String genre, Long availability) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
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

    public Long getAvailability() {
        return availability;
    }

    public void setAvailability(Long availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availability=" + availability +
                '}';
    }
}
