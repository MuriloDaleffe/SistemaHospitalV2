package br.com.hospitalif.DAO;

import util.Rotas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {

    private EntityManager entityManager;

    public GenericDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Rotas.PERSISTENCEUNITNAME);
        this.entityManager = entityManagerFactory.createEntityManager();

    }

    public GenericDAO(EntityManager em){
        this.entityManager = em;
    }

    public T getById(PK pk){
        return (T) entityManager.find(getTypeClass(), pk);
    }

    public void save(T entity){
        entityManager.persist(entity);
    }

    public void delete(T entity){
        entityManager.remove(entity);
    }

    public List<T> findAll(String table){
        return entityManager.createQuery(("FROM " + table)).getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clas = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clas;
    }
}

//public abstract class GenericDao<T, I extends Serializable> {
//
//    @Inject
//    protected EntityManager entityManager;
//
//    private Class<T> persistedClass;
//
//    protected GenericDao() {
//    }
//
//    protected GenericDao(Class<T> persistedClass) {
//        this();
//        this.persistedClass = persistedClass;
//    }
//
//    public T salvar(@Valid T entity) {
//        EntityTransaction t = entityManager.getTransaction();
//        t.begin();
//        entityManager.persist(entity);
//        entityManager.flush();
//        t.commit();
//        return entity;
//    }
//
//    public T atualizar(@Valid T entity) {
//        EntityTransaction t = entityManager.getTransaction();
//        t.begin();
//        entityManager.merge(entity);
//        entityManager.flush();
//        t.commit();
//        return entity;
//    }
//
//    public void remover(I id) {
//        T entity = encontrar(id);
//        EntityTransaction tx = entityManager.getTransaction();
//        tx.begin();
//        T mergedEntity = entityManager.merge(entity);
//        entityManager.remove(mergedEntity);
//        entityManager.flush();
//        tx.commit();
//    }
//
//    public List<T> getList() {
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<T> query = builder.createQuery(persistedClass);
//        query.from(persistedClass);
//        return entityManager.createQuery(query).getResultList();
//    }
//
//    public T encontrar(I id) {
//        return entityManager.find(persistedClass, id);
//    }
//}
