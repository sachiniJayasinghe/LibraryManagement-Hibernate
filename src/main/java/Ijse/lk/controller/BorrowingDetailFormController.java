package Ijse.lk.controller;

import Ijse.lk.bo.BOFactory;
import Ijse.lk.bo.custom.BorrowingBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.tm.BorrowingBooksDetailsTM;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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

        returnDate.setValue(LocalDate.now().plusDays(7));

        String id = borrowingBO.getNewBorrowingId();
        txtBrwID.setText(id);
        List<BookDto> allBooks =borrowingBO.searchBook();
        for (BookDto b: allBooks) {

            if (b.getAvailability().equals("Available") || b.getAvailability().equals("available")){
                cmbBookName.getItems().add(b.getTitle());
            }
        }
        cmbBookName.getItems().addAll();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
        String borrowId = borrowingBO.getNewBorrowingId();
        String bookName = cmbBookName.getValue();
        String userId = txtUsr.getText();
        String bookId = borrowingBO.searchBookForName(bookName);
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
