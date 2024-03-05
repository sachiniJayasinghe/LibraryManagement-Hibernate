package Ijse.lk.dto;

import javax.persistence.Column;

public class BookDto {
    private Long book_id;

    private String title;

    private String author ;

    private String genre;


    private Long availability;

    public BookDto() {
    }

    public BookDto(Long book_id, String title, String author, String genre, Long availability) {
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
        return "BookDto{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availability=" + availability +
                '}';
    }
}
