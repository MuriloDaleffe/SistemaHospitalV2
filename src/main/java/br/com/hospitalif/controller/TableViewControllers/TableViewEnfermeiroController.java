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
import br.com.hospitalif.DAO.EnfermeiroDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Enfermeiro;
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

public class TableViewEnfermeiroController  implements Initializable {
    
    @FXML
    private AnchorPane tableView;

    @FXML
    private TableView<Enfermeiro> table;

    @FXML
    private TableColumn<Enfermeiro, String> colNome;

    @FXML
    private TableColumn<Enfermeiro, String> colNumRegistro;

    @FXML
    private TableColumn<Enfermeiro, String> colLogin;

    @FXML
    private TableColumn<Enfermeiro, String> colSenha;

    @FXML
    private TableColumn<Enfermeiro, String> colCPF;

    @FXML
    private TableColumn<Enfermeiro, String> colStsUsua;

    @FXML
    private TableColumn<Enfermeiro, Integer> colIdade;

    @FXML
    private TableColumn<Enfermeiro, String> colTipSang;

    @FXML
    private TableColumn<Enfermeiro, String> colSexo;

    @FXML
    private TableColumn<Enfermeiro, String> colStsPes;

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

    private ObservableList<Enfermeiro> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);
        carregaTabela();

    }

    @FXML
    void cadastrarEnfermeiro(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ENFERMEIRO);
    }

    @FXML
    void delete(ActionEvent event) throws Exception {
        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EnfermeiroDAO dao = new EnfermeiroDAO(sem.getEntityManager());
        dao.remover(table.getSelectionModel().getSelectedItem().getId());
        Main.openPage(Rotas.TABLEVIEWENFERMEIRO);
    }

    @FXML
    void edit(ActionEvent event) throws Exception {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EnfermeiroDAO dao = new EnfermeiroDAO(sem.getEntityManager());
        Enfermeiro m = (Enfermeiro) table.getSelectionModel().getSelectedItem();
        dao.atualizar(m);
        Main.openPage(Rotas.TABLEVIEWENFERMEIRO);

    }

    @FXML
    void gerarRelatorio(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);

    }

    @FXML
    void oecCpf(TableColumn.CellEditEvent<Enfermeiro, String> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setCpf(event.getNewValue());
    }

    @FXML
    void oecIdade(TableColumn.CellEditEvent<Enfermeiro, Integer> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setIdade(event.getNewValue());
    }

    @FXML
    void oecLog(TableColumn.CellEditEvent<Enfermeiro, String> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setLogin(event.getNewValue());
    }

    @FXML
    void oecNome(TableColumn.CellEditEvent<Enfermeiro, String> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setNome(event.getNewValue());
    }

    @FXML
    void oecNumReg(TableColumn.CellEditEvent<Enfermeiro, String> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setNumeroDeRegistro(event.getNewValue());
    }

    @FXML
    void oecSen(TableColumn.CellEditEvent<Enfermeiro, String> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setSenha(event.getNewValue());
    }

    @FXML
    void oecSexo(TableColumn.CellEditEvent<Enfermeiro, String> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setSexo(event.getNewValue());
    }

    @FXML
    void oecStsPes(TableColumn.CellEditEvent<Enfermeiro, String> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setStatusDePessoa(event.getNewValue());
    }

    @FXML
    void oecStsUsr(TableColumn.CellEditEvent<Enfermeiro, String> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setStatusDeUsuario(event.getNewValue());
    }

    @FXML
    void oecTpSang(TableColumn.CellEditEvent<Enfermeiro, String> event) {
        Enfermeiro m = table.getSelectionModel().getSelectedItem();
        m.setTipoSanguineo(event.getNewValue());
    }

    private void carregaTabela() {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EnfermeiroDAO dao = new EnfermeiroDAO(sem.getEntityManager());
        List<Enfermeiro> enfermeiroList = dao.getList();

        while (!enfermeiroList.isEmpty()) {
            int i = 0;
            oblist.add(enfermeiroList.remove(i));
            i++;
        }
        FilteredList<Enfermeiro> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(Enfermeiro -> {

                if(newValue == null || newValue.isEmpty() ){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(Enfermeiro.getNumeroDeRegistro().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Enfermeiro.getCpf().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Enfermeiro.getLogin().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Enfermeiro.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Enfermeiro.getSenha().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Enfermeiro.getSexo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Enfermeiro.getStatusDePessoa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Enfermeiro.getStatusDeUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Enfermeiro.getTipoSanguineo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(Enfermeiro.getIdade()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return false;
                }
            });
        }));

        SortedList<Enfermeiro> sortedData = new SortedList<>(filteredData);
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
//        String sqlInsere = "select * from Enfermeiro";
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
//                oblist.add(new Enfermeiro(rs.getLong("id"), rs.getString("nome"), rs.getString("numRegistro"),
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
        colNumRegistro.setCellValueFactory(new PropertyValueFactory<>("numeroDeRegistro"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        colStsPes.setCellValueFactory(new PropertyValueFactory<>("statusDePessoa"));
        colStsUsua.setCellValueFactory(new PropertyValueFactory<>("statusDeUsuario"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colTipSang.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colNumRegistro.setCellValueFactory(new PropertyValueFactory<>("numRegistro"));

        colNome.setCellFactory(TextFieldTableCell.forTableColumn());
        colNumRegistro.setCellFactory(TextFieldTableCell.forTableColumn());
        colCPF.setCellFactory(TextFieldTableCell.forTableColumn());
        colLogin.setCellFactory(TextFieldTableCell.forTableColumn());
        colSenha.setCellFactory(TextFieldTableCell.forTableColumn());
        colStsPes.setCellFactory(TextFieldTableCell.forTableColumn());
        colStsUsua.setCellFactory(TextFieldTableCell.forTableColumn());
        colTipSang.setCellFactory(TextFieldTableCell.forTableColumn());
        colSexo.setCellFactory(TextFieldTableCell.forTableColumn());
        colNumRegistro.setCellFactory(TextFieldTableCell.forTableColumn());
    }

}
