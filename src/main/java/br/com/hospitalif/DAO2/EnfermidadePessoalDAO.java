package br.com.hospitalif.DAO2;

import br.com.hospitalif.model.EnfermidadePessoal;

import javax.persistence.EntityManager;

public class EnfermidadePessoalDAO extends GenericDAO<Long, EnfermidadePessoal> {

    public EnfermidadePessoalDAO(EntityManager em) {
        super(em);
    }

}