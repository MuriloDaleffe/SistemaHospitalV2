package br.com.hospitalif.controller.ClassControllers;

import application.Main;
import br.com.hospitalif.DAO2.PacienteDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import util.Rotas;

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
    private TextArea txtHistorico;

    @FXML
    private TextArea txtDoenca;

    @FXML
    void save(ActionEvent event) {

        Paciente m = new Paciente();

        m.setNome(txtNome.getText());
        m.setCpf(txtCPF.getText());
        m.setIdade(Integer.parseInt(intIdade.getText()));
        m.setTipoSanguineo(txtTipoSang.getText());
        m.setSexo(cboSexo.getText());
        m.setStatusDePessoa(txtStatusPessoa.getText());
        m.setHistorico(txtHistorico.getText());
        m.setDoenca(txtDoenca.getText());

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        PacienteDAO dao = new PacienteDAO(sem.getEntityManager());
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

        txtNome.clear();
        txtCPF.clear();
        intIdade.clear();
        txtTipoSang.clear();
        cboSexo.clear();
        txtStatusPessoa.clear();
        txtHistorico.clear();
        txtDoenca.clear();
    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Paciente cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Paciente!");
        msg.show();
    }

}


