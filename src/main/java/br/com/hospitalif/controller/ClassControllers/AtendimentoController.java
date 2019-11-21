package br.com.hospitalif.controller.ClassControllers;

import application.Main;
import br.com.hospitalif.DAO.AtendimentoDAO;
import br.com.hospitalif.DAO.EnfermidadePessoalDAO;
import br.com.hospitalif.DAO.PacienteDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Atendimento;
import br.com.hospitalif.model.EnfermidadePessoal;
import br.com.hospitalif.model.Paciente;
import com.sun.xml.bind.v2.model.core.PropertyInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import util.Rotas;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AtendimentoController implements Initializable {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private DatePicker txtDataEntr;

    @FXML
    private TextArea txtComentMedico;

    @FXML
    private TextArea txtComentEnfer;

    @FXML
    private ListView<EnfermidadePessoal> listViewEnfEntr;

    @FXML
    private Button addEnfEntr;

    @FXML
    private TextArea txtAreaEnfEntr = new TextArea();

    @FXML
    private ListView<Paciente> listViewPaciente;

    @FXML
    private Button addPaciente;

    @FXML
    private TextArea txtAreaPaciente = new TextArea();

    @FXML
    private Button btnCarregarDados;

    private SimpleEntityManager sem;

    private List<Paciente> listp ;
    private List<EnfermidadePessoal> listaEF;
    private List<Paciente> listp2 ;
    private List<EnfermidadePessoal> listaEF2;
    private Paciente p;
    private List<EnfermidadePessoal> list;


    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

    @FXML
    void cancel(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    @FXML
    void reset(ActionEvent event) {
        txtDataEntr.setValue(null);
        txtComentEnfer.clear();
        txtComentMedico.clear();
        txtAreaEnfEntr.clear();
        txtAreaPaciente.clear();
    }

    @FXML
    void save(ActionEvent event) {

        Atendimento at = new Atendimento();

        at.setData(txtDataEntr.getValue());
        at.setComentarioEnfermeiro(txtComentEnfer.getText());
        at.setComentarioMedico(txtComentMedico.getText());
        at.setPaciente(p);
        at.setSituacaoDoenca(listaEF2);

        AtendimentoDAO atdao = new AtendimentoDAO(sem.getEntityManager());

        atdao.salvar(at);
        sem.close();

        msgInfo();

    }

    @FXML
    void carregaDados(ActionEvent event) {
        sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);

        PacienteDAO pd = new PacienteDAO(sem.getEntityManager());
        listp = pd.getList();

        listViewPaciente.setItems(FXCollections.observableList(listp));
        listViewPaciente.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        EnfermidadePessoalDAO epd = new EnfermidadePessoalDAO(sem.getEntityManager());
        listaEF = epd.getList();

        listViewEnfEntr.setItems(FXCollections.observableList(listaEF));
        listViewEnfEntr.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void adicionarEF(){
        list = listViewEnfEntr.getSelectionModel().getSelectedItems();
        listaEF2 = list;

        this.txtAreaEnfEntr.setText(listaEF2.toString());
    }

    public void adicionarPaciente(){

        p = listViewPaciente.getSelectionModel().getSelectedItem();

        this.txtAreaPaciente.setText(p.toString());
    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Atendimento cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Atendimento!");
        msg.show();
    }


}
