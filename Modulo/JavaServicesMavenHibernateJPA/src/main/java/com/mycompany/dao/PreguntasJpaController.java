/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.Entities.Preguntas;
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
public class PreguntasJpaController implements Serializable {

    public PreguntasJpaController() {
       
    }
    public PreguntasJpaController(UserTransaction utx, EntityManagerFactory emf) {
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

    public void create(Preguntas preguntas) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(preguntas);
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

    public void edit(Preguntas preguntas) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            preguntas = em.merge(preguntas);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = preguntas.getId();
                if (findPreguntas(id) == null) {
                    throw new NonexistentEntityException("The preguntas with id " + id + " no longer exists.");
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
            Preguntas preguntas;
            try {
                preguntas = em.getReference(Preguntas.class, id);
                preguntas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The preguntas with id " + id + " no longer exists.", enfe);
            }
            em.remove(preguntas);
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

    public List<Preguntas> findPreguntasEntities() {
        return findPreguntasEntities(true, -1, -1);
    }

    //busco el id del cual voya ingresar en el nuevo registro
    public List<Preguntas> BuscarPreguntasTodas(){
        EntityManager em = getEntityManager();
        try {
           //List<Preguntas> preguntas = (List<Preguntas>)em.createNamedQuery("Preguntas.findAll").getResultList(); 
           List<Preguntas> preguntas = (List<Preguntas>)em.createNamedQuery("Preguntas.findAll").getResultList(); 
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
    
    public List<Preguntas> findPreguntasEntities(int maxResults, int firstResult) {
        return findPreguntasEntities(false, maxResults, firstResult);
    }

    private List<Preguntas> findPreguntasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Preguntas.class));
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

    public Preguntas findPreguntas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Preguntas.class, id);
        } finally {
            em.close();
            emf.close();
        }
    }

    public int getPreguntasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Preguntas> rt = cq.from(Preguntas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
            emf.close();
        }
    }
    
}
