package br.com.hospitalif.controller.TableViewControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;
import br.com.hospitalif.DAO.AdministradorDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Administrador;
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

public class TableViewAdministradorController  implements Initializable {

    @FXML
    private AnchorPane tableView;

    @FXML
    private TableView<Administrador> table;

    @FXML
    private TableColumn<Administrador, String> colNome;

    @FXML
    private TableColumn<Administrador, String> colCargo;

    @FXML
    private TableColumn<Administrador, String> colLogin;

    @FXML
    private TableColumn<Administrador, String> colSenha;

    @FXML
    private TableColumn<Administrador, String> colCPF;

    @FXML
    private TableColumn<Administrador, String> colStsUsua;

    @FXML
    private TableColumn<Administrador, Integer> colIdade;

    @FXML
    private TableColumn<Administrador, String> colTipSang;

    @FXML
    private TableColumn<Administrador, String> colSexo;

    @FXML
    private TableColumn<Administrador, String> colStsPes;

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

    private ObservableList<Administrador> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);
        carregaTabela();

    }

    @FXML
    void cadastrarAdm(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ADMINISTRADOR);
    }

    @FXML
    void delete(ActionEvent event) throws Exception {
        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        AdministradorDAO dao = new AdministradorDAO(sem.getEntityManager());
        dao.remover(table.getSelectionModel().getSelectedItem().getId());
        Main.openPage(Rotas.TABLEVIEWADMINISTRADOR);
    }

    @FXML
    void edit(ActionEvent event) throws Exception {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        AdministradorDAO dao = new AdministradorDAO(sem.getEntityManager());
        Administrador m = (Administrador) table.getSelectionModel().getSelectedItem();
        dao.atualizar(m);
        Main.openPage(Rotas.TABLEVIEWADMINISTRADOR);

    }

    @FXML
    void gerarRelatorio(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);

    }

    @FXML
    void oecCargo(TableColumn.CellEditEvent<Administrador, String> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setCpf(event.getNewValue());
    }

    @FXML
    void oecCpf(TableColumn.CellEditEvent<Administrador, String> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setCpf(event.getNewValue());
    }

    @FXML
    void oecIdade(TableColumn.CellEditEvent<Administrador, Integer> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setIdade(event.getNewValue());
    }

    @FXML
    void oecLog(TableColumn.CellEditEvent<Administrador, String> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setLogin(event.getNewValue());
    }

    @FXML
    void oecNome(TableColumn.CellEditEvent<Administrador, String> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setNome(event.getNewValue());
    }

    @FXML
    void oecSen(TableColumn.CellEditEvent<Administrador, String> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setSenha(event.getNewValue());
    }

    @FXML
    void oecSexo(TableColumn.CellEditEvent<Administrador, String> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setSexo(event.getNewValue());
    }

    @FXML
    void oecStsPes(TableColumn.CellEditEvent<Administrador, String> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setStatusDePessoa(event.getNewValue());
    }

    @FXML
    void oecStsUsr(TableColumn.CellEditEvent<Administrador, String> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setStatusDeUsuario(event.getNewValue());
    }

    @FXML
    void oecTpSang(TableColumn.CellEditEvent<Administrador, String> event) {
        Administrador m = table.getSelectionModel().getSelectedItem();
        m.setTipoSanguineo(event.getNewValue());
    }


    private void carregaTabela() {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        AdministradorDAO dao = new AdministradorDAO(sem.getEntityManager());
        List<Administrador> administradorList = dao.getList();

        while (!administradorList.isEmpty()) {
            int i = 0;
            oblist.add(administradorList.remove(i));
            i++;
        }
        FilteredList<Administrador> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(Administrador -> {

                if(newValue == null || newValue.isEmpty() ){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(Administrador.getCargo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if(Administrador.getCpf().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Administrador.getLogin().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Administrador.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Administrador.getSenha().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Administrador.getSexo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Administrador.getStatusDePessoa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Administrador.getStatusDeUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Administrador.getTipoSanguineo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(Administrador.getIdade()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return false;
                }
            });
        }));

        SortedList<Administrador> sortedData = new SortedList<>(filteredData);
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
//        String sqlInsere = "select * from Administrador";
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
//                oblist.add(new Administrador(rs.getLong("id"), rs.getString("nome"), rs.getString("numRegistro"),
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
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        colStsPes.setCellValueFactory(new PropertyValueFactory<>("statusDePessoa"));
        colStsUsua.setCellValueFactory(new PropertyValueFactory<>("statusDeUsuario"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colTipSang.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));

        colNome.setCellFactory(TextFieldTableCell.forTableColumn());
        colCargo.setCellFactory(TextFieldTableCell.forTableColumn());
        colCPF.setCellFactory(TextFieldTableCell.forTableColumn());
        colLogin.setCellFactory(TextFieldTableCell.forTableColumn());
        colSenha.setCellFactory(TextFieldTableCell.forTableColumn());
        colStsPes.setCellFactory(TextFieldTableCell.forTableColumn());
        colStsUsua.setCellFactory(TextFieldTableCell.forTableColumn());
        colTipSang.setCellFactory(TextFieldTableCell.forTableColumn());
        colSexo.setCellFactory(TextFieldTableCell.forTableColumn());

    }

}
