/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import financeapp.exceptions.NonexistentEntityException;
import financeapp.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Allison
 */
public class BudgetsJpaController implements Serializable {

    public BudgetsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Budgets budgets) throws PreexistingEntityException, Exception {
        if (budgets.getTransactionsCollection() == null) {
            budgets.setTransactionsCollection(new ArrayList<Transactions>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Transactions> attachedTransactionsCollection = new ArrayList<Transactions>();
            for (Transactions transactionsCollectionTransactionsToAttach : budgets.getTransactionsCollection()) {
                transactionsCollectionTransactionsToAttach = em.getReference(transactionsCollectionTransactionsToAttach.getClass(), transactionsCollectionTransactionsToAttach.getId());
                attachedTransactionsCollection.add(transactionsCollectionTransactionsToAttach);
            }
            budgets.setTransactionsCollection(attachedTransactionsCollection);
            em.persist(budgets);
            for (Transactions transactionsCollectionTransactions : budgets.getTransactionsCollection()) {
                Budgets oldCategoryFkOfTransactionsCollectionTransactions = transactionsCollectionTransactions.getCategoryFk();
                transactionsCollectionTransactions.setCategoryFk(budgets);
                transactionsCollectionTransactions = em.merge(transactionsCollectionTransactions);
                if (oldCategoryFkOfTransactionsCollectionTransactions != null) {
                    oldCategoryFkOfTransactionsCollectionTransactions.getTransactionsCollection().remove(transactionsCollectionTransactions);
                    oldCategoryFkOfTransactionsCollectionTransactions = em.merge(oldCategoryFkOfTransactionsCollectionTransactions);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBudgets(budgets.getCategory()) != null) {
                throw new PreexistingEntityException("Budgets " + budgets + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Budgets budgets) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Budgets persistentBudgets = em.find(Budgets.class, budgets.getCategory());
            Collection<Transactions> transactionsCollectionOld = persistentBudgets.getTransactionsCollection();
            Collection<Transactions> transactionsCollectionNew = budgets.getTransactionsCollection();
            Collection<Transactions> attachedTransactionsCollectionNew = new ArrayList<Transactions>();
            for (Transactions transactionsCollectionNewTransactionsToAttach : transactionsCollectionNew) {
                transactionsCollectionNewTransactionsToAttach = em.getReference(transactionsCollectionNewTransactionsToAttach.getClass(), transactionsCollectionNewTransactionsToAttach.getId());
                attachedTransactionsCollectionNew.add(transactionsCollectionNewTransactionsToAttach);
            }
            transactionsCollectionNew = attachedTransactionsCollectionNew;
            budgets.setTransactionsCollection(transactionsCollectionNew);
            budgets = em.merge(budgets);
            for (Transactions transactionsCollectionOldTransactions : transactionsCollectionOld) {
                if (!transactionsCollectionNew.contains(transactionsCollectionOldTransactions)) {
                    transactionsCollectionOldTransactions.setCategoryFk(null);
                    transactionsCollectionOldTransactions = em.merge(transactionsCollectionOldTransactions);
                }
            }
            for (Transactions transactionsCollectionNewTransactions : transactionsCollectionNew) {
                if (!transactionsCollectionOld.contains(transactionsCollectionNewTransactions)) {
                    Budgets oldCategoryFkOfTransactionsCollectionNewTransactions = transactionsCollectionNewTransactions.getCategoryFk();
                    transactionsCollectionNewTransactions.setCategoryFk(budgets);
                    transactionsCollectionNewTransactions = em.merge(transactionsCollectionNewTransactions);
                    if (oldCategoryFkOfTransactionsCollectionNewTransactions != null && !oldCategoryFkOfTransactionsCollectionNewTransactions.equals(budgets)) {
                        oldCategoryFkOfTransactionsCollectionNewTransactions.getTransactionsCollection().remove(transactionsCollectionNewTransactions);
                        oldCategoryFkOfTransactionsCollectionNewTransactions = em.merge(oldCategoryFkOfTransactionsCollectionNewTransactions);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = budgets.getCategory();
                if (findBudgets(id) == null) {
                    throw new NonexistentEntityException("The budgets with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Budgets budgets;
            try {
                budgets = em.getReference(Budgets.class, id);
                budgets.getCategory();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The budgets with id " + id + " no longer exists.", enfe);
            }
            Collection<Transactions> transactionsCollection = budgets.getTransactionsCollection();
            for (Transactions transactionsCollectionTransactions : transactionsCollection) {
                transactionsCollectionTransactions.setCategoryFk(null);
                transactionsCollectionTransactions = em.merge(transactionsCollectionTransactions);
            }
            em.remove(budgets);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Budgets> findBudgetsEntities() {
        return findBudgetsEntities(true, -1, -1);
    }

    public List<Budgets> findBudgetsEntities(int maxResults, int firstResult) {
        return findBudgetsEntities(false, maxResults, firstResult);
    }

    private List<Budgets> findBudgetsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Budgets.class));
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

    public Budgets findBudgets(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Budgets.class, id);
        } finally {
            em.close();
        }
    }

    public int getBudgetsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Budgets> rt = cq.from(Budgets.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
