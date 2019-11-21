package br.com.hospitalif.DAO;

import br.com.hospitalif.model.EnfermidadePessoal;

import javax.persistence.EntityManager;

public class EnfermidadePessoalDAO extends GenericDAO2<Long, EnfermidadePessoal> {

    public EnfermidadePessoalDAO(EntityManager em) {
        super(em, EnfermidadePessoal.class);
    }

}