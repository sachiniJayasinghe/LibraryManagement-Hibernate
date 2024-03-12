package Ijse.lk.controller;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class MainFormController {
    @FXML
    private Button btnBook;

    @FXML
    private Button btnBranch;

    @FXML
    private Button btnBrowing;

    @FXML
    private Button btnDashBoard;

    @FXML
    private Button btnTransaction;

    @FXML
    private Button btnUsr;

    @FXML
    private AnchorPane subPane;

    @FXML
    private Pane mainSubPane;

    @FXML
    public void initialize() throws IOException {
        setUI("dash_board.fxml", btnDashBoard);
        btnBook.setStyle("-fx-background-color: #87CEEB");
        btnBranch.setStyle("-fx-background-color: #87CEEB");
        btnBrowing.setStyle("-fx-background-color: #87CEEB");
        btnTransaction.setStyle("-fx-background-color: #87CEEB");
        btnUsr.setStyle("-fx-background-color: #87CEEB");
    }

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        changeButtonColor(btnBook);
        btnBranch.setStyle("-fx-background-color: #87CEEB");
        btnBrowing.setStyle("-fx-background-color: #87CEEB");
        btnDashBoard.setStyle("-fx-background-color: #87CEEB");
        btnTransaction.setStyle("-fx-background-color: #87CEEB");
        btnUsr.setStyle("-fx-background-color: #87CEEB");
        setUI("book_form.fxml", btnBook);

    }

    @FXML
    void btnBranchOnAction(ActionEvent event) throws IOException {
        changeButtonColor(btnBranch);
        btnBook.setStyle("-fx-background-color: #87CEEB");
        btnBrowing.setStyle("-fx-background-color: #87CEEB");
        btnDashBoard.setStyle("-fx-background-color: #87CEEB");
        btnTransaction.setStyle("-fx-background-color: #87CEEB");
        btnUsr.setStyle("-fx-background-color: #87CEEB");
        setUI("branch_form.fxml", btnBranch);

    }

    @FXML
    void btnBrowingOnAction(ActionEvent event) throws IOException {
        changeButtonColor(btnBrowing);
        btnBook.setStyle("-fx-background-color: #87CEEB");
        btnBranch.setStyle("-fx-background-color: #87CEEB");
        btnDashBoard.setStyle("-fx-background-color: #87CEEB");
        btnTransaction.setStyle("-fx-background-color: #87CEEB");
        btnUsr.setStyle("-fx-background-color: #87CEEB");
        setUI("borrowingDetail_form.fxml", btnBrowing);
    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) throws IOException {
        setUI("dash_board.fxml", btnDashBoard);
        changeButtonColor(btnDashBoard);
        btnBook.setStyle("-fx-background-color: #87CEEB");
        btnBranch.setStyle("-fx-background-color: #87CEEB");
        btnBrowing.setStyle("-fx-background-color: #87CEEB");
        btnTransaction.setStyle("-fx-background-color: #87CEEB");
        btnUsr.setStyle("-fx-background-color: #87CEEB");

    }

    @FXML
    void btnTransactionOnAction(ActionEvent event) {
        changeButtonColor(btnTransaction);
        btnBook.setStyle("-fx-background-color: #87CEEB");
        btnBranch.setStyle("-fx-background-color: #87CEEB");
        btnBrowing.setStyle("-fx-background-color: #87CEEB");
        btnDashBoard.setStyle("-fx-background-color: #87CEEB");
        btnUsr.setStyle("-fx-background-color: #87CEEB");

    }

    private void setUI(String fileName, Button btn) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + fileName));
        Pane registerPane = fxmlLoader.load();

        try {
            subPane.getChildren().clear();
            subPane.getChildren().setAll(registerPane);
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }

        btn.setStyle("-fx-background-color: #708090");
    }

    private void changeButtonColor(Button button) {
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(button.styleProperty(),
                "-fx-background-color: #708090");
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void btnUsrOnAction(ActionEvent actionEvent) throws IOException {
        changeButtonColor(btnUsr);
        btnBook.setStyle("-fx-background-color: #87CEEB");
        btnBranch.setStyle("-fx-background-color: #87CEEB");
        btnBrowing.setStyle("-fx-background-color: #87CEEB");
        btnDashBoard.setStyle("-fx-background-color: #87CEEB");
        btnTransaction.setStyle("-fx-background-color: #87CEEB");
        setUI("user_form.fxml", btnUsr);
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) throws IOException {
        setUI("admin_form.fxml", btnUsr);
    }
}
