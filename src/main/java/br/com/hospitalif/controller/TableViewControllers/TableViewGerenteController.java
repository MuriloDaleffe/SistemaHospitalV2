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
import br.com.hospitalif.DAO.GerenteDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Gerente;
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
import net.sf.jasperreports.engine.JRException;
import report.PrintReport;
import util.Rotas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewGerenteController  implements Initializable {
    
    @FXML
    private AnchorPane tableView;

    @FXML
    private TableView<Gerente> table;

    @FXML
    private TableColumn<Gerente, String> colNome;

    @FXML
    private TableColumn<Gerente, String> colCargo;

    @FXML
    private TableColumn<Gerente, String> colLogin;

    @FXML
    private TableColumn<Gerente, String> colSenha;

    @FXML
    private TableColumn<Gerente, String> colCPF;

    @FXML
    private TableColumn<Gerente, String> colStsUsua;

    @FXML
    private TableColumn<Gerente, Integer> colIdade;

    @FXML
    private TableColumn<Gerente, String> colTipSang;

    @FXML
    private TableColumn<Gerente, String> colSexo;

    @FXML
    private TableColumn<Gerente, String> colStsPes;

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

    private ObservableList<Gerente> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);
        carregaTabela();

    }

    @FXML
    void cadastrarGerente(ActionEvent event) throws Exception {
        Main.openPage(Rotas.GERENTE);
    }

    @FXML
    void delete(ActionEvent event) throws Exception {
        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        GerenteDAO dao = new GerenteDAO(sem.getEntityManager());
        dao.remover(table.getSelectionModel().getSelectedItem().getId());
        Main.openPage(Rotas.TABLEVIEWGERENTE);
    }

    @FXML
    void edit(ActionEvent event) throws Exception {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        GerenteDAO dao = new GerenteDAO(sem.getEntityManager());
        Gerente m = (Gerente) table.getSelectionModel().getSelectedItem();
        dao.atualizar(m);
        Main.openPage(Rotas.TABLEVIEWGERENTE);

    }

    @FXML
    void gerarRelatorio(ActionEvent event) throws ClassNotFoundException, SQLException, JRException {
        PrintReport pr = new PrintReport();
        pr.showReport("Relatorio_Gerentes.jrxml");
    }

    @FXML
    void oecCargo(TableColumn.CellEditEvent<Gerente, String> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setCargo(event.getNewValue());
    }

    @FXML
    void oecCpf(TableColumn.CellEditEvent<Gerente, String> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setCpf(event.getNewValue());
    }

    @FXML
    void oecIdade(TableColumn.CellEditEvent<Gerente, Integer> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setIdade(event.getNewValue());
    }

    @FXML
    void oecLog(TableColumn.CellEditEvent<Gerente, String> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setLogin(event.getNewValue());
    }

    @FXML
    void oecNome(TableColumn.CellEditEvent<Gerente, String> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setNome(event.getNewValue());
    }

    @FXML
    void oecSen(TableColumn.CellEditEvent<Gerente, String> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setSenha(event.getNewValue());
    }

    @FXML
    void oecSexo(TableColumn.CellEditEvent<Gerente, String> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setSexo(event.getNewValue());
    }

    @FXML
    void oecStsPes(TableColumn.CellEditEvent<Gerente, String> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setStatusDePessoa(event.getNewValue());
    }

    @FXML
    void oecStsUsr(TableColumn.CellEditEvent<Gerente, String> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setStatusDeUsuario(event.getNewValue());
    }

    @FXML
    void oecTpSang(TableColumn.CellEditEvent<Gerente, String> event) {
        Gerente m = table.getSelectionModel().getSelectedItem();
        m.setTipoSanguineo(event.getNewValue());
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);

    }


    private void carregaTabela() {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        GerenteDAO dao = new GerenteDAO(sem.getEntityManager());
        List<Gerente> gerenteList = dao.getList();

        while (!gerenteList.isEmpty()) {
            int i = 0;
            oblist.add(gerenteList.remove(i));
            i++;
        }
        FilteredList<Gerente> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(Gerente -> {

                if(newValue == null || newValue.isEmpty() ){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(Gerente.getCargo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Gerente.getCpf().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Gerente.getLogin().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Gerente.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Gerente.getSenha().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Gerente.getSexo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Gerente.getStatusDePessoa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Gerente.getStatusDeUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Gerente.getTipoSanguineo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(Gerente.getIdade()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return false;
                }
            });
        }));

        SortedList<Gerente> sortedData = new SortedList<>(filteredData);
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
//        String sqlInsere = "select * from Gerente";
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
//                oblist.add(new Gerente(rs.getLong("id"), rs.getString("nome"), rs.getString("numRegistro"),
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
