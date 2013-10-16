package webstore.utils;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import webstore.core.Product;

/**
 *
 * @author Andrea
 */
public class navigator extends AbstractDAO<T, K> {
    
     private int first;  // Fist item in table
     private int nItems = getCount(); // Number of items in Database
     private int count = 0;
     protected final transient EntityManagerFactory emf;
    // private final Class<T> clazz;
    
    
     public navigator(int first, int nItems, String puName) {
         
        this.first = count;
        this.nItems = nItems; 
        emf = Persistence.createEntityManagerFactory(puName);
     }
   
    public List<T> next() {
        EntityManager em = emf.createEntityManager();
        List<T> products = new ArrayList<>();
         try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
            Query q = em.createQuery(cq);
            if (count != nItems) {
                int min = 4*count;
                int max = 4*count + 4;
                if (max < nItems) {
                q.setMaxResults(min);
                q.setFirstResult(max);
                count = count+1;
                }
            }
            products.addAll(q.getResultList());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return products;
    }
    
    public List<T> prev() {
        EntityManager em = emf.createEntityManager();
        List<T> products = new ArrayList<>();
         try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
            Query q = em.createQuery(cq);
            if (count != nItems) {
                int min = count*4;
                int max = count*4 + 4;
                if (max < nItems) {
                q.setMaxResults(min);
                q.setFirstResult(max);
                 count = count-1;
                }
            }
            products.addAll(q.getResultList());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return products;
    }

    public int getCount() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
            Query q = em.createQuery(cq);
            List l = q.getResultList();
            return l.size();
    }
    
    
    
    
}



/*
   next: function(success, fail) {
            // Must save this, will change inside $.when()
            var me = this;
            me.container.getCount().then(function(result) {
                // Move fst pointer
                me.fst = (me.fst + me.max < result.value) ? me.fst + me.max : me.fst;
                // How many items for last listing?
                var m = (me.fst + me.max > result.value) ? result.value - me.fst : me.max;
                return m;
            }, fail).then(function(m) {
                me.container.getRange(me.fst, m).then(success, fail);
            });
        },
        prev: function(success, fail) {
            var me = this;
            me.fst = (me.fst - me.max > 0) ? me.fst - me.max : 0;
            me.container.getCount().then(function(result) {
                var m = (me.fst + me.max > result.value) ? result.value - me.fst : me.max;
                return m;
            }, fail).then(function(m) {
                me.container.getRange(me.fst, m).then(success, fail);
            });
 * 
 * 
 * 
 * 
 * 
 * 
 */

