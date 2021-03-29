/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.Entities.Calificaciongeneralproyecto;
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
public class CalificaciongeneralproyectoJpaController implements Serializable {

    public CalificaciongeneralproyectoJpaController(){
        
    }
    public CalificaciongeneralproyectoJpaController(UserTransaction utx, EntityManagerFactory emf) {
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

    public void create(Calificaciongeneralproyecto calificaciongeneralproyecto) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(calificaciongeneralproyecto);
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

    public void edit(Calificaciongeneralproyecto calificaciongeneralproyecto) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            calificaciongeneralproyecto = em.merge(calificaciongeneralproyecto);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = calificaciongeneralproyecto.getId();
                if (findCalificaciongeneralproyecto(id) == null) {
                    throw new NonexistentEntityException("The calificaciongeneralproyecto with id " + id + " no longer exists.");
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
            Calificaciongeneralproyecto calificaciongeneralproyecto;
            try {
                calificaciongeneralproyecto = em.getReference(Calificaciongeneralproyecto.class, id);
                calificaciongeneralproyecto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calificaciongeneralproyecto with id " + id + " no longer exists.", enfe);
            }
            em.remove(calificaciongeneralproyecto);
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

    public List<Calificaciongeneralproyecto> findCalificaciongeneralproyectoEntities() {
        return findCalificaciongeneralproyectoEntities(true, -1, -1);
    }

    public List<Calificaciongeneralproyecto> findCalificaciongeneralproyectoEntities(int maxResults, int firstResult) {
        return findCalificaciongeneralproyectoEntities(false, maxResults, firstResult);
    }

    private List<Calificaciongeneralproyecto> findCalificaciongeneralproyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calificaciongeneralproyecto.class));
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

    public Calificaciongeneralproyecto findCalificaciongeneralproyecto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calificaciongeneralproyecto.class, id);
        } finally {
            em.close();
            emf.close();
        }
    }

    public int getCalificaciongeneralproyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calificaciongeneralproyecto> rt = cq.from(Calificaciongeneralproyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
            emf.close();
        }
    }
    public int findLastId() {
    EntityManager em = getEntityManager();
        try {
           List id = em.createNamedQuery("Calificaciongeneralproyecto.findLastId").getResultList();           
           return Integer.parseInt(id.get(0).toString());         
        }   
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }                
        finally {
            em.close();
            emf.close();
        }
    }
    
    //buscamos las preguntas del proyecto para poder analizarlo
    public List<Calificaciongeneralproyecto> BuscarPreguntasPorUsuario(int id){
        EntityManager em = getEntityManager();
        try {
           //List<Preguntas> preguntas = (List<Preguntas>)em.createNamedQuery("Preguntas.findAll").getResultList(); 
           List<Calificaciongeneralproyecto> proyecto = (List<Calificaciongeneralproyecto>)em.createNamedQuery("Calificaciongeneralproyecto.findByIdUsuario").setParameter("idUsuario", id).getResultList(); 
           return proyecto;         
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
