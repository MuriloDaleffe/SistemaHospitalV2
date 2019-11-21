package br.com.hospitalif.controller.ClassControllers;

import application.Main;
import br.com.hospitalif.DAO.LoginDAO2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Rotas;

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
        LoginDAO2 dao = new LoginDAO2();
        boolean res = dao.buscaUsuario(txtLogin.getText(), txtSenha.getText());
        if(res){
            msgInfo(1);
            Main.openPage(Rotas.SISTEMA);
        }else{
            msgInfo(0);
        }
    }

    @FXML
    void reset(ActionEvent event) {
        txtLogin.clear();
        txtSenha.clear();
    }

    public static void msgInfo(int num){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        if(num==1){
            msg.setContentText("Logado com sucesso!");
            msg.setHeaderText("Login");
            msg.show();
        }else{
            msg.setContentText("Falha ao logar! Usuário não cadastrado no banco de dados!");
            msg.setHeaderText("Login");
            msg.show();
        }
    }

}
