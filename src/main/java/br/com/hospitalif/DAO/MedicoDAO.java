package br.com.hospitalif.DAO;

import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.model.Medico;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static void removeByID(int id) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "delete from Medico where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        stmt.execute();
    }

    public static void edit(Medico m) throws SQLException {

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

    public static Medico searchByID(int id) throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from Medico where id = ?";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        if(result != null && result.next()){
            Medico medico = new Medico();
            medico.setNome(result.getString("nome"));
            medico.setCpf(result.getString("cpf"));
            medico.setIdade(result.getInt("idade"));
            medico.setTipoSanguineo(result.getString("tipoSanguineo"));
            medico.setSexo(result.getString("sexo"));
            medico.setStatusDePessoa(result.getString("statusDePessoa"));
            medico.setLogin(result.getString("login"));
            medico.setSenha(result.getString("senha"));
            medico.setStatusDeUsuario(result.getString("statusDeUsuario"));
            medico.setNumeroRegistro(result.getString("numeroRegistro"));
            medico.setEspecialidade(result.getString("especialidade"));
            msgInfo(1);
            return medico;
        }else{
            msgInfo(0);
        }

        return null;

    }

    public static List<Medico> selectAll() throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from Medico";
        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        ResultSet result = stmt.executeQuery();

        List<Medico> medicos = new ArrayList<Medico>();

        while(result.next()) {
            Medico m1 = new Medico();
            m1.setNome(result.getString("nome"));
            m1.setCpf(result.getString("cpf"));
            m1.setIdade(result.getInt("idade"));
            m1.setTipoSanguineo(result.getString("tipoSanguineo"));
            m1.setSexo(result.getString("sexo"));
            m1.setStatusDePessoa(result.getString("statusDePessoa"));
            m1.setLogin(result.getString("login"));
            m1.setSenha(result.getString("senha"));
            m1.setStatusDeUsuario(result.getString("statusDeUsuario"));
            m1.setNumeroRegistro(result.getString("numeroRegistro"));
            m1.setEspecialidade(result.getString("especialidade"));
            m1.setIdMedico(result.getInt("id"));
            medicos.add(m1);
        }
        return medicos;
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
