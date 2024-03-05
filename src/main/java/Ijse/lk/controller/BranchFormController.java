package Ijse.lk.controller;

import Ijse.lk.bo.BOFactory;
import Ijse.lk.bo.custom.BookBO;
import Ijse.lk.bo.custom.BranchBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BranchDto;
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
    BranchBO branchBO = (BranchBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Branch);

    public void initialize() {
        tblBranch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("branchId"));
        tblBranch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));

        loadAllBranch();

    }

    public void txtSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnBackOnAction(ActionEvent actionEvent) {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        int branchId = Integer.parseInt(txtBranchId.getText());
        String name = txtBranchName.getText();

        try {
            System.out.println("save");
            branchBO.addBranch(new BranchDto(branchId, name));
            loadAllBranch();
            new Alert(Alert.AlertType.CONFIRMATION, "Branch Add Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Branch ADD Not Successful!", ButtonType.OK).show();
        }

    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        int branch_id = Integer.parseInt(txtBranchId.getText());
        String name = txtBranchName.getText();

        try {
            branchBO.updateBranch(new BranchDto(branch_id, name));
            loadAllBranch();
            new Alert(Alert.AlertType.CONFIRMATION, "Branch Updated Successful !", ButtonType.OK).show();
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
                items.add(new BranchDto(b.getBranchId(), b.getName()));
                System.out.println(b.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeletebOnAction(ActionEvent actionEvent) {
        int branch_id = Integer.parseInt(txtBranchId.getText());

        try {
            branchBO.deleteBranch(branch_id);
            tblBranch.refresh();
            loadAllBranch();
            new Alert(Alert.AlertType.CONFIRMATION,"Branch Deleted Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Branch Deleted  Not Successful!", ButtonType.OK).show();
        }

    }
}
