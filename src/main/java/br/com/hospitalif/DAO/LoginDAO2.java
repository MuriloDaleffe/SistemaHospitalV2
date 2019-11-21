package br.com.hospitalif.DAO;

import br.com.hospitalif.model.Funcionario;
import util.Rotas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class LoginDAO2 implements Serializable {

    protected EntityManager em;
    protected EntityManagerFactory emf;

    public LoginDAO2() {
        this.emf = Persistence.createEntityManagerFactory(Rotas.PERSISTENCEUNITNAME);
        this.em = emf.createEntityManager();

    }

    // LOGAR
    public Boolean buscaUsuario(String login, String senha) throws SQLException {
        List<Funcionario> logonList;
        em.getTransaction().begin();

        Query sql = em.createQuery("SELECT login, senha FROM Funcionario where login=:login and senha=:senha");
        sql.setParameter("login", login);
        sql.setParameter("senha", senha);
        logonList = sql.getResultList();
        if(logonList.size()>0){
            em.close();
            return logonList.size()>0;
        }

        return false;

    }

}