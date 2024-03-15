package Ijse.lk.controller;

import Ijse.lk.bo.BOFactory;
import Ijse.lk.bo.custom.AdminBO;
import Ijse.lk.bo.custom.BranchBO;
import Ijse.lk.dto.AdminDto;
import Ijse.lk.dto.BranchDto;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.util.List;

public class AdminFormController {


    @FXML
    private AnchorPane subsubPane;

    @FXML
    private TableView<AdminDto> tblAdmin;

    @FXML
    private TextField txtAdminId;

    @FXML
    private TextField txtAdminName;


    AdminBO adminBO= (AdminBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Admin);

    public void initialize() {
        tblAdmin.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("admin_id"));
        tblAdmin.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("admin_name"));
        loadAllAdmin();
    }




    @FXML
    void txtSearchOnAction(ActionEvent event) {

    }
    private void loadAllAdmin() {
        tblAdmin.getItems().clear();
        ObservableList<AdminDto> items = (ObservableList<AdminDto>) tblAdmin.getItems();
        try {
            //*Get all customers*//*
            List<AdminDto> allBranch = adminBO.getAllAdmin();
            System.out.println(allBranch);

            for (AdminDto b : allBranch) {
                items.add(new AdminDto(b.getAdmin_id(), b.getAdmin_name()));
                System.out.println(b.getAdmin_name());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void txtSearchOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void btnBackOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void btnClearOnAction(javafx.event.ActionEvent actionEvent) {
    }


    public void btnUpdateOnAction(javafx.event.ActionEvent actionEvent) {
        String admin_id = txtAdminId.getText();
        String admin_name = txtAdminName.getText();
        try {
            adminBO.updateAdmin(new AdminDto(admin_id,admin_name));
            loadAllAdmin();
            new Alert(Alert.AlertType.CONFIRMATION,"Admin Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Admin Added Not Successful!", ButtonType.OK).show();
        }

    }

    public void btnDeleteOnAction(javafx.event.ActionEvent actionEvent) {
        String admin_id = txtAdminId.getText();

        try {
            adminBO.deleteAdmin(admin_id);
            tblAdmin.refresh();
            loadAllAdmin();
            new Alert(Alert.AlertType.CONFIRMATION,"branch Deleted Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "branch Deleted  Not Successful!", ButtonType.OK).show();
        }
    }

    public void btnSaveOnAction(javafx.event.ActionEvent actionEvent) {
        String admin_id = txtAdminId.getText();
        String admin_name = txtAdminName.getText();
        try {
            adminBO.addAdmin(new AdminDto(admin_id,admin_name));
            loadAllAdmin();
            new Alert(Alert.AlertType.CONFIRMATION,"Admin Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Admin Added Not Successful!", ButtonType.OK).show();
        }

    }
}
