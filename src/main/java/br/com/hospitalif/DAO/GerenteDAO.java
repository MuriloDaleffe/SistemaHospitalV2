package br.com.hospitalif.DAO;

import br.com.hospitalif.model.Gerente;

import javax.persistence.EntityManager;

public class GerenteDAO extends GenericDAO2<Long, Gerente> {

    public GerenteDAO(EntityManager em) {
        super(em, Gerente.class);
    }

}
