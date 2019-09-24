package br.com.hospitalif.DAO;

import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {

    private static final String tabela = "medico";

    public static void saveMedico(Medico m) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "insert into (?) values(?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, tabela);
        stmt.setString(2, m.getNumeroRegistro());
        stmt.setString(3, m.getEspecialidade());
        stmt.setInt(4, m.getIdFuncionario());
        stmt.execute();
    }

    public void removeByID(int id) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "delete from "+tabela+" where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        stmt.execute();
    }

    public void editByID(int id, String numReg, String espec, int idFunc) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "update (?) set numeroderegistro= (?), especialidade= (?), id_funcionario= (?) where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, tabela);
        stmt.setString(2, numReg);
        stmt.setString(3, espec);
        stmt.setInt(4, idFunc);
        stmt.setInt(5, id);
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
        Object result = stmt.executeQuery(sqlInsere);

        System.out.println(result.toString());

    }

}
