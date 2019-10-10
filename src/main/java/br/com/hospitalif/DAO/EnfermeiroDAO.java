package br.com.hospitalif.DAO;

import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.model.Enfermeiro;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnfermeiroDAO {


    public static void save(Enfermeiro m) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "insert into Enfermeiro(numRegistro, login, senha, statusDeUsuario, nome, cpf, idade, " +
                "tipoSanguineo, sexo, statusDePessoa) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, m.getNumeroDeRegistro());
        stmt.setString(2, m.getLogin());
        stmt.setString(3, m.getSenha());
        stmt.setString(4, m.getStatusDeUsuario());
        stmt.setString(5, m.getNome());
        stmt.setString(6, m.getCpf());
        stmt.setInt(7, m.getIdade());
        stmt.setString(8, m.getTipoSanguineo());
        stmt.setString(9, m.getSexo());
        stmt.setString(10, m.getStatusDePessoa());
        stmt.execute();
    }

    public static void removeByID(int id) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "delete from Enfermeiro where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        stmt.execute();
    }

    public static void edit(Enfermeiro m) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "update enfermeiro set numRegistro= (?), especialidade= (?), login= (?), senha= (?), " +
                "statusDeUsuario= (?), nome= (?), cpf= (?), idade= (?), tipoSanguineo= (?), sexo= (?), " +
                "statusDePessoa= (?) where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, m.getNumeroDeRegistro());
        stmt.setString(2, m.getLogin());
        stmt.setString(3, m.getSenha());
        stmt.setString(4, m.getStatusDeUsuario());
        stmt.setString(5, m.getNome());
        stmt.setString(6, m.getCpf());
        stmt.setInt(7, m.getIdade());
        stmt.setString(8, m.getTipoSanguineo());
        stmt.setString(9, m.getSexo());
        stmt.setString(10, m.getStatusDePessoa());
        stmt.setInt(11, m.getIdEnfermeiro());
        stmt.execute();
    }

    public static Enfermeiro searchByID(int id) throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from Enfermeiro where id = ?";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        if(result != null && result.next()){
            Enfermeiro enfermeiro = new Enfermeiro();
            enfermeiro.setNome(result.getString("nome"));
            enfermeiro.setCpf(result.getString("cpf"));
            enfermeiro.setIdade(result.getInt("idade"));
            enfermeiro.setTipoSanguineo(result.getString("tipoSanguineo"));
            enfermeiro.setSexo(result.getString("sexo"));
            enfermeiro.setStatusDePessoa(result.getString("statusDePessoa"));
            enfermeiro.setLogin(result.getString("login"));
            enfermeiro.setSenha(result.getString("senha"));
            enfermeiro.setStatusDeUsuario(result.getString("statusDeUsuario"));
            enfermeiro.setNumeroDeRegistro(result.getInt("numRegistro"));
            enfermeiro.setIdEnfermeiro(result.getInt("id"));
            msgInfo(1);
            return enfermeiro;
        }else{
            msgInfo(0);
        }

        return null;

    }

    public static List<Enfermeiro> selectAll() throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from enfermeiro";
        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        ResultSet result = stmt.executeQuery();

        List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();

        while(result.next()) {
            Enfermeiro m1 = new Enfermeiro();
            m1.setNome(result.getString("nome"));
            m1.setCpf(result.getString("cpf"));
            m1.setIdade(result.getInt("idade"));
            m1.setTipoSanguineo(result.getString("tipoSanguineo"));
            m1.setSexo(result.getString("sexo"));
            m1.setStatusDePessoa(result.getString("statusDePessoa"));
            m1.setLogin(result.getString("login"));
            m1.setSenha(result.getString("senha"));
            m1.setStatusDeUsuario(result.getString("statusDeUsuario"));
            m1.setNumeroDeRegistro(result.getInt("numRegistro"));
            m1.setIdEnfermeiro(result.getInt("id"));
            enfermeiros.add(m1);
        }
        return enfermeiros;
    }

    public static void msgInfo(int num){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        if(num==1){
            msg.setContentText("Registro encontrado!");
            msg.setHeaderText("Busca");
            msg.show();
        }else{
            msg.setContentText("Não foi possível encontrar nenhum registro!");
            msg.setHeaderText("Busca");
            msg.show();
        }
    }

}
