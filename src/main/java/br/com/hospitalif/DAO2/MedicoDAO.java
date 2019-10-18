package br.com.hospitalif.DAO2;

import br.com.hospitalif.model.Medico;
import javax.persistence.EntityManager;

public class MedicoDAO extends GenericDAO<Long, Medico> {

    public MedicoDAO(EntityManager em) {
        super(em);
    }

}
