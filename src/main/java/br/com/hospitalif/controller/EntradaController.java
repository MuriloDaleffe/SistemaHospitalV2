package br.com.hospitalif.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EntradaController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtSituacao;

    @FXML
    private DatePicker dateDataEntrada;

    @FXML
    private DatePicker dataDataSaida;

    @FXML
    void entrada(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }

}
