package br.com.hospitalif.controller;

import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.model.Medico;
import util.Rotas;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class MedicoController {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

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
    private TextField txtEspecialidade;

    @FXML
    private TextField txtNumRegistro;

    @FXML
    private Button btnCancel;

    @FXML
    void save(ActionEvent event) throws SQLException {

        Medico m = new Medico();

        m.setNumeroRegistro(txtNumRegistro.getText());
        m.setEspecialidade(txtEspecialidade.getText());
        m.setNome(txtNome.getText());
        m.setStatusDeUsuario(txtStatusUsuario.getText());
        m.setLogin(txtLogin.getText());
        m.setSenha(txtSenha.getText());
        m.setCpf(txtCPF.getText());
        m.setIdade(Integer.parseInt(intIdade.getText()));
        m.setTipoSanguineo(txtTipoSang.getText());
        m.setSexo(cboSexo.getText());
        m.setStatusDePessoa(txtStatusPessoa.getText());

        MedicoDAO.saveMedico(m);

        msgInfo();
    }

    @FXML
    void cancel(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    @FXML
    void reset(ActionEvent event) {
        txtNumRegistro.clear();
        txtEspecialidade.clear();
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

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Médico cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Médico!");
        msg.show();
    }

}

