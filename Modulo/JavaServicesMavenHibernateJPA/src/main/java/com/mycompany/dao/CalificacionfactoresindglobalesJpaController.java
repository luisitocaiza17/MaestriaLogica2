/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.Entities.Calificacionfactoresindglobales;
import com.mycompany.dao.exceptions.NonexistentEntityException;
import com.mycompany.dao.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author pc030
 */
public class CalificacionfactoresindglobalesJpaController implements Serializable {

    public CalificacionfactoresindglobalesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    
    public CalificacionfactoresindglobalesJpaController() {
       
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

   
    public EntityManager getEntityManager() {
          emf =Persistence.createEntityManagerFactory("mavendbConnection");
        EntityManager em= emf.createEntityManager();
        return em;
    }

    public void create(Calificacionfactoresindglobales calificacionfactoresindglobales) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(calificacionfactoresindglobales);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
                emf.close();
            }
        }
    }

    public void edit(Calificacionfactoresindglobales calificacionfactoresindglobales) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            calificacionfactoresindglobales = em.merge(calificacionfactoresindglobales);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = calificacionfactoresindglobales.getId();
                if (findCalificacionfactoresindglobales(id) == null) {
                    throw new NonexistentEntityException("The calificacionfactoresindglobales with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Calificacionfactoresindglobales calificacionfactoresindglobales;
            try {
                calificacionfactoresindglobales = em.getReference(Calificacionfactoresindglobales.class, id);
                calificacionfactoresindglobales.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calificacionfactoresindglobales with id " + id + " no longer exists.", enfe);
            }
            em.remove(calificacionfactoresindglobales);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calificacionfactoresindglobales> findCalificacionfactoresindglobalesEntities() {
        return findCalificacionfactoresindglobalesEntities(true, -1, -1);
    }

    public List<Calificacionfactoresindglobales> findCalificacionfactoresindglobalesEntities(int maxResults, int firstResult) {
        return findCalificacionfactoresindglobalesEntities(false, maxResults, firstResult);
    }

    private List<Calificacionfactoresindglobales> findCalificacionfactoresindglobalesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calificacionfactoresindglobales.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Calificacionfactoresindglobales findCalificacionfactoresindglobales(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calificacionfactoresindglobales.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalificacionfactoresindglobalesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calificacionfactoresindglobales> rt = cq.from(Calificacionfactoresindglobales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
