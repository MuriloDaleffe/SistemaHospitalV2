package br.com.hospitalif.controller.ClassControllers;

import application.Main;
import br.com.hospitalif.DAO.EnfermidadePessoalDAO;
import br.com.hospitalif.DAO.PacienteDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.EnfermidadePessoal;
import br.com.hospitalif.model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import util.Rotas;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class PacienteController {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

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
    private TextField txtAltura;

    @FXML
    private TextField txtPeso;


    @FXML
    void save(ActionEvent event) {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);

        Paciente m = new Paciente();

        m.setNome(txtNome.getText());
        m.setCpf(txtCPF.getText());
        m.setIdade(Integer.parseInt(intIdade.getText()));
        m.setTipoSanguineo(txtTipoSang.getText());
        m.setSexo(cboSexo.getText());
        m.setStatusDePessoa(txtStatusPessoa.getText());
        m.setAltura(Float.valueOf(txtAltura.getText()));
        m.setPeso(Float.valueOf(txtPeso.getText()));

        PacienteDAO dao = new PacienteDAO(sem.getEntityManager());
        dao.salvar(m);
        sem.beginTransaction();
        sem.commit();
        sem.close();

        msgInfo();

    }

    @FXML
    void cancel(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    @FXML
    void reset(ActionEvent event) {

        txtNome.clear();
        txtCPF.clear();
        intIdade.clear();
        txtTipoSang.clear();
        cboSexo.clear();
        txtStatusPessoa.clear();
        txtAltura.clear();
        txtPeso.clear();
    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Paciente cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Paciente!");
        msg.show();
    }

}


