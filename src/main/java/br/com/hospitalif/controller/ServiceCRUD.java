package br.com.hospitalif.controller;

import java.util.List;

public interface ServiceCRUD<pk, T> {

    public void salvar(T entity);

    public List<T> findAll();

    public T buscaPorId(long id);

    public void apagar(int id);

    public void atualizar(T entity);

}
