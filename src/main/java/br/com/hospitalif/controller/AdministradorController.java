package br.com.hospitalif.controller;

import application.Main;
import br.com.hospitalif.DAO.AdministradorDAO;
import br.com.hospitalif.model.Administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Rotas;

import java.sql.SQLException;

public class AdministradorController {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtStatusUsuario;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField intIdade;

    @FXML
    private TextField txtTipoSang;

    @FXML
    private TextField cboSexo;

    @FXML
    private TextField txtStatusPessoa;

    @FXML
    private TextField txtCargo;

    @FXML
    void cancel(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    @FXML
    void reset(ActionEvent event) {
        txtCargo.clear();
        txtNome.clear();
        txtStatusUsuario.clear();
        txtLogin.clear();
        txtSenha.clear();
        txtCPF.clear();
        intIdade.clear();
        txtTipoSang.clear();
        cboSexo.clear();
        txtStatusPessoa.clear();
    }

    @FXML
    void save(ActionEvent event) throws SQLException {
        Administrador administrador = new Administrador();

        administrador.setCargo(txtCargo.getText());
        administrador.setNome(txtNome.getText());
        administrador.setStatusDeUsuario(txtStatusUsuario.getText());
        administrador.setLogin(txtLogin.getText());
        administrador.setSenha(txtSenha.getText());
        administrador.setCpf(txtCPF.getText());
        administrador.setIdade(Integer.parseInt(intIdade.getText()));
        administrador.setTipoSanguineo(txtTipoSang.getText());
        administrador.setSexo(cboSexo.getText());
        administrador.setStatusDePessoa(txtStatusPessoa.getText());

        AdministradorDAO.save(administrador);

        msgInfo();
    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Administrador cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Administrador!");
        msg.show();
    }

}


