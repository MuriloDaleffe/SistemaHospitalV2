package br.com.hospitalif.DAO;

import br.com.hospitalif.model.Paciente;

import javax.persistence.EntityManager;

public class PacienteDAO extends GenericDAO2<Long, Paciente> {

    public PacienteDAO(EntityManager em) {
        super(em, Paciente.class);
    }

}
