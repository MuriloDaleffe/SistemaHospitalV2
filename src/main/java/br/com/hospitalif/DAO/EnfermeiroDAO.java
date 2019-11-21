package br.com.hospitalif.DAO;

import br.com.hospitalif.model.Enfermeiro;

import javax.persistence.EntityManager;

public class EnfermeiroDAO extends GenericDAO2<Long, Enfermeiro> {

    public EnfermeiroDAO(EntityManager em) {
        super(em, Enfermeiro.class);
    }

}
