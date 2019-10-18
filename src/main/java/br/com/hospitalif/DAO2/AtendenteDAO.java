package br.com.hospitalif.DAO2;

import br.com.hospitalif.model.Atendente;

import javax.persistence.EntityManager;

public class AtendenteDAO extends GenericDAO<Long, Atendente> {

    public AtendenteDAO(EntityManager em) {
        super(em);
    }

}