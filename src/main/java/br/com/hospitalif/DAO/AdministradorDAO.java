package br.com.hospitalif.DAO;

import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.model.Administrador;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {


    public static void save(Administrador g) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "insert into Administrador(cargo, login, senha, statusDeUsuario, nome, cpf, idade, " +
                "tipoSanguineo, sexo, statusDePessoa) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, g.getCargo());
        stmt.setString(2, g.getLogin());
        stmt.setString(3, g.getSenha());
        stmt.setString(4, g.getStatusDeUsuario());
        stmt.setString(5, g.getNome());
        stmt.setString(6, g.getCpf());
        stmt.setInt(7, g.getIdade());
        stmt.setString(8, g.getTipoSanguineo());
        stmt.setString(9, g.getSexo());
        stmt.setString(10, g.getStatusDePessoa());
        stmt.execute();
    }

    public static void removeByID(int id) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "delete from Administrador where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        stmt.execute();
    }

    public static void edit(Administrador g) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "update Administrador set cargo= (?), login= (?), senha= (?), " +
                "statusDeUsuario= (?), nome= (?), cpf= (?), idade= (?), tipoSanguineo= (?), sexo= (?), " +
                "statusDePessoa= (?) where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, g.getCargo());
        stmt.setString(2, g.getLogin());
        stmt.setString(3, g.getSenha());
        stmt.setString(4, g.getStatusDeUsuario());
        stmt.setString(5, g.getNome());
        stmt.setString(6, g.getCpf());
        stmt.setInt(7, g.getIdade());
        stmt.setString(8, g.getTipoSanguineo());
        stmt.setString(9, g.getSexo());
        stmt.setString(10, g.getStatusDePessoa());
        stmt.setInt(11, g.getIdAdministrador());
        stmt.execute();
    }

    public static Administrador searchByID(int id) throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from Administrador where id = ?";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        if(result != null && result.next()){
            Administrador administrador = new Administrador();
            administrador.setNome(result.getString("nome"));
            administrador.setCpf(result.getString("cpf"));
            administrador.setIdade(result.getInt("idade"));
            administrador.setTipoSanguineo(result.getString("tipoSanguineo"));
            administrador.setSexo(result.getString("sexo"));
            administrador.setStatusDePessoa(result.getString("statusDePessoa"));
            administrador.setLogin(result.getString("login"));
            administrador.setSenha(result.getString("senha"));
            administrador.setStatusDeUsuario(result.getString("statusDeUsuario"));
            administrador.setIdAdministrador(result.getInt("id"));
            msgInfo(1);
            return administrador;
        }else{
            msgInfo(0);
        }

        return null;

    }

    public static List<Administrador> selectAll() throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from administrador";
        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        ResultSet result = stmt.executeQuery();

        List<Administrador> administradors = new ArrayList<Administrador>();

        while(result.next()) {
            Administrador g1 = new Administrador();
            g1.setNome(result.getString("nome"));
            g1.setCpf(result.getString("cpf"));
            g1.setIdade(result.getInt("idade"));
            g1.setTipoSanguineo(result.getString("tipoSanguineo"));
            g1.setSexo(result.getString("sexo"));
            g1.setStatusDePessoa(result.getString("statusDePessoa"));
            g1.setLogin(result.getString("login"));
            g1.setSenha(result.getString("senha"));
            g1.setStatusDeUsuario(result.getString("statusDeUsuario"));
            g1.setIdAdministrador(result.getInt("id"));
            administradors.add(g1);
        }
        return administradors;
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
