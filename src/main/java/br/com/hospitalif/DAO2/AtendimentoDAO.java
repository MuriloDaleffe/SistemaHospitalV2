package br.com.hospitalif.DAO2;

import br.com.hospitalif.model.Atendimento;

import javax.persistence.EntityManager;

public class AtendimentoDAO extends GenericDAO<Long, Atendimento> {

    public AtendimentoDAO(EntityManager em) {
        super(em);
    }

}
