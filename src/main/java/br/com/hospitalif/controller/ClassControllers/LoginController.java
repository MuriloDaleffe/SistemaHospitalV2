package br.com.hospitalif.controller.ClassControllers;

import br.com.hospitalif.DAO.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField txtLogin;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    void login(ActionEvent event) throws Exception {
        LoginDAO.login(txtLogin.getText(), txtSenha.getText());
    }

    @FXML
    void reset(ActionEvent event) {
        txtLogin.clear();
        txtSenha.clear();
    }

}
