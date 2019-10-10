package br.com.hospitalif.DAO;

import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDAO {


    public static void saveMedico(Medico m) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "insert into Medico(numRegistro, especialidade, login, senha, statusDeUsuario, nome, cpf, idade, " +
                            "tipoSanguineo, sexo, statusDePessoa) values(?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, m.getNumeroRegistro());
        stmt.setString(2, m.getEspecialidade());
        stmt.setString(3, m.getLogin());
        stmt.setString(4, m.getSenha());
        stmt.setString(5, m.getStatusDeUsuario());
        stmt.setString(6, m.getNome());
        stmt.setString(7, m.getCpf());
        stmt.setInt(8, m.getIdade());
        stmt.setString(9, m.getTipoSanguineo());
        stmt.setString(10, m.getSexo());
        stmt.setString(11, m.getStatusDePessoa());
        stmt.execute();
    }

    public static void removeByID(Medico m) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "delete from Medico where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, m.getIdMedico());
        stmt.execute();
    }

    public static void editByID(Medico m) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "update Medico set numRegistro= (?), especialidade= (?), login= (?), senha= (?), " +
                            "statusDeUsuario= (?), nome= (?), cpf= (?), idade= (?), tipoSanguineo= (?), sexo= (?), " +
                            "statusDePessoa= (?) where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, m.getNumeroRegistro());
        stmt.setString(2, m.getEspecialidade());
        stmt.setString(3, m.getLogin());
        stmt.setString(4, m.getSenha());
        stmt.setString(5, m.getStatusDeUsuario());
        stmt.setString(6, m.getNome());
        stmt.setString(7, m.getCpf());
        stmt.setInt(8, m.getIdade());
        stmt.setString(9, m.getTipoSanguineo());
        stmt.setString(10, m.getSexo());
        stmt.setString(11, m.getStatusDePessoa());
        stmt.setInt(12, m.getIdMedico());
        stmt.execute();
    }

    public static void searchByID(int id) throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from Medico where id = ?";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        System.out.println(result.toString());

    }

}
