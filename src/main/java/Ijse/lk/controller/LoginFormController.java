package Ijse.lk.controller;

import Ijse.lk.bo.BOFactory;
import Ijse.lk.bo.custom.AdminBO;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginFormController {

    static String role;

    private String admin_id;
    private String admin_name;

    @FXML
    private JFXComboBox<String> cmbRole;
    @FXML
    AnchorPane main;

    AdminBO adminBO = (AdminBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Admin);

    public void initialize() {
        cmbRole.getItems().addAll("Admin", "User");
    }
    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/main_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.main.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("mainForm");
        stage.show();
    }

    @FXML
    void cmbRoleOnAction(ActionEvent event) throws Exception {
        role = cmbRole.getValue();
        adminBO.getAdmin();

    }


}
