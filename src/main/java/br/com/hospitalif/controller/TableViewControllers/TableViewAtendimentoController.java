package br.com.hospitalif.controller.TableViewControllers;

import br.com.hospitalif.model.Atendimento;
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
import br.com.hospitalif.DAO.AtendimentoDAO;
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
import javafx.util.StringConverter;
import util.Rotas;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewAtendimentoController implements Initializable {
    
    @FXML
    private AnchorPane tableView;

    @FXML
    private TableView<Atendimento> table;

    @FXML
    private TableColumn<Atendimento, LocalDate> colData;

    @FXML
    private TableColumn<Atendimento, String> colPaciente;

    @FXML
    private TableColumn<Atendimento, String> colComMed;

    @FXML
    private TableColumn<Atendimento, String> colComEnfermeiro;

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

    private ObservableList<Atendimento> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);
        carregaTabela();

    }

    @FXML
    void cadastrarAtendimento(ActionEvent event) throws Exception {
        Main.openPage(Rotas.ATENDIMENTO);
    }

    @FXML
    void delete(ActionEvent event) throws Exception {
        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        AtendimentoDAO dao = new AtendimentoDAO(sem.getEntityManager());
        dao.remover(table.getSelectionModel().getSelectedItem().getId());
        Main.openPage(Rotas.TABLEVIEWATENDIMENTO);
    }

    @FXML
    void edit(ActionEvent event) throws Exception {
        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        AtendimentoDAO dao = new AtendimentoDAO(sem.getEntityManager());
        Atendimento m = (Atendimento) table.getSelectionModel().getSelectedItem();
        dao.atualizar(m);
        Main.openPage(Rotas.TABLEVIEWATENDIMENTO);
    }

    @FXML
    void gerarRelatorio(ActionEvent event) {

    }

    @FXML
    void oecComEnfermeiro(TableColumn.CellEditEvent<Atendimento, String> event) {
        Atendimento m = table.getSelectionModel().getSelectedItem();
        m.setComentarioEnfermeiro(event.getNewValue());
    }

    @FXML
    void oecComMed(TableColumn.CellEditEvent<Atendimento, String> event) {
        Atendimento m = table.getSelectionModel().getSelectedItem();
        m.setComentarioMedico(event.getNewValue());
    }

    @FXML
    void oecData(TableColumn.CellEditEvent<Atendimento, LocalDate> event) {
        Atendimento m = table.getSelectionModel().getSelectedItem();
        m.setData(event.getNewValue());
    }

    @FXML
    void oecPaciente(TableColumn.CellEditEvent<Atendimento, Paciente> event) {
        Atendimento m = table.getSelectionModel().getSelectedItem();
        m.setPaciente(event.getNewValue());
    }

    @FXML
    void voltar(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    private void carregaTabela() {

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        AtendimentoDAO dao = new AtendimentoDAO(sem.getEntityManager());
        List<Atendimento> atendimentoList = dao.getList();

        while (!atendimentoList.isEmpty()) {
            int i = 0;
            oblist.add(atendimentoList.remove(i));
            i++;
        }
        FilteredList<Atendimento> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearch.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(Atendimento -> {

                if(newValue == null || newValue.isEmpty() ){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if(Atendimento.getData().toString().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if(Atendimento.getComentarioMedico().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendimento.getComentarioEnfermeiro().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if(Atendimento.getPaciente().getNome().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else{
                    return false;
                }
            });
        }));

        SortedList<Atendimento> sortedData = new SortedList<>(filteredData);
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
//        String sqlInsere = "select * from Atendimento";
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
//                oblist.add(new Atendimento(rs.getLong("id"), rs.getString("nome"), rs.getString("numRegistro"),
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
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colComMed.setCellValueFactory(new PropertyValueFactory<>("comentarioMedico"));
        colComEnfermeiro.setCellValueFactory(new PropertyValueFactory<>("comentarioEnfermeiro"));
        colPaciente.setCellValueFactory(new PropertyValueFactory<>("paciente_id"));

//        colData.setCellFactory(TextFieldTableCell.forTableColumn(StringConverter<LocalDate>));
        colComMed.setCellFactory(TextFieldTableCell.forTableColumn());
        colComEnfermeiro.setCellFactory(TextFieldTableCell.forTableColumn());
        colPaciente.setCellFactory(TextFieldTableCell.forTableColumn());

    }

}
