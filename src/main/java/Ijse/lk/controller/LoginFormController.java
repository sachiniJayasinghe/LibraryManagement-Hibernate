package Ijse.lk.controller;

import Ijse.lk.bo.BOFactory;
import Ijse.lk.bo.custom.AdminBO;
import Ijse.lk.bo.custom.LoginBO;
import Ijse.lk.dto.AdminDto;
import Ijse.lk.dto.userDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class LoginFormController {

    @FXML
    private Button btnLogin;

    @FXML
    private ComboBox<String> cmbRole;

    @FXML
    private AnchorPane main;

    @FXML
    private PasswordField txtPswd;

    @FXML
    private TextField txtUserName;

    private AdminBO adminBO;
    private LoginBO loginBO;

    static String role;

    public void initialize() {
        cmbRole.getItems().addAll("Admin", "User");
        adminBO = (AdminBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Admin);
        loginBO = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Login);
    }

    @FXML
    public void btnLoginOnAction(ActionEvent actionEvent) {
        try {
             role = cmbRole.getValue();
            if (role == null) {
                btnLogin.setDisable(true);
                return;
            }

            if (role.equals("Admin")) {
                loginAsAdmin();
            } else if (role.equals("User")) {
                loginAsUser();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginAsAdmin() throws Exception {
        String username = txtUserName.getText();
        String password = txtPswd.getText();
        List<AdminDto> adminDtos = loginBO.getAllAdmin();

        for (AdminDto adminDto : adminDtos) {
            if (adminDto.getAdmin_id().equals(username) && adminDto.getAdmin_name().equals(password)) {
                loadMainForm();
                return;
            }
        }
    }

    private void loginAsUser() throws Exception {
        String username = txtUserName.getText();
        String password = txtPswd.getText();
        List<userDto> userDtos = loginBO.getAllUser();

        for (userDto userDto : userDtos) {
            System.out.println(userDto.getName() + " " + userDto.getPassword());
            if (userDto.getName().equals(username) && userDto.getPassword().equals(password)) {

                loadMainForm();
                return;
            }
        }
    }

    private void loadMainForm() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/main_form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) main.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Main Form");
        stage.show();
    }

    public void cmbRoleOnAction(ActionEvent actionEvent) {
        btnLogin.setDisable(false);
    }
}
