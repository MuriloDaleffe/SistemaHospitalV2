package br.com.hospitalif.controller.ClassControllers;

import application.Main;
import br.com.hospitalif.DAO2.EnfermidadePessoalDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.EnfermidadePessoal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Rotas;

public class EnferPesController {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtComentario;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtDescricao;

    @FXML
    void cancel(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    @FXML
    void reset(ActionEvent event) {
        txtComentario.clear();
        txtDescricao.clear();
        txtNome.clear();
        txtStatus.clear();
        txtTipo.clear();
    }

    @FXML
    void save(ActionEvent event) {
        EnfermidadePessoal ep = new EnfermidadePessoal();

        ep.setNome(txtNome.getText());
        ep.setTipo(txtTipo.getText());
        ep.setComentario(txtComentario.getText());
        ep.setStatusDeEnfermidade(txtStatus.getText());
        ep.setDescricao(txtDescricao.getText());

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EnfermidadePessoalDAO dao = new EnfermidadePessoalDAO(sem.getEntityManager());
        dao.save(ep);
        sem.beginTransaction();
        sem.commit();
        sem.close();

        msgInfo();

    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Enfermidade Pessoal cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Enfermidade!");
        msg.show();
    }

}


