package br.com.hospitalif.DAO;

import util.Rotas;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAO2<I extends Serializable, T> {

    @Inject
    protected EntityManager entityManager;
    protected EntityManagerFactory entityManagerFactory;

    private Class<T> persistedClass;

    public GenericDAO2(){
        entityManagerFactory = Persistence.createEntityManagerFactory(Rotas.PERSISTENCEUNITNAME);
        this.entityManager = entityManagerFactory.createEntityManager();

    }

    protected GenericDAO2(EntityManager em) {
        this.entityManager = em;
    }

    protected GenericDAO2(EntityManager em ,Class<T> persistedClass) {
        this();
        this.entityManager = em;
        this.persistedClass = persistedClass;
    }

    public void salvar(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void atualizar(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remover(I id) {
        try {
            T entity = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public List<T> getList() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return entityManager.createQuery(query).getResultList();
    }

    public T getById(I id) {
        return (T) entityManager.find(getTypeClass(), id);

    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
