/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.Entities.Configuracionrecomendacion;
import com.mycompany.dao.exceptions.NonexistentEntityException;
import com.mycompany.dao.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author pc030
 */
public class ConfiguracionrecomendacionJpaController implements Serializable {

    public ConfiguracionrecomendacionJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Configuracionrecomendacion configuracionrecomendacion) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(configuracionrecomendacion);
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
                emf.close();
            }
        }
    }

    public void edit(Configuracionrecomendacion configuracionrecomendacion) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            configuracionrecomendacion = em.merge(configuracionrecomendacion);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = configuracionrecomendacion.getId();
                if (findConfiguracionrecomendacion(id) == null) {
                    throw new NonexistentEntityException("The configuracionrecomendacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
                emf.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Configuracionrecomendacion configuracionrecomendacion;
            try {
                configuracionrecomendacion = em.getReference(Configuracionrecomendacion.class, id);
                configuracionrecomendacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The configuracionrecomendacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(configuracionrecomendacion);
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
                emf.close();
            }
        }
    }

    public List<Configuracionrecomendacion> findConfiguracionrecomendacionEntities() {
        return findConfiguracionrecomendacionEntities(true, -1, -1);
    }

    public List<Configuracionrecomendacion> findConfiguracionrecomendacionEntities(int maxResults, int firstResult) {
        return findConfiguracionrecomendacionEntities(false, maxResults, firstResult);
    }

    private List<Configuracionrecomendacion> findConfiguracionrecomendacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Configuracionrecomendacion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public Configuracionrecomendacion findConfiguracionrecomendacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Configuracionrecomendacion.class, id);
        } finally {
            em.close();
            emf.close();
        }
    }

    public int getConfiguracionrecomendacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Configuracionrecomendacion> rt = cq.from(Configuracionrecomendacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
            emf.close();
        }
    }
    
}
