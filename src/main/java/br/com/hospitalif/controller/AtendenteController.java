package br.com.hospitalif.controller;

import application.Main;
import br.com.hospitalif.DAO.AtendenteDAO;
import br.com.hospitalif.model.Atendente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Rotas;

import java.sql.SQLException;

public class AtendenteController {

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
        Atendente atendente = new Atendente();

        atendente.setCargo(txtCargo.getText());
        atendente.setNome(txtNome.getText());
        atendente.setStatusDeUsuario(txtStatusUsuario.getText());
        atendente.setLogin(txtLogin.getText());
        atendente.setSenha(txtSenha.getText());
        atendente.setCpf(txtCPF.getText());
        atendente.setIdade(Integer.parseInt(intIdade.getText()));
        atendente.setTipoSanguineo(txtTipoSang.getText());
        atendente.setSexo(cboSexo.getText());
        atendente.setStatusDePessoa(txtStatusPessoa.getText());

        AtendenteDAO.save(atendente);

        msgInfo();
    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Médico cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Médico!");
        msg.show();
    }

}

