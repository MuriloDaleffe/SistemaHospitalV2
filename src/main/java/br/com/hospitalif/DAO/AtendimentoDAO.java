package br.com.hospitalif.DAO;

import br.com.hospitalif.model.Atendimento;

import javax.persistence.EntityManager;

public class AtendimentoDAO extends GenericDAO2<Long, Atendimento> {

    public AtendimentoDAO(EntityManager em) {
        super(em, Atendimento.class);
    }

}
