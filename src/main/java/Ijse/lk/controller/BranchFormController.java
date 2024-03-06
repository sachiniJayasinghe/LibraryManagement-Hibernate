package Ijse.lk.controller;

import Ijse.lk.bo.BOFactory;
import Ijse.lk.bo.custom.BookBO;
import Ijse.lk.bo.custom.BranchBO;
import Ijse.lk.bo.custom.UserBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BranchDto;
import Ijse.lk.dto.userDto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class BranchFormController {
    @FXML
    private AnchorPane subsubPane;

    @FXML
    private TableView<BranchDto> tblBranch;

    @FXML
    private TextField txtBranchId;

    @FXML
    private TextField txtBranchName;
    BranchBO branchBO= (BranchBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Branch);

    public void initialize() {
        tblBranch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("branch_id"));
        tblBranch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("branch_name"));
        loadAllBranch();


    }

    public void txtSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnBackOnAction(ActionEvent actionEvent) {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        long branch_id = Long.parseLong(txtBranchId.getText());
        String branch_name = txtBranchName.getText();
        try {
            branchBO.addBranch(new BranchDto(branch_id,branch_name));
            loadAllBranch();
            new Alert(Alert.AlertType.CONFIRMATION,"Branch Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Branch Added Not Successful!", ButtonType.OK).show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        long branch_id = Long.parseLong(txtBranchId.getText());
        String branch_name = txtBranchName.getText();
        try {
            branchBO.updateBranch(new BranchDto(branch_id,branch_name));
            loadAllBranch();
            new Alert(Alert.AlertType.CONFIRMATION,"Branch Updated Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Branch Updated Not Successful!", ButtonType.OK).show();
        }
    }




    private void loadAllBranch() {
        tblBranch.getItems().clear();
        ObservableList<BranchDto> items = (ObservableList<BranchDto>) tblBranch.getItems();
        try {
            //*Get all customers*//*
            List<BranchDto> allBranch = branchBO.getAllBranch();
            System.out.println(allBranch);

            for (BranchDto b : allBranch) {
                items.add(new BranchDto(b.getBranch_id(), b.getBranch_name()));
                System.out.println(b.getBranch_name());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void btnDeletebOnAction(ActionEvent actionEvent) {
        long branch_id = Long.parseLong(txtBranchId.getText());

        try {
            branchBO.deleteBranch(branch_id);
            tblBranch.refresh();
            loadAllBranch();
        new Alert(Alert.AlertType.CONFIRMATION,"branch Deleted Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "branch Deleted  Not Successful!", ButtonType.OK).show();
        }
    }
}
