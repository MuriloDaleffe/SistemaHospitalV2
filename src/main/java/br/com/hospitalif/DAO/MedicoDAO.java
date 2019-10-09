package br.com.hospitalif.DAO;

import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDAO {

    private static final String tabela = "medico";

    public static void saveMedico(Medico m) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "insert into (?) values(?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, tabela);
        stmt.setString(2, m.getNumeroRegistro());
        stmt.setString(3, m.getEspecialidade());
        stmt.setString(4, m.getLogin());
        stmt.setString(5, m.getSenha());
        stmt.setString(6, m.getStatusDeUsuario());
        stmt.setString(7, m.getNome());
        stmt.setString(8, m.getCpf());
        stmt.setInt(9, m.getIdade());
        stmt.setString(10, m.getTipoSanguineo());
        stmt.setString(11, m.getSexo());
        stmt.setString(12, m.getStatusDePessoa());
        stmt.execute();
    }

    public void removeByID(Medico m) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "delete from (?) where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, tabela);
        stmt.setInt(2, m.getIdMedico());
        stmt.execute();
    }

    public void editByID(Medico m) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "update (?) set numRegistro= (?), especialidade= (?), login= (?), senha= (?), " +
                            "statusDeUsuario= (?), nome= (?), cpf= (?), idade= (?), tipoSanguineo= (?), sexo= (?), " +
                            "statusDePessoa= (?) where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, tabela);
        stmt.setString(2, m.getNumeroRegistro());
        stmt.setString(3, m.getEspecialidade());
        stmt.setString(4, m.getLogin());
        stmt.setString(5, m.getSenha());
        stmt.setString(6, m.getStatusDeUsuario());
        stmt.setString(7, m.getNome());
        stmt.setString(8, m.getCpf());
        stmt.setInt(9, m.getIdade());
        stmt.setString(10, m.getTipoSanguineo());
        stmt.setString(11, m.getSexo());
        stmt.setString(12, m.getStatusDePessoa());
        stmt.setInt(13, m.getIdMedico());
        stmt.execute();
    }

    public void searchByID(int id) throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from (?) where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1,tabela);
        stmt.setInt(2, id);
        ResultSet result = stmt.executeQuery(sqlInsere);

        System.out.println(result.toString());

    }

}
