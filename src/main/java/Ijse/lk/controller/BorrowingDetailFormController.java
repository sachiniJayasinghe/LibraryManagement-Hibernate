package Ijse.lk.controller;

import Ijse.lk.bo.BOFactory;
import Ijse.lk.bo.custom.BorrowingBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BorrowingBooksDetailDto;
import Ijse.lk.dto.tm.BorrowingBooksDetailsTM;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class BorrowingDetailFormController {


    @FXML
    private Button btnAdd;

    @FXML
    private DatePicker returnDate;

    @FXML
    private Button btnPay;

    @FXML
    private Button btnViewBill;

    @FXML
    private JFXComboBox<String> cmbBookName;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TextField txtBrwID;

    @FXML
    private TableColumn<?, ?> colBorderId;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TextField txtUsr;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private AnchorPane mainSubPane;

    @FXML
    private TableView<BorrowingBooksDetailsTM> tblBorrow;

    BorrowingBO borrowingBO = (BorrowingBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Borrowing);

    @FXML
    private TextField txtTotal;

    public void initialize() throws Exception {

        tblBorrow.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("borrowId"));
        tblBorrow.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("BorrowDate"));
        tblBorrow.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        tblBorrow.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("cost"));
        tblBorrow.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("bookId"));
        tblBorrow.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("userId"));

        loadAllBorrow();




        returnDate.setValue(LocalDate.now().plusDays(7));

        String id = borrowingBO.getNewBorrowingId();
        txtBrwID.setText(id);
        List<BookDto> allBooks =borrowingBO.searchBook();
        for (BookDto b: allBooks) {

            if (b.getAvailability().equals("Available") || b.getAvailability().equals("available")){
                cmbBookName.getItems().add(b.getBook_id());
            }
        }
        cmbBookName.getItems().addAll();
    }


    private void loadAllBorrow() {

        ObservableList<BorrowingBooksDetailsTM> obList = FXCollections.observableArrayList();

        try {
           List<BorrowingBooksDetailDto> dtoList = borrowingBO.getAllBorrowing();

           for(BorrowingBooksDetailDto dto : dtoList) {
                obList.add(
                        new BorrowingBooksDetailsTM(
                                dto.getBorrowId(),
                                dto.getBorrowDate(),
                                dto.getReturnDate(),
                                dto.getCost(),
                                dto.getId(),
                                dto.getBookId()

                        )
                );
            }

            tblBorrow.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
        String borrowId = borrowingBO.getNewBorrowingId();
        String bookName = cmbBookName.getValue();
        String userId = txtUsr.getText();
        String bookId = cmbBookName.getValue();
        LocalDate date = LocalDate.now();
        LocalDate returnDate = this.returnDate.getValue();
        Double cost = 50.0;

        boolean isAdded = borrowingBO.addBorrowing(borrowId, bookId, userId, date, returnDate,cost);
        if (isAdded){
        new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK).show();
            }else {
        new Alert(Alert.AlertType.ERROR, "Failed", ButtonType.OK).show();

            }
    }

    @FXML
    void btnPayOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewBillOnAction(ActionEvent event) {

    }

    @FXML
    void cmbBookNameOnAction(ActionEvent event) {

    }
}
