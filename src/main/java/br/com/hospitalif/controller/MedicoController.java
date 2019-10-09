package br.com.hospitalif.controller;

import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class MedicoController {

    @FXML
    private Button btnCancel;

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
    void cadastrarMedico(ActionEvent event) throws SQLException {

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

    }

    @FXML
    void reset(ActionEvent event) {

    }

}
