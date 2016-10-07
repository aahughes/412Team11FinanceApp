/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import financeapp.exceptions.NonexistentEntityException;
import financeapp.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Allison
 */
public class TransactionsJpaController implements Serializable {

    public TransactionsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Transactions transactions) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Budgets categoryFk = transactions.getCategoryFk();
            if (categoryFk != null) {
                categoryFk = em.getReference(categoryFk.getClass(), categoryFk.getCategory());
                transactions.setCategoryFk(categoryFk);
            }
            em.persist(transactions);
            if (categoryFk != null) {
                categoryFk.getTransactionsCollection().add(transactions);
                categoryFk = em.merge(categoryFk);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTransactions(transactions.getId()) != null) {
                throw new PreexistingEntityException("Transactions " + transactions + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transactions transactions) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transactions persistentTransactions = em.find(Transactions.class, transactions.getId());
            Budgets categoryFkOld = persistentTransactions.getCategoryFk();
            Budgets categoryFkNew = transactions.getCategoryFk();
            if (categoryFkNew != null) {
                categoryFkNew = em.getReference(categoryFkNew.getClass(), categoryFkNew.getCategory());
                transactions.setCategoryFk(categoryFkNew);
            }
            transactions = em.merge(transactions);
            if (categoryFkOld != null && !categoryFkOld.equals(categoryFkNew)) {
                categoryFkOld.getTransactionsCollection().remove(transactions);
                categoryFkOld = em.merge(categoryFkOld);
            }
            if (categoryFkNew != null && !categoryFkNew.equals(categoryFkOld)) {
                categoryFkNew.getTransactionsCollection().add(transactions);
                categoryFkNew = em.merge(categoryFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transactions.getId();
                if (findTransactions(id) == null) {
                    throw new NonexistentEntityException("The transactions with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transactions transactions;
            try {
                transactions = em.getReference(Transactions.class, id);
                transactions.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transactions with id " + id + " no longer exists.", enfe);
            }
            Budgets categoryFk = transactions.getCategoryFk();
            if (categoryFk != null) {
                categoryFk.getTransactionsCollection().remove(transactions);
                categoryFk = em.merge(categoryFk);
            }
            em.remove(transactions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transactions> findTransactionsEntities() {
        return findTransactionsEntities(true, -1, -1);
    }

    public List<Transactions> findTransactionsEntities(int maxResults, int firstResult) {
        return findTransactionsEntities(false, maxResults, firstResult);
    }

    private List<Transactions> findTransactionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transactions.class));
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

    public Transactions findTransactions(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transactions.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransactionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transactions> rt = cq.from(Transactions.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
