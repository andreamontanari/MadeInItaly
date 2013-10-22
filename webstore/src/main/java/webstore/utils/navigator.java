/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class navigator {
    
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
     
     public Product next() {
         List<Product> show = getAll(true, 0, getCount());
         Product[] ciao = (Product[]) show.toArray();
         if (count != nItems) {
             for (int i=4*count; i<4*count+4; i++) {
                 return ciao[i];
             }
             count++;
         }
         return null;
     }
     
        public Product prev() {
         List<Product> show = getAll(true, 0, getCount());
         Product[] ciao = (Product[]) show.toArray();
         if (count != nItems) {
             for (int i=4*count; i<4*count+4; i++) {
                 return ciao[i];
             }
             count--;
         }
         return null;
     }
     
     

    /* OLD TRY    
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
    */

    public int getCount() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
            Query q = em.createQuery(cq);
            List l = q.getResultList();
            return l.size();
    }
    
    
    public List<Product> getAll(boolean all, int start, int count) {
        EntityManager em = emf.createEntityManager();
        List<Product> products = new ArrayList<>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(count);
                q.setFirstResult(start);
            }
            products.addAll(q.getResultList());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return products;
    }
    
    
    
    
}


