package br.com.hospitalif.DAO2;

import br.com.hospitalif.model.Administrador;

import javax.persistence.EntityManager;

public class AdministradorDAO extends GenericDAO<Long, Administrador> {

    public AdministradorDAO(EntityManager em) {
        super(em);
    }

}