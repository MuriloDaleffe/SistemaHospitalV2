package br.com.hospitalif.DAO;

import br.com.hospitalif.model.Entrada;

import javax.persistence.EntityManager;

public class EntradaDAO extends GenericDAO2<Long, Entrada> {

    public EntradaDAO(EntityManager em) {
        super(em, Entrada.class);
    }

}