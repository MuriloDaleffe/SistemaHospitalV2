package br.com.hospitalif.DAO2;

import br.com.hospitalif.model.Enfermeiro;

import javax.persistence.EntityManager;

public class EnfermeiroDAO extends GenericDAO<Long, Enfermeiro> {

    public EnfermeiroDAO(EntityManager em) {
        super(em);
    }

}
