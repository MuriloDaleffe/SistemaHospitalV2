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
    private Button btnCad82;

    @FXML
    private Button btnCad11;

    @FXML
    private Button btnCad21;

    @FXML
    private Button btnCad31;

    @FXML
    private Button btnCad41;

    @FXML
    private Button btnCad51;

    @FXML
    private Button btnCad61;

    @FXML
    private Button btnCad71;

    @FXML
    private Button btnCad81;

    @FXML
    private Button btnCad811;

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
    void cadastrarEntrada(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ENTRADA);
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

    @FXML
    void visualizarAdministrador(ActionEvent event)  throws Exception {
        Main.openPage(Rotas.TABLEVIEWADMINISTRADOR);
    }

    @FXML
    void visualizarAtendente(ActionEvent event)  throws Exception {
        Main.openPage(Rotas.TABLEVIEWATENDENTE);
    }

    @FXML
    void visualizarAtendimento(ActionEvent event)  throws Exception {
        Main.openPage(Rotas.TABLEVIEWATENDIMENTO);
    }

    @FXML
    void visualizarEnferPes(ActionEvent event)  throws Exception {
        Main.openPage(Rotas.TABLEVIEWENFERMIDADEPESSOAL);
    }

    @FXML
    void visualizarEnfermeiro(ActionEvent event)  throws Exception {
        Main.openPage(Rotas.TABLEVIEWENFERMEIRO);
    }

    @FXML
    void visualizarEntrada(ActionEvent event)  throws Exception {
        Main.openPage(Rotas.TABLEVIEWENTRADA);
    }

    @FXML
    void visualizarGerente(ActionEvent event)  throws Exception {
        Main.openPage(Rotas.TABLEVIEWGERENTE);
    }

    @FXML
    void visualizarMedico(ActionEvent event) throws Exception {
        Main.openPage(Rotas.TABLEVIEWMEDICO);
    }

    @FXML
    void visualizarPaciente(ActionEvent event)  throws Exception {
        Main.openPage(Rotas.TABLEVIEWPACIENTE);
    }

}

