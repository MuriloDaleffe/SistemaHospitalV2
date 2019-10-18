package br.com.hospitalif.controller.TableViewControllers;

import application.Main;
import br.com.hospitalif.DAO2.MedicoDAO;
import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.controller.ClassControllers.MedicoController;
import br.com.hospitalif.model.Medico;
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
import javafx.scene.layout.AnchorPane;
import util.Rotas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class TableMedicoViewController implements Initializable {

    @FXML
    private AnchorPane tableView;

    @FXML
    private TableView<Medico> table;

    @FXML
    private TableColumn<Medico, Boolean> colChck;

    @FXML
    private TableColumn<Medico, String> colNome;

    @FXML
    private TableColumn<Medico, String> colNumRegistro;

    @FXML
    private TableColumn<Medico, String> colEspecialidade;

    @FXML
    private TableColumn<Medico, String> colLogin;

    @FXML
    private TableColumn<Medico, String> colSenha;

    @FXML
    private TableColumn<Medico, String> colCPF;

    @FXML
    private TableColumn<Medico, String> colStsUsua;

    @FXML
    private TableColumn<Medico, Integer> colIdade;

    @FXML
    private TableColumn<Medico, String> colTipSang;

    @FXML
    private TableColumn<Medico, String> colSexo;

    @FXML
    private TableColumn<Medico, String> colStsPes;

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

    private ObservableList<Medico> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        MedicoDAO dao = new MedicoDAO(sem.getEntityManager());
        List<Medico> medicoList = dao.findAll("Medico");

        while (!medicoList.isEmpty()) {
            int i = 0;
            oblist.add(medicoList.remove(i));
            i++;
        }
        FilteredList<Medico> filteredData = new FilteredList<>(oblist, b -> true);
        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Medico -> {
                if(newValue == null || newValue.isEmpty() ){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(Medico.getEspecialidade().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if(Medico.getNumRegistro().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Medico.getCpf().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Medico.getLogin().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Medico.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Medico.getSenha().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Medico.getSexo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Medico.getStatusDePessoa().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Medico.getStatusDeUsuario().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Medico.getTipoSanguineo().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(String.valueOf(Medico.getIdade()).indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return false;
                }
            });
        }));

        SortedList<Medico> sortedData = new SortedList<>(filteredData);
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
//        String sqlInsere = "select * from Medico";
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
//                oblist.add(new Medico(rs.getLong("id"), rs.getString("nome"), rs.getString("numRegistro"),
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
//        colNome.setCellFactory(TextFieldTableCell.forTableColumn());
//        colEspecialidade.setCellFactory(TextFieldTableCell.forTableColumn());
//        colCPF.setCellFactory(TextFieldTableCell.forTableColumn());
//        colLogin.setCellFactory(TextFieldTableCell.forTableColumn());
//        colSenha.setCellFactory(TextFieldTableCell.forTableColumn());
//        colStsPes.setCellFactory(TextFieldTableCell.forTableColumn());
//        colStsUsua.setCellFactory(TextFieldTableCell.forTableColumn());
//        colTipSang.setCellFactory(TextFieldTableCell.forTableColumn());
//        colSexo.setCellFactory(TextFieldTableCell.forTableColumn());
//        colNumRegistro.setCellFactory(TextFieldTableCell.forTableColumn());

        table.setItems(sortedData);

    }

    @FXML
    void delete(ActionEvent event) throws SQLException {
//        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
//        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
//        MedicoDAO dao = new MedicoDAO(sem.getEntityManager());
//        dao.delete(table.getSelectionModel().getSelectedItem());
//        sem.beginTransaction();
//        sem.commit();
//        sem.close();

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "delete from Medico where numRegistro = ?";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, table.getSelectionModel().getSelectedItem().getNumRegistro());
        stmt.execute();

    }

    @FXML
    void edit(ActionEvent event) throws Exception {
        MedicoController mc = new MedicoController();
        Main.openPage(Rotas.MEDICO);
        mc.editar(table.getSelectionModel().getSelectedItem());
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    private void configuraColunas() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        colStsPes.setCellValueFactory(new PropertyValueFactory<>("statusDePessoa"));
        colStsUsua.setCellValueFactory(new PropertyValueFactory<>("statusDeUsuario"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colTipSang.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colNumRegistro.setCellValueFactory(new PropertyValueFactory<>("numRegistro"));
        colChck.setCellFactory(CheckBoxTableCell.forTableColumn(colChck));
    }

}

