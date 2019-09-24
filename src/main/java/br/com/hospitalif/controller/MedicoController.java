package br.com.hospitalif.controller;

import br.com.hospitalif.model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MedicoController {

    @FXML
    private TextField txtNumRegistro;

    @FXML
    private TextField txtEspecialidade;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    void cadastrarMedico(ActionEvent event) {
        Medico m = new Medico();


    }

    @FXML
    void reset(ActionEvent event) {

    }

}
