package br.com.hospitalif.DAO2;

import br.com.hospitalif.model.Paciente;

import javax.persistence.EntityManager;

public class PacienteDAO extends GenericDAO<Long, Paciente> {

    public PacienteDAO(EntityManager em) {
        super(em);
    }

}
