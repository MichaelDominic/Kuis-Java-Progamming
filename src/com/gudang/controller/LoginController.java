package com.gudang.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Label lblStatus;

    @FXML
    private PasswordField txtpass;

    @FXML
    private TextField txtuser;

    @FXML
    private Button btnLogin;

    @FXML
    void loginAction(ActionEvent event) {
        String user = txtuser.getText();
        String pass = txtpass.getText();

        if (user.equals("admin") && pass.equals("123")) {
            try {
                Stage stage = (Stage) txtuser.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
                Scene scene = new Scene(loader.load());

                stage.setScene(scene);
                stage.setTitle("Menu Utama");
                stage.show(); 
            } catch (Exception e) {
                e.printStackTrace();
                lblStatus.setText("Terjadi kesalahan saat membuka menu.");
            }
        } else {
            lblStatus.setText("Login gagal!");
        }
    }
}