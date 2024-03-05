package Ijse.lk.controller;

import Ijse.lk.bo.BOFactory;
import Ijse.lk.bo.custom.BookBO;
import Ijse.lk.dto.BookDto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;



public class BookFormController {

    @FXML
    private TextField txtAuthor1;

    @FXML
    private TextField txtAvailability1;

    @FXML
    private TextField txtBookId1;

    @FXML
    private TextField txtGenre1;

    @FXML
    private TextField txtTitle1;


    @FXML
    private TableView<BookDto> tblBook;



    BookBO bookBO= (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Book);

    public void initialize() {
        tblBook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("book_id"));
        tblBook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("title"));
        tblBook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("genre"));
        tblBook.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("availability"));

        loadAllBook();
    }

    public void txtSearchOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void btnBackOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void btnClearOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(javafx.event.ActionEvent actionEvent) {
        long book_id = Long.parseLong(txtBookId1.getText());
        String title = txtTitle1.getText();
        String author=txtAuthor1.getText();
        String genre=txtGenre1.getText();
        long availability= Long.parseLong(txtAvailability1.getText());
        try {
            bookBO.updateBook(new BookDto(book_id,title,author,genre,availability));
            loadAllBook();
            new Alert(Alert.AlertType.CONFIRMATION,"Book Updated Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Book Updated Not Successful!", ButtonType.OK).show();
        }


    }

    public void btnDeleteOnAction(javafx.event.ActionEvent actionEvent) {
        long book_id = Long.parseLong(txtBookId1.getText());
        try {
            bookBO.deleteBook(book_id);
            tblBook.refresh();
            loadAllBook();
            new Alert(Alert.AlertType.CONFIRMATION,"Book Deleted Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Book Deleted  Not Successful!", ButtonType.OK).show();
        }

    }

    public void btnSaveOnAction(javafx.event.ActionEvent actionEvent) {
        long book_id = Long.parseLong(txtBookId1.getText());
        String title = txtTitle1.getText();
        String author=txtAuthor1.getText();
        String genre=txtGenre1.getText();
        long availability= Long.parseLong(txtAvailability1.getText());

        try {
            bookBO.addBook(new BookDto(book_id,title,author,genre,availability));
            loadAllBook();
            new Alert(Alert.AlertType.CONFIRMATION,"Book Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Book Added Not Successful!", ButtonType.OK).show();
        }
    }
    private void loadAllBook() {
        tblBook.getItems().clear();
        ObservableList<BookDto> items = (ObservableList<BookDto>) tblBook.getItems();
        try {
            //*Get all customers*//*
            List<BookDto> allBook = bookBO.getAllBook();
            System.out.println(allBook);

            for (BookDto b : allBook) {
                items.add(new BookDto(b.getBook_id(), b.getTitle(), b.getAuthor(), b.getGenre(), b.getAvailability()));
                System.out.println(b.getAvailability());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
