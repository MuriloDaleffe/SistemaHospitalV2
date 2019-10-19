package br.com.hospitalif.DAO2;

import br.com.hospitalif.model.Medico;

import javax.persistence.EntityManager;

public class MedicoDAO2 extends GenericDAO2<Long, Medico> {
    public MedicoDAO2(EntityManager em){
            super(em, Medico.class);
    }

}
