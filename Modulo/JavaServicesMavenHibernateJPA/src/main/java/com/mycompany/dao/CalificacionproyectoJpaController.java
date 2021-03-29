/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.Entities.Calificacionfactor;
import com.mycompany.Entities.Calificacionproyecto;
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
public class CalificacionproyectoJpaController implements Serializable {

    public CalificacionproyectoJpaController(){}
    public CalificacionproyectoJpaController(UserTransaction utx, EntityManagerFactory emf) {
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

    public void create(Calificacionproyecto Calificacionproyecto) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(Calificacionproyecto);
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

    public void edit(Calificacionproyecto calificacionproyecto) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            calificacionproyecto = em.merge(calificacionproyecto);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = calificacionproyecto.getId();
                if (findCalificacionproyecto(id) == null) {
                    throw new NonexistentEntityException("The calificacionproyecto with id " + id + " no longer exists.");
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
            Calificacionproyecto calificacionproyecto;
            try {
                calificacionproyecto = em.getReference(Calificacionproyecto.class, id);
                calificacionproyecto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calificacionproyecto with id " + id + " no longer exists.", enfe);
            }
            em.remove(calificacionproyecto);
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

    public List<Calificacionproyecto> findCalificacionproyectoEntities() {
        return findCalificacionproyectoEntities(true, -1, -1);
    }

    public List<Calificacionproyecto> findCalificacionproyectoEntities(int maxResults, int firstResult) {
        return findCalificacionproyectoEntities(false, maxResults, firstResult);
    }

    private List<Calificacionproyecto> findCalificacionproyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calificacionproyecto.class));
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

    public Calificacionproyecto findCalificacionproyecto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calificacionproyecto.class, id);
        } finally {
            em.close();
            emf.close();
        }
    }

    public int getCalificacionproyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calificacionproyecto> rt = cq.from(Calificacionproyecto.class);
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
           List id = em.createNamedQuery("Calificacionproyecto.findLastId").getResultList();           
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
    
    //buscar las calificaciones del proyecto
    public List<Calificacionproyecto> buscarCalificacionFactorProyecto(int idUsuario) {
    EntityManager em = getEntityManager();
        try {
           List<Calificacionproyecto> listado = (List<Calificacionproyecto>)em.createNamedQuery("Calificacionproyecto.findCalificacionProyecto").setParameter("idUsuario", idUsuario).getResultList();           
           return listado;         
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
