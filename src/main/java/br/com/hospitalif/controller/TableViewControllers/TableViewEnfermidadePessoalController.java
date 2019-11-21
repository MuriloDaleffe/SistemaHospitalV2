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
import br.com.hospitalif.DAO.EnfermidadePessoalDAO;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.EnfermidadePessoal;
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

public class TableViewEnfermidadePessoalController implements Initializable {
    
    @FXML
    private AnchorPane tableView;

    @FXML
    private TableView<EnfermidadePessoal> table;

    @FXML
    private TableColumn<EnfermidadePessoal, String> colNome;

    @FXML
    private TableColumn<EnfermidadePessoal, String> colDescricao;

    @FXML
    private TableColumn<EnfermidadePessoal, String> colTipo;

    @FXML
    private TableColumn<EnfermidadePessoal, String> colComentario;

    @FXML
    private TableColumn<EnfermidadePessoal, String> colStatusEnfer;

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

    private ObservableList<EnfermidadePessoal> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);
        carregaTabela();

    }

    @FXML
    void cadastrarEnferPes(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ENFERMIDADEPESSOAL);
    }

    @FXML
    void delete(ActionEvent event) throws Exception {
        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EnfermidadePessoalDAO dao = new EnfermidadePessoalDAO(sem.getEntityManager());
        dao.remover(table.getSelectionModel().getSelectedItem().getId());
        Main.openPage(Rotas.TABLEVIEWENFERMIDADEPESSOAL);
    }

    @FXML
    void edit(ActionEvent event) throws Exception {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EnfermidadePessoalDAO dao = new EnfermidadePessoalDAO(sem.getEntityManager());
        EnfermidadePessoal m = (EnfermidadePessoal) table.getSelectionModel().getSelectedItem();
        dao.atualizar(m);
        Main.openPage(Rotas.TABLEVIEWENFERMIDADEPESSOAL);

    }

    @FXML
    void gerarRelatorio(ActionEvent event) {

    }

    @FXML
    void oecComent(TableColumn.CellEditEvent<EnfermidadePessoal, String> event) {
        EnfermidadePessoal m = table.getSelectionModel().getSelectedItem();
        m.setComentario(event.getNewValue());
    }

    @FXML
    void oecDescricao(TableColumn.CellEditEvent<EnfermidadePessoal, String> event) {
        EnfermidadePessoal m = table.getSelectionModel().getSelectedItem();
        m.setDescricao(event.getNewValue());
    }

    @FXML
    void oecNome(TableColumn.CellEditEvent<EnfermidadePessoal, String> event) {
        EnfermidadePessoal m = table.getSelectionModel().getSelectedItem();
        m.setNome(event.getNewValue());
    }

    @FXML
    void oecStsEnf(TableColumn.CellEditEvent<EnfermidadePessoal, String> event) {
        EnfermidadePessoal m = table.getSelectionModel().getSelectedItem();
        m.setStatusDeEnfermidade(event.getNewValue());
    }

    @FXML
    void oecTipo(TableColumn.CellEditEvent<EnfermidadePessoal, String> event) {
        EnfermidadePessoal m = table.getSelectionModel().getSelectedItem();
        m.setTipo(event.getNewValue());
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);

    }

    private void carregaTabela() {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        EnfermidadePessoalDAO dao = new EnfermidadePessoalDAO(sem.getEntityManager());
        List<EnfermidadePessoal> EnfermidadePessoalList = dao.getList();

        while (!EnfermidadePessoalList.isEmpty()) {
            int i = 0;
            oblist.add(EnfermidadePessoalList.remove(i));
            i++;
        }
        FilteredList<EnfermidadePessoal> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(EnfermidadePessoal -> {

                if(newValue == null || newValue.isEmpty() ){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(EnfermidadePessoal.getDescricao().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if(EnfermidadePessoal.getComentario().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(EnfermidadePessoal.getTipo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(EnfermidadePessoal.getStatusDeEnfermidade().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(EnfermidadePessoal.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return false;
                }
            });
        }));

        SortedList<EnfermidadePessoal> sortedData = new SortedList<>(filteredData);
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
//        String sqlInsere = "select * from EnfermidadePessoal";
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
//                oblist.add(new EnfermidadePessoal(rs.getLong("id"), rs.getString("nome"), rs.getString("numRegistro"),
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
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colStatusEnfer.setCellValueFactory(new PropertyValueFactory<>("statusDeEnfermidade"));
        colComentario.setCellValueFactory(new PropertyValueFactory<>("comentario"));

        colNome.setCellFactory(TextFieldTableCell.forTableColumn());
        colDescricao.setCellFactory(TextFieldTableCell.forTableColumn());
        colTipo.setCellFactory(TextFieldTableCell.forTableColumn());
        colStatusEnfer.setCellFactory(TextFieldTableCell.forTableColumn());
        colComentario.setCellFactory(TextFieldTableCell.forTableColumn());

    }

}
