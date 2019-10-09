package br.com.hospitalif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PacienteController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtNome;

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
    private TextArea txtHistorico;

    @FXML
    private TextArea txtDoenca;

    @FXML
    void cadastrarMedico(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }

}

