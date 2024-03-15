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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.List;
import java.util.regex.Pattern;

public class BranchFormController {
    @FXML
    private AnchorPane subsubPane;
    @FXML
    private TableColumn<?, ?> colAdminId;

    @FXML
    private TableView<BranchDto> tblBranch;

    @FXML
    private TextField txtAdminId;


    @FXML
    private TextField txtBranchId;

    @FXML
    private TextField txtBranchName;
    BranchBO branchBO= (BranchBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Branch);



    public void initialize() {
//        tblBranch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("branch_id"));
//        tblBranch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("branch_name"));
//        tblBranch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("admin_id"));
//
//        loadAllBranch();


    }

    public void txtSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnBackOnAction(ActionEvent actionEvent) {

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        boolean isValidate = validatedBranch();
        if (isValidate) {
            String branch_id = txtBranchId.getText();
            String branch_name = txtBranchName.getText();
            String admin_id = txtAdminId.getText();


            try {
                branchBO.addBranch(new BranchDto(branch_id, branch_name, admin_id));
                loadAllBranch();
                new Alert(Alert.AlertType.CONFIRMATION, "Branch Added Successful !", ButtonType.OK).show();
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Branch Added Not Successful!", ButtonType.OK).show();
            }
        }
        }

        public void btnClearOnAction (ActionEvent actionEvent){

        }

        public void btnUpdateOnAction (ActionEvent actionEvent){
            String branch_id = txtBranchId.getText();
            String branch_name = txtBranchName.getText();
            String admin_id = txtAdminId.getText();


            try {
                branchBO.updateBranch(new BranchDto(branch_id, branch_name, admin_id));
                loadAllBranch();
                new Alert(Alert.AlertType.CONFIRMATION, "Branch Updated Successful !", ButtonType.OK).show();
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Branch Updated Not Successful!", ButtonType.OK).show();
            }
        }


        private void loadAllBranch () {
            tblBranch.getItems().clear();
            ObservableList<BranchDto> items = (ObservableList<BranchDto>) tblBranch.getItems();
            try {
                //*Get all customers*//*
                List<BranchDto> allBranch = branchBO.getAllBranch();
                System.out.println(allBranch);

                for (BranchDto b : allBranch) {
                    items.add(new BranchDto(b.getBranch_id(), b.getBranch_name(), b.getAdmin_id()));
                    System.out.println(b.getBranch_name());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        public void btnDeletebOnAction (ActionEvent actionEvent){
            String branch_id = txtBranchId.getText();

            try {
                branchBO.deleteBranch(branch_id);
                tblBranch.refresh();
                loadAllBranch();
                new Alert(Alert.AlertType.CONFIRMATION, "branch Deleted Successful !", ButtonType.OK).show();
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "branch Deleted  Not Successful!", ButtonType.OK).show();
            }
        }



    private boolean validatedBranch() {
        int num = 0;
        String id = txtBranchId.getText();
        boolean isCustomerIdValidated = Pattern.matches("[B][R][0-9]{3,}", id);
        if (!isCustomerIdValidated) {
            new Alert(Alert.AlertType.ERROR, "INVALID Id").show();
            num = 1;
        }

        String name = txtBranchName.getText();
        boolean isCustomerNameValidated = Pattern.matches("[A-Za-z]{3,}", name);
        if (!isCustomerNameValidated) {
            new Alert(Alert.AlertType.ERROR, "INVALID Name").show();
            num = 1;
        }

        String admin_id = txtAdminId.getText();
        boolean isAdminIdValidated = Pattern.matches("[A][0-9]{3,}", admin_id);
        if (!isAdminIdValidated) {
            new Alert(Alert.AlertType.ERROR, "INVALID Id").show();
            num = 1;
        }
        if (num == 1) {
            num = 0;
            return false;
        } else {
            num = 0;
            return true;
        }
    }
    }
