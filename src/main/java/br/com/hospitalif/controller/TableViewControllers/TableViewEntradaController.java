package br.com.hospitalif.controller.TableViewControllers;

import br.com.hospitalif.model.Entrada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;
import br.com.hospitalif.DAO.EntradaDAO;
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
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewEntradaController implements Initializable {
    
    @FXML
    private AnchorPane tableView;

    @FXML
    private TableView<Entrada> table;

    @FXML
    private TableColumn<Entrada, LocalDate> colDataEnt;

    @FXML
    private TableColumn<Entrada, LocalDate> colDataSaida;

    @FXML
    private TableColumn<Entrada, String> colStsEnt;

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

    private ObservableList<Entrada> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);
        carregaTabela();

    }

    @FXML
    void cadastrarEntrada(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ENTRADA);
    }

    @FXML
    void delete(ActionEvent event)  throws Exception {
        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EntradaDAO dao = new EntradaDAO(sem.getEntityManager());
        dao.remover(table.getSelectionModel().getSelectedItem().getId());
        Main.openPage(Rotas.TABLEVIEWENTRADA);
    }

    @FXML
    void edit(ActionEvent event) throws Exception {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EntradaDAO dao = new EntradaDAO(sem.getEntityManager());
        Entrada m = (Entrada) table.getSelectionModel().getSelectedItem();
        dao.atualizar(m);
        Main.openPage(Rotas.TABLEVIEWENTRADA);

    }

    @FXML
    void gerarRelatorio(ActionEvent event) {

    }

    @FXML
    void oecDataEnt(TableColumn.CellEditEvent<Entrada, LocalDate> event) {
        Entrada m = table.getSelectionModel().getSelectedItem();
        m.setDataEntrada(event.getNewValue());
    }

    @FXML
    void oecDataSaida(TableColumn.CellEditEvent<Entrada, LocalDate> event) {
        Entrada m = table.getSelectionModel().getSelectedItem();
        m.setDataSaida(event.getNewValue());
    }

    @FXML
    void oecStsEnt(TableColumn.CellEditEvent<Entrada, String> event) {
        Entrada m = table.getSelectionModel().getSelectedItem();
        m.setStatusDeEntrada(event.getNewValue());
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);

    }

    private void carregaTabela() {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EntradaDAO dao = new EntradaDAO(sem.getEntityManager());
        List<Entrada> entradaList = dao.getList();

        while (!entradaList.isEmpty()) {
            int i = 0;
            oblist.add(entradaList.remove(i));
            i++;
        }
        FilteredList<Entrada> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(Entrada -> {

                if(newValue == null || newValue.isEmpty() ){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(Entrada.getDataEntrada().toString().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if(Entrada.getDataSaida().toString().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Entrada.getDataSaida().toString().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else {
                    return false;
                }
            });
        }));

        SortedList<Entrada> sortedData = new SortedList<>(filteredData);
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
//        String sqlInsere = "select * from Entrada";
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
//                oblist.add(new Entrada(rs.getLong("id"), rs.getString("nome"), rs.getString("numRegistro"),
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
        colDataEnt.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));
        colDataSaida.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));
        colStsEnt.setCellValueFactory(new PropertyValueFactory<>("statusDeEntrada"));

//        colDataEnt.setCellFactory(TextFieldTableCell.forTableColumn());
//        colDataSaida.setCellFactory(TextFieldTableCell.forTableColumn());
        colStsEnt.setCellFactory(TextFieldTableCell.forTableColumn());

    }

}
