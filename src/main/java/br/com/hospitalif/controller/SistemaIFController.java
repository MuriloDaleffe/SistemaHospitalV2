package br.com.hospitalif.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import util.Rotas;

public class SistemaIFController {

    @FXML
    private Button btnCad1;

    @FXML
    private Button btnCad2;

    @FXML
    private Button btnCad3;

    @FXML
    private Button btnCad4;

    @FXML
    private Button btnCad5;

    @FXML
    private Button btnCad6;

    @FXML
    private Button btnCad7;

    @FXML
    private Button btnCad8;

    @FXML
    void cadastrarAdministrador(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ADMINISTRADOR);
    }

    @FXML
    void cadastrarAtendente(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ATENDENTE);
    }

    @FXML
    void cadastrarAtendimento(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ATENDIMENTO);
    }

    @FXML
    void cadastrarEnferPes(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ENFERMIDADEPESSOAL);
    }

    @FXML
    void cadastrarEnfermeiro(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ENFERMEIRO);
    }

    @FXML
    void cadastrarGerente(ActionEvent event) throws Exception {
        Main.openPage(Rotas.GERENTE);
    }

    @FXML
    void cadastrarMedico(ActionEvent event) throws Exception {
        Main.openPage(Rotas.MEDICO);
    }

    @FXML
    void cadastrarPaciente(ActionEvent event) throws Exception {
        Main.openPage(Rotas.PACIENTE);
    }

}
