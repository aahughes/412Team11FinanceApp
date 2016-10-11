/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Allison
 */
@Entity
@Table(name = "BUDGETS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Budgets.findAll", query = "SELECT b FROM Budgets b"),
    @NamedQuery(name = "Budgets.findByCategory", query = "SELECT b FROM Budgets b WHERE b.category = :category"),
    @NamedQuery(name = "Budgets.findByAmount", query = "SELECT b FROM Budgets b WHERE b.amount = :amount"),
    @NamedQuery(name = "Budgets.findByBalance", query = "SELECT b FROM Budgets b WHERE b.balance = :balance")})
public class Budgets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private String category;
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private double amount;
    @Basic(optional = false)
    @Column(name = "BALANCE")
    private double balance;
    @OneToMany(mappedBy = "categoryFk")
    private Collection<Transactions> transactionsCollection;

    public Budgets() {
    }

    public Budgets(String category) {
        this.category = category;
    }

    public Budgets(String category, double amount, double balance) {
        this.category = category;
        this.amount = amount;
        this.balance = balance;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (category != null ? category.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budgets)) {
            return false;
        }
        Budgets other = (Budgets) object;
        if ((this.category == null && other.category != null) || (this.category != null && !this.category.equals(other.category))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financeapp.Budgets[ category=" + category + " ]";
    }
    
}
