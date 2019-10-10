package br.com.hospitalif.DAO;

import br.com.hospitalif.connectivity.ConnectionClass;
import javafx.scene.control.Alert;
import util.Rotas;
import application.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public static void login(String login, String senha) throws Exception {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select login,senha from Medico where login like (?) and senha like (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, login);
        stmt.setString(2, senha);
        ResultSet result = stmt.executeQuery();

        if(result != null && result.next()){
            msgInfo(1);
            Main.openPage(Rotas.SISTEMA);
        }else{
            msgInfo(0);
        }

    }

    public static void msgInfo(int num){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        if(num==1){
            msg.setContentText("Logado com sucesso!");
            msg.setHeaderText("Login");
            msg.show();
        }else{
            msg.setContentText("Falha ao logar! Usuário não cadastrado no banco de dados!");
            msg.setHeaderText("Login");
            msg.show();
        }
    }

}
