package br.com.hospitalif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    void login(ActionEvent event) {
        System.out.println(txtLogin.getText());
        msgInfo(txtLogin.getText());
    }

    @FXML
    void reset(ActionEvent event) {

    }

    public void msgInfo(String msg){
        Alert msgg = new Alert(Alert.AlertType.INFORMATION);
        msgg.setContentText("Minha Msg Aqui!");
        msgg.setHeaderText("Header Aqui!");
        msgg.show();
    }

}
