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
import br.com.hospitalif.DAO.AtendenteDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Atendente;
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

public class TableViewAtendenteController  implements Initializable {
    
    @FXML
    private AnchorPane tableView;

    @FXML
    private TableView<Atendente> table;

    @FXML
    private TableColumn<Atendente, String> colNome;

    @FXML
    private TableColumn<Atendente, String> colCargo;

    @FXML
    private TableColumn<Atendente, String> colLogin;

    @FXML
    private TableColumn<Atendente, String> colSenha;

    @FXML
    private TableColumn<Atendente, String> colCPF;

    @FXML
    private TableColumn<Atendente, String> colStsUsua;

    @FXML
    private TableColumn<Atendente, Integer> colIdade;

    @FXML
    private TableColumn<Atendente, String> colTipSang;

    @FXML
    private TableColumn<Atendente, String> colSexo;

    @FXML
    private TableColumn<Atendente, String> colStsPes;

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

    private ObservableList<Atendente> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);
        carregaTabela();

    }

    @FXML
    void cadastrarAtendente(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ATENDENTE);
    }

    @FXML
    void delete(ActionEvent event) throws Exception {
        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        AtendenteDAO dao = new AtendenteDAO(sem.getEntityManager());
        dao.remover(table.getSelectionModel().getSelectedItem().getId());
        Main.openPage(Rotas.TABLEVIEWATENDENTE);
    }

    @FXML
    void edit(ActionEvent event) throws Exception {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        AtendenteDAO dao = new AtendenteDAO(sem.getEntityManager());
        Atendente m = (Atendente) table.getSelectionModel().getSelectedItem();
        dao.atualizar(m);
        Main.openPage(Rotas.TABLEVIEWATENDENTE);

    }

    @FXML
    void gerarRelatorio(ActionEvent event) throws ClassNotFoundException, SQLException, JRException {
        PrintReport pr = new PrintReport();
        pr.showReport("Relatorio_Atendentes.jrxml");
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);

    }

    @FXML
    void oecCargo(TableColumn.CellEditEvent<Atendente, String> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setCpf(event.getNewValue());
    }

    @FXML
    void oecCpf(TableColumn.CellEditEvent<Atendente, String> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setCpf(event.getNewValue());
    }

    @FXML
    void oecIdade(TableColumn.CellEditEvent<Atendente, Integer> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setIdade(event.getNewValue());
    }

    @FXML
    void oecLog(TableColumn.CellEditEvent<Atendente, String> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setLogin(event.getNewValue());
    }

    @FXML
    void oecNome(TableColumn.CellEditEvent<Atendente, String> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setNome(event.getNewValue());
    }

    @FXML
    void oecSen(TableColumn.CellEditEvent<Atendente, String> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setSenha(event.getNewValue());
    }

    @FXML
    void oecSexo(TableColumn.CellEditEvent<Atendente, String> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setSexo(event.getNewValue());
    }

    @FXML
    void oecStsPes(TableColumn.CellEditEvent<Atendente, String> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setStatusDePessoa(event.getNewValue());
    }

    @FXML
    void oecStsUsr(TableColumn.CellEditEvent<Atendente, String> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setStatusDeUsuario(event.getNewValue());
    }

    @FXML
    void oecTpSang(TableColumn.CellEditEvent<Atendente, String> event) {
        Atendente m = table.getSelectionModel().getSelectedItem();
        m.setTipoSanguineo(event.getNewValue());
    }


    private void carregaTabela() {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        AtendenteDAO dao = new AtendenteDAO(sem.getEntityManager());
        List<Atendente> atendenteList = dao.getList();

        while (!atendenteList.isEmpty()) {
            int i = 0;
            oblist.add(atendenteList.remove(i));
            i++;
        }
        FilteredList<Atendente> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(Atendente -> {

                if(newValue == null || newValue.isEmpty() ){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(Atendente.getCargo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendente.getCpf().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendente.getLogin().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendente.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendente.getSenha().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendente.getSexo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendente.getStatusDePessoa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendente.getStatusDeUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendente.getTipoSanguineo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(Atendente.getIdade()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return false;
                }
            });
        }));

        SortedList<Atendente> sortedData = new SortedList<>(filteredData);
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
//        String sqlInsere = "select * from Atendente";
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
//                oblist.add(new Atendente(rs.getLong("id"), rs.getString("nome"), rs.getString("numRegistro"),
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
        colCargo.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
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
