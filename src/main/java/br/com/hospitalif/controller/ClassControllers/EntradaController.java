package br.com.hospitalif.controller.ClassControllers;

import application.Main;
import br.com.hospitalif.DAO.AtendimentoDAO;
import br.com.hospitalif.DAO.EnfermidadePessoalDAO;
import br.com.hospitalif.DAO.EntradaDAO;
import br.com.hospitalif.DAO.PacienteDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Atendimento;
import br.com.hospitalif.model.Entrada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import util.Rotas;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EntradaController implements Initializable {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private DatePicker dateDataEntrada;

    @FXML
    private DatePicker dataDataSaida;

    @FXML
    private ListView<Atendimento> listViewAtendimentos;

    @FXML
    private Button addAtendimento;

    @FXML
    private TextArea txtAreaAtendimentos;

    @FXML
    private TextArea txtStatusEntrada;

    private SimpleEntityManager sem;

    private List<Atendimento> listaAt;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);

        AtendimentoDAO epd = new AtendimentoDAO(sem.getEntityManager());
        listaAt = epd.getList();

        listViewAtendimentos.setItems(FXCollections.observableList(listaAt));
        listViewAtendimentos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    void adicionarAtendimento(ActionEvent event) {
        ObservableList<Atendimento> list = listViewAtendimentos.getSelectionModel().getSelectedItems();
        listaAt = list;

        this.txtAreaAtendimentos.setText(listaAt.toString());
    }

    @FXML
    void cancel(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    @FXML
    void reset(ActionEvent event) {
        dateDataEntrada.setValue(null);
        dataDataSaida.setValue(null);
        txtStatusEntrada.clear();
        txtStatusEntrada.clear();
    }

    @FXML
    void save(ActionEvent event) {
        Entrada ent = new Entrada();

        ent.setDataEntrada(dateDataEntrada.getValue());
        ent.setDataSaida(dataDataSaida.getValue());
        ent.setStatusDeEntrada(txtStatusEntrada.getText());
        ent.setSituacaoDePaciente(listaAt);

        EntradaDAO entDao = new EntradaDAO(sem.getEntityManager());

        entDao.salvar(ent);
        msgInfo();
        sem.close();

    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Entrada cadastrada com sucesso!");
        msg.setHeaderText("Cadastro de Entrada!");
        msg.show();
    }

}

