package br.com.hospitalif.DAO;

import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.model.Paciente;

import java.sql.*;

public class PacienteDAO {
    
    public static void criarPaciente(Paciente p) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "insert into Paciente(nome, cpf, idade, tipoSanguineo, sexo, statusDePessoa, doenca, historico) " +
                            "values(?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getCpf());
        stmt.setInt(3, p.getIdade());
        stmt.setString(4, p.getTipoSanguineo());
        stmt.setString(5, p.getSexo());
        stmt.setString(6, p.getStatusDePessoa());
        stmt.setArray(7, (Array) p.getDoenca());
        stmt.setArray(8, (Array) p.getHistorico());
        stmt.execute();
        
    }

    public static void removeByID(Paciente p) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "delete from Paciente where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, p.getIdPaciente());
        stmt.execute();
    }

    public static void editByID(Paciente p) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "update Paciente set nome= (?), cpf= (?), idade= (?), tipoSanguineo= (?), sexo= (?), " +
                "statusDePessoa= (?), doenca= (?), historico= (?) where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
//        stmt.setString(1, m.getNumeroRegistro());
//        stmt.setString(2, m.getEspecialidade());
//        stmt.setString(3, m.getLogin());
//        stmt.setString(4, m.getSenha());
//        stmt.setString(5, m.getStatusDeUsuario());
//        stmt.setString(6, m.getNome());
//        stmt.setString(7, m.getCpf());
//        stmt.setInt(8, m.getIdade());
//        stmt.setString(9, m.getTipoSanguineo());
//        stmt.setString(10, m.getSexo());
//        stmt.setString(11, m.getStatusDePessoa());
//        stmt.setInt(12, m.getIdMedico());
        stmt.execute();
    }

    public static void searchByID(int id) throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from Paciente where id = ?";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        System.out.println(result.toString());

    }
}
