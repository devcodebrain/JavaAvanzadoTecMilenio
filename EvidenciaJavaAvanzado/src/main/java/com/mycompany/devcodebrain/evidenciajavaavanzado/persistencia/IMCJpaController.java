/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.devcodebrain.evidenciajavaavanzado.persistencia;

import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.IMC;
import com.mycompany.devcodebrain.evidenciajavaavanzado.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author JuanAntonioFloresZah
 */
public class IMCJpaController implements Serializable {

    public IMCJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     public IMCJpaController() {
        emf = Persistence.createEntityManagerFactory("Evidencia3PAPU");
    }

    public void create(IMC IMC) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(IMC);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IMC IMC) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IMC = em.merge(IMC);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = IMC.getId();
                if (findIMC(id) == null) {
                    throw new NonexistentEntityException("The iMC with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IMC IMC;
            try {
                IMC = em.getReference(IMC.class, id);
                IMC.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The IMC with id " + id + " no longer exists.", enfe);
            }
            em.remove(IMC);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IMC> findIMCEntities() {
        return findIMCEntities(true, -1, -1);
    }

    public List<IMC> findIMCEntities(int maxResults, int firstResult) {
        return findIMCEntities(false, maxResults, firstResult);
    }

    private List<IMC> findIMCEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IMC.class));
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

    public IMC findIMC(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IMC.class, id);
        } finally {
            em.close();
        }
    }

    public int getIMCCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IMC> rt = cq.from(IMC.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
