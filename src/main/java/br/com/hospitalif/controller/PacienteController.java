package br.com.hospitalif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PacienteController {

    @FXML
    private TextField txtNome;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextArea txtHistorico;

    @FXML
    private TextArea txtEnfermidade;

    @FXML
    void cadastrarPaciente(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }

}
