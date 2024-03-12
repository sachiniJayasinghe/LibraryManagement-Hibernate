package Ijse.lk.dto;

import javax.persistence.Column;

public class BookDto {
    private String book_id;

    private String title;

    private String author ;

    private String genre;

    private String availability;

    private String branch_id;

    public BookDto() {
    }

    public BookDto(String book_id, String title, String author, String genre, String availability, String branch_id) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
        this.branch_id = branch_id;
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

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "book_id='" + book_id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availability='" + availability + '\'' +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }
}
