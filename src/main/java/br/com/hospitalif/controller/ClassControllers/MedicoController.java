package br.com.hospitalif.controller.ClassControllers;

import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Medico;
import util.Rotas;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class MedicoController {

    @FXML
    private Button btnReset;

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
    private TextField altIdade;

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
    private Button btnCancel;


//    @FXML
//    public void initialize() {
//        txtNumRegistro = new TextField();
//        txtEspecialidade = new TextField();
//        txtNome = new TextField();
//        txtStatusUsuario = new TextField();
//        txtLogin = new TextField();
//        txtSenha = new TextField();
//        txtCPF = new TextField();
//        altIdade = new TextField();
//        txtTipoSang = new TextField();
//        cboSexo = new TextField();
//        txtStatusPessoa = new TextField();
//
//    }

    @FXML
    void save(ActionEvent event) throws SQLException {

        Medico m = new Medico();

        m.setNumRegistro(txtNumRegistro.getText());
        m.setEspecialidade(txtEspecialidade.getText());
        m.setNome(txtNome.getText());
        m.setStatusDeUsuario(txtStatusUsuario.getText());
        m.setLogin(txtLogin.getText());
        m.setSenha(txtSenha.getText());
        m.setCpf(txtCPF.getText());
        System.out.println(altIdade.getText());
        m.setIdade(Integer.parseInt(1+altIdade.getText()));
        m.setTipoSanguineo(txtTipoSang.getText());
        m.setSexo(cboSexo.getText());
        m.setStatusDePessoa(txtStatusPessoa.getText());

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        new MedicoDAO(sem.getEntityManager()).salvar(m);
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
        altIdade.clear();
        txtTipoSang.clear();
        cboSexo.clear();
        txtStatusPessoa.clear();
    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Médico cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Médico!");
        msg.show();
    }

    @FXML
    public void editar(Medico m){

        System.out.println(m.getNome());
        txtNome.setText(m.getNome());
        txtNumRegistro.setText(m.getNumRegistro());
        txtEspecialidade.setText(m.getEspecialidade());
        txtStatusUsuario.setText(m.getStatusDeUsuario());
        txtLogin.setText(m.getLogin());
        txtSenha.setText(m.getSenha());
        txtCPF.setText(m.getCpf());
        altIdade.setText(String.valueOf(m.getIdade()));
        txtTipoSang.setText(m.getTipoSanguineo());
        cboSexo.setText(m.getSexo());
        txtStatusPessoa.setText(m.getStatusDePessoa());

    }

}

