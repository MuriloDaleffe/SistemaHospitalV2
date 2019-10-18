package br.com.hospitalif.controller.ClassControllers;

import application.Main;
import br.com.hospitalif.DAO2.GerenteDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Gerente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Rotas;

import java.sql.SQLException;

public class GerenteController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtStatusUsuario;

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
    private TextField txtCargo;

    @FXML
    void cancel(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    @FXML
    void reset(ActionEvent event) {
        txtCargo.clear();
        txtNome.clear();
        txtStatusUsuario.clear();
        txtLogin.clear();
        txtSenha.clear();
        txtCPF.clear();
        intIdade.clear();
        txtTipoSang.clear();
        cboSexo.clear();
        txtStatusPessoa.clear();
    }

    @FXML
    void save(ActionEvent event) throws SQLException {
        Gerente gerente = new Gerente();

        gerente.setCargo(txtCargo.getText());
        gerente.setNome(txtNome.getText());
        gerente.setStatusDeUsuario(txtStatusUsuario.getText());
        gerente.setLogin(txtLogin.getText());
        gerente.setSenha(txtSenha.getText());
        gerente.setCpf(txtCPF.getText());
        gerente.setIdade(Integer.parseInt(intIdade.getText()));
        gerente.setTipoSanguineo(txtTipoSang.getText());
        gerente.setSexo(cboSexo.getText());
        gerente.setStatusDePessoa(txtStatusPessoa.getText());

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        GerenteDAO dao = new GerenteDAO(sem.getEntityManager());
        dao.save(gerente);
        sem.beginTransaction();
        sem.commit();
        sem.close();

        msgInfo();
    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Gerente cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Gerente!");
        msg.show();
    }

}

