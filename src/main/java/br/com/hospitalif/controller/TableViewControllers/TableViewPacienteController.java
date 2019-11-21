package br.com.hospitalif.controller.TableViewControllers;

import br.com.hospitalif.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;
import br.com.hospitalif.DAO.PacienteDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import util.Rotas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewPacienteController  implements Initializable {

    @FXML
    private AnchorPane tableView;

    @FXML
    private TableView<Paciente> table;

    @FXML
    private TableColumn<Paciente, String> colNome;

    @FXML
    private TableColumn<Paciente, Integer> colIdade;

    @FXML
    private TableColumn<Paciente, String> colCPF;

    @FXML
    private TableColumn<Paciente, Float> colAltura;

    @FXML
    private TableColumn<Paciente, Float> colPeso;

    @FXML
    private TableColumn<Paciente, String> colTipSang;

    @FXML
    private TableColumn<Paciente, String> colSexo;

    @FXML
    private TableColumn<Paciente, String> colStsPes;

    @FXML
    private Label label;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnGeraRelatorio;

    private ObservableList<Paciente> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);
        carregaTabela();

    }

    @FXML
    void cadastrarPaciente(ActionEvent event)  throws Exception {
        Main.openPage(Rotas.PACIENTE);
    }

    @FXML
    void delete(ActionEvent event) throws Exception {
        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        PacienteDAO dao = new PacienteDAO(sem.getEntityManager());
        dao.remover(table.getSelectionModel().getSelectedItem().getId());
        Main.openPage(Rotas.TABLEVIEWPACIENTE);
    }

    @FXML
    void edit(ActionEvent event) throws Exception {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        PacienteDAO dao = new PacienteDAO(sem.getEntityManager());
        Paciente m = (Paciente) table.getSelectionModel().getSelectedItem();
        dao.atualizar(m);
        Main.openPage(Rotas.TABLEVIEWPACIENTE);

    }

    @FXML
    void gerarRelatorio(ActionEvent event) {

    }

    @FXML
    void oecAltura(TableColumn.CellEditEvent<Paciente, Float> event) {
        Paciente m = table.getSelectionModel().getSelectedItem();
        m.setAltura(event.getNewValue());
    }

    @FXML
    void oecCpf(TableColumn.CellEditEvent<Paciente, String> event) {
        Paciente m = table.getSelectionModel().getSelectedItem();
        m.setCpf(event.getNewValue());
    }

    @FXML
    void oecIdade(TableColumn.CellEditEvent<Paciente, Integer> event) {
        Paciente m = table.getSelectionModel().getSelectedItem();
        m.setIdade(event.getNewValue());
    }

    @FXML
    void oecNome(TableColumn.CellEditEvent<Paciente, String> event) {
        Paciente m = table.getSelectionModel().getSelectedItem();
        m.setNome(event.getNewValue());
    }

    @FXML
    void oecPeso(TableColumn.CellEditEvent<Paciente, Float> event) {
        Paciente m = table.getSelectionModel().getSelectedItem();
        m.setPeso(event.getNewValue());
    }

    @FXML
    void oecSexo(TableColumn.CellEditEvent<Paciente, String> event) {
        Paciente m = table.getSelectionModel().getSelectedItem();
        m.setSexo(event.getNewValue());
    }

    @FXML
    void oecStsPes(TableColumn.CellEditEvent<Paciente, String> event) {
        Paciente m = table.getSelectionModel().getSelectedItem();
        m.setStatusDePessoa(event.getNewValue());
    }

    @FXML
    void oecTpSang(TableColumn.CellEditEvent<Paciente, String> event) {
        Paciente m = table.getSelectionModel().getSelectedItem();
        m.setTipoSanguineo(event.getNewValue());
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);

    }

    private void carregaTabela() {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        PacienteDAO dao = new PacienteDAO(sem.getEntityManager());
        List<Paciente> pacienteList = dao.getList();

        while (!pacienteList.isEmpty()) {
            int i = 0;
            oblist.add(pacienteList.remove(i));
            i++;
        }
        FilteredList<Paciente> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(Paciente -> {

                if(newValue == null || newValue.isEmpty() ){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(Paciente.getAltura() != -1){
                    return true;
                } else if(Paciente.getPeso() != -1){
                    return true;
                }else if(Paciente.getCpf().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Paciente.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Paciente.getSexo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Paciente.getStatusDePessoa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Paciente.getTipoSanguineo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(Paciente.getIdade()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return false;
                }
            });
        }));

        SortedList<Paciente> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());

//        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(person -> {
//                // If filter text is empty, display all persons.
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (person.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches first name.
//                } else if (person.getLastName().toLowerCase().contains(lowerCaseFilter)) {
//                    return true; // Filter matches last name.
//                }
//                return false; // Does not match.
//            });
//        });
//        String sqlInsere = "select * from Paciente";
//
//        ResultSet rs = null;
//
//        try {
//            ConnectionClass conn = new ConnectionClass();
//            Connection conexao = conn.getConnection();
//
//            System.out.println(conn.getStatus());
//
//            rs= conexao.createStatement().executeQuery(sqlInsere);
//
//            while (rs.next()){
//                oblist.add(new Paciente(rs.getLong("id"), rs.getString("nome"), rs.getString("numRegistro"),
//                        rs.getString("especialidade"), rs.getString("login"), rs.getString("senha"),
//                        rs.getString("cpf"), rs.getString("statusDeUsuario"), rs.getInt("idade"),
//                        rs.getString("tipoSanguineo"), rs.getString("sexo"), rs.getString("statusDePessoa")));
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        configuraColunas();

        table.setItems(sortedData);
    }

    private void configuraColunas() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colStsPes.setCellValueFactory(new PropertyValueFactory<>("statusDePessoa"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colTipSang.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));

        colNome.setCellFactory(TextFieldTableCell.forTableColumn());
//        colAltura.setCellFactory(TextFieldTableCell.forTableColumn(Float.toString() altura));
//        colPeso.setCellFactory(TextFieldTableCell.forTableColumn());
//        colIdade.setCellFactory(TextFieldTableCell.forTableColumn());
        colCPF.setCellFactory(TextFieldTableCell.forTableColumn());
        colStsPes.setCellFactory(TextFieldTableCell.forTableColumn());
        colTipSang.setCellFactory(TextFieldTableCell.forTableColumn());
        colSexo.setCellFactory(TextFieldTableCell.forTableColumn());

    }

}
