package br.com.hospitalif.DAO;

import br.com.hospitalif.model.Atendente;

import javax.persistence.EntityManager;

public class AtendenteDAO extends GenericDAO2<Long, Atendente> {

    public AtendenteDAO(EntityManager em) {
        super(em, Atendente.class);
    }

}