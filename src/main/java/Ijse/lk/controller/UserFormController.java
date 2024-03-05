package Ijse.lk.controller;

import Ijse.lk.bo.BOFactory;
import Ijse.lk.bo.custom.UserBO;
import Ijse.lk.dto.userDto;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.util.List;

public class UserFormController {
    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPassword;

    @FXML
    private AnchorPane subsubPane;

    @FXML
    private TableView<userDto> tblUser;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    UserBO userBO= (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize() {
        tblUser.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblUser.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblUser.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblUser.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("password"));

        loadAllUser();
    }


    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }
    @FXML
    public void btnSaveOnAction(ActionEvent actionEvent) {
        long user_id = Long.parseLong(txtId.getText());
        String user_name = txtName.getText();
        String user_email=txtEmail.getText();
        String user_password=txtPassword.getText();
        try {
            userBO.addUser(new userDto(user_id,user_name,user_email,user_password));
            loadAllUser();
            new Alert(Alert.AlertType.CONFIRMATION,"User Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "User Added Not Successful!", ButtonType.OK).show();
        }
    }
    @FXML

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        long user_id = Long.parseLong(txtId.getText());
        try {
            userBO.deleteUser(user_id);
            tblUser.refresh();
            loadAllUser();
            new Alert(Alert.AlertType.CONFIRMATION,"user Deleted Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "User Deleted  Not Successful!", ButtonType.OK).show();
        }

    }
        private void loadAllUser() {
        tblUser.getItems().clear();
        ObservableList<userDto> items= (ObservableList<userDto>) tblUser.getItems();
        try {
            //*Get all customers*//*
            List<userDto> allUser = userBO.getAllUser();
            System.out.println(allUser);

            for (userDto c : allUser) {
                items.add(new userDto(c.getId(), c.getName(), c.getEmail(),c.getPassword()));
                System.out.println(c.getPassword());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void btnUpdateOnAction(ActionEvent actionEvent) {
        long id = Long.parseLong(txtId.getText());
        String name= txtName.getText();
        String email=txtEmail.getText();
        String password=txtPassword.getText();

        try {
            userBO.updateUser(new userDto(id,name,email,password));
            loadAllUser();
            new Alert(Alert.AlertType.CONFIRMATION,"user Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "User Added Not Successful!", ButtonType.OK).show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }




}
