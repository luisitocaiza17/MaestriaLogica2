/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.Entities.Factores;
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
public class FactoresJpaController implements Serializable {

     public FactoresJpaController(){
         
     }
    
    public FactoresJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        emf =Persistence.createEntityManagerFactory("mavendbConnection");
        EntityManager em= emf.createEntityManager();
        return em;
    }

    public void create(Factores factores) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(factores);
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

    public void edit(Factores factores) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            factores = em.merge(factores);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factores.getId();
                if (findFactores(id) == null) {
                    throw new NonexistentEntityException("The factores with id " + id + " no longer exists.");
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
            Factores factores;
            try {
                factores = em.getReference(Factores.class, id);
                factores.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factores with id " + id + " no longer exists.", enfe);
            }
            em.remove(factores);
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

    public List<Factores> findFactoresEntities() {
        return findFactoresEntities(true, -1, -1);
    }

    public List<Factores> findFactoresEntities(int maxResults, int firstResult) {
        return findFactoresEntities(false, maxResults, firstResult);
    }

    private List<Factores> findFactoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factores.class));
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

    public Factores findFactores(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factores.class, id);
        } finally {
            em.close();
            emf.close();
        }
    }

    public int getFactoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factores> rt = cq.from(Factores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
            emf.close();
        }
    }
    
    
    //busco el id del cual voya ingresar en el nuevo registro
    public List<Factores> BuscarFactoresTodos(){
        EntityManager em = getEntityManager();
        try {
           //List<Preguntas> preguntas = (List<Preguntas>)em.createNamedQuery("Preguntas.findAll").getResultList(); 
           List<Factores> preguntas = (List<Factores>)em.createNamedQuery("Factores.findAll").getResultList(); 
           return preguntas;         
        }   
        catch(Exception e){
            e.printStackTrace();
            return null;
        }                
        finally {
            em.close();
            emf.close();
        }
    }
}
