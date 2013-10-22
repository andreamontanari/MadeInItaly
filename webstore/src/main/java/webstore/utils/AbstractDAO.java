package webstore.utils;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * 
 * CRUD operations, abstract class 
 *
 * T is type for items in container K is type of id (primary key)
 *
 * @author hajo rewritten by Jonas Ha
 */
public abstract class AbstractDAO<T, K>
        implements IDAO<T, K> {

    protected final transient EntityManagerFactory emf;
    private final Class<T> clazz; 

    protected AbstractDAO(Class<T> clazz, String puName) {
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }

    @Override
    public void add(T t) {
        EntityManager em = null;
        try {
            // Create ...
            em = emf.createEntityManager();
            // Must handle transaction, this is application managed 
            // transaction (RESOURCE_LOCAL)
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (em != null) {
                em.close();  
            }
        }
    }

    @Override
    public void remove(K id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            T t = em.getReference(clazz, id);
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T update(T t) {
        EntityManager em = null;
        T up = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            up = em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return up;
    }

   @Override
    public T find(K id) {
        EntityManager em = emf.createEntityManager();
        T t = em.find(clazz, id);
        return t;
    }

    @Override
    public List<T> getRange(int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        List<T> found = new ArrayList<>();
        
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);

            q.setMaxResults(nItems);
            q.setFirstResult(first);

            found.addAll(q.getResultList());
        } catch (Exception ex) {
        } finally {
            em.close();
        }
        return found;
    }

    @Override
    public int getCount() {
          EntityManager em = emf.createEntityManager();
        int count = 0;
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(clazz);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            count = ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return count;
    }
 
    @Override
    public List<T> getAll() {
        EntityManager em = emf.createEntityManager();
        List<T> found = new ArrayList<>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);
            found.addAll(q.getResultList());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return found;
    }
}
