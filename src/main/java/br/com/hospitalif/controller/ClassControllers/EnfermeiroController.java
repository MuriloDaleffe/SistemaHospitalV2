package br.com.hospitalif.controller.ClassControllers;

import application.Main;
import br.com.hospitalif.DAO2.EnfermeiroDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Enfermeiro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Rotas;

import java.sql.SQLException;

public class EnfermeiroController {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

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
    private TextField txtEspecialidade;

    @FXML
    private TextField txtNumRegistro;

    @FXML
    void save(ActionEvent event) throws SQLException {

        Enfermeiro m = new Enfermeiro();

        m.setNumeroDeRegistro(Integer.parseInt(txtNumRegistro.getText()));
        m.setNome(txtNome.getText());
        m.setStatusDeUsuario(txtStatusUsuario.getText());
        m.setLogin(txtLogin.getText());
        m.setSenha(txtSenha.getText());
        m.setCpf(txtCPF.getText());
        m.setIdade(Integer.parseInt(intIdade.getText()));
        m.setTipoSanguineo(txtTipoSang.getText());
        m.setSexo(cboSexo.getText());
        m.setStatusDePessoa(txtStatusPessoa.getText());

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EnfermeiroDAO dao = new EnfermeiroDAO(sem.getEntityManager());
        dao.save(m);
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
        txtNumRegistro.clear();
        txtEspecialidade.clear();
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

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Enfermeiro cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Enfermeiros!");
        msg.show();
    }

}

