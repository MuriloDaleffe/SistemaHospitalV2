package br.com.hospitalif.DAO2;

import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements Serializable {

    private Session s;

    public LoginDAO() {
        s = HibernateUtil.getSession();
    }

    // LOGAR
    public Boolean buscaUsuario(String login, String senha) throws SQLException {

        // monta o comando
        Query q = s.createQuery("select id from Medico where login = '" + login
                + "' and senha = '" + senha + "'");
        // recebe o resultado da query
        ResultSet result = (ResultSet) q.uniqueResult();
        s.close(); // fecha a conexao
        return result.wasNull(); // retorna o resultado
    }

}