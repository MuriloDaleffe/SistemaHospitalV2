package br.com.hospitalif.DAO;

import br.com.hospitalif.model.Medico;

import javax.persistence.EntityManager;

public class MedicoDAO extends GenericDAO2<Long, Medico> {
    public MedicoDAO(EntityManager em){
            super(em, Medico.class);
    }

}
