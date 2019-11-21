package br.com.hospitalif.DAO;

import br.com.hospitalif.model.Administrador;

import javax.persistence.EntityManager;

public class AdministradorDAO extends GenericDAO2<Long, Administrador> {

    public AdministradorDAO(EntityManager em) {
        super(em, Administrador.class);
    }

}