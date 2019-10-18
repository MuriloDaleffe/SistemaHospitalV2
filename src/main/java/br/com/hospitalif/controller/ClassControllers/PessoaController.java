package br.com.hospitalif.controller.ClassControllers;

import br.com.hospitalif.connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaController {

    @FXML
    private TextField txtNome;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField intIdade;

    @FXML
    private TextField txtTipoSang;

    @FXML
    private TextField cboSexo;

    @FXML
    private TextField txtStatus;

    @FXML
    void cadastrarPessoa(ActionEvent event) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String sql = "insert into pessoa(nome, cpf, idade, tipoSanguineo, sexo, statusDePessoa) " +
                "values(?, ?, ?, ?, ?, ?)";

        try{

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, txtNome.getText());
            stmt.setString(2, txtCPF.getText());
            stmt.setInt(3, Integer.parseInt(intIdade.getText()));
            stmt.setString(4, txtTipoSang.getText());
            stmt.setString(5, cboSexo.getText());
            stmt.setString(6, txtStatus.getText());

            stmt.execute();
            stmt.close();

            System.out.println("Gravado!");

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void reset(ActionEvent event) {

    }

}
