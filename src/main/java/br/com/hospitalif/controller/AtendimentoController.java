package br.com.hospitalif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AtendimentoController {

    @FXML
    private TextField txtMedico;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtEnfermeiro;

    @FXML
    private TextField txtComEnfermeiro;

    @FXML
    private TextField txtEnfermidade;

    @FXML
    private TextField txtComMedico;

    @FXML
    private DatePicker dateData;

    @FXML
    private TextField txtAltura;

    @FXML
    private TextField txtPeso;

    @FXML
    void cadastrarAtendimento(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }

}
