package br.com.hospitalif.controller.ClassControllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import util.Rotas;

public class AtendimentoController {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private DatePicker txtDataEntr;

    @FXML
    private TextField txtAltura;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextArea txtSituPac;

    @FXML
    private TextArea txtStaEntr;

    @FXML
    private DatePicker txtDataSai;

    @FXML
    private TextArea txtComentMedico;

    @FXML
    private TextArea txtHistDoenca;

    @FXML
    private TextArea txtComentEnfer;

    @FXML
    void cancel(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    @FXML
    void reset(ActionEvent event) {
        txtAltura.clear();
        txtComentEnfer.clear();
        txtComentMedico.clear();
        txtHistDoenca.clear();
        txtPeso.clear();
        txtSituPac.clear();
        txtStaEntr.clear();
    }

    @FXML
    void save(ActionEvent event) {

    }

}
