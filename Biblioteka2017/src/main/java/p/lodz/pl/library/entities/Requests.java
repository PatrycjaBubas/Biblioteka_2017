/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Paweł Cała
 */
@Entity
@Table(name = "requests")
@NamedQueries({
    @NamedQuery(name = "Requests.findAll", query = "SELECT r FROM Requests r"),
    @NamedQuery(name = "Requests.findByIdRequests", query = "SELECT r FROM Requests r WHERE r.idRequests = :idRequests"),
    @NamedQuery(name = "Requests.findByIdUsers", query = "SELECT r FROM Requests r WHERE r.idUsers = :idUsers"),
    @NamedQuery(name = "Requests.findByIdBooks", query = "SELECT r FROM Requests r WHERE r.idBooks = :idBooks"),
    @NamedQuery(name = "Requests.findByBorrowDate", query = "SELECT r FROM Requests r WHERE r.borrowDate = :borrowDate"),
    @NamedQuery(name = "Requests.findByReturnDate", query = "SELECT r FROM Requests r WHERE r.returnDate = :returnDate"),
    @NamedQuery(name = "Requests.findByArchival", query = "SELECT r FROM Requests r WHERE r.archival = :archival")})
public class Requests implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRequests")
    private Integer idRequests;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsers")
    private int idUsers;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBooks")
    private int idBooks;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrowDate")
    @Temporal(TemporalType.DATE)
    private Date borrowDate;
    
    @Column(name = "returnDate")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "archival")
    private boolean archival;

    public Requests() {
    }

    public Requests(Integer idRequests) {
        this.idRequests = idRequests;
    }

    public Requests(Integer idRequests, int idUsers, int idBooks, Date borrowDate, boolean archival) {
        this.idRequests = idRequests;
        this.idUsers = idUsers;
        this.idBooks = idBooks;
        this.borrowDate = borrowDate;
        this.archival = archival;
    }

    public Integer getIdRequests() {
        return idRequests;
    }

    public void setIdRequests(Integer idRequests) {
        this.idRequests = idRequests;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public int getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(int idBooks) {
        this.idBooks = idBooks;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean getArchival() {
        return archival;
    }

    public void setArchival(boolean archival) {
        this.archival = archival;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequests != null ? idRequests.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requests)) {
            return false;
        }
        Requests other = (Requests) object;
        if ((this.idRequests == null && other.idRequests != null) || (this.idRequests != null && !this.idRequests.equals(other.idRequests))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "p.lodz.pl.library.entities.Requests[ idRequests=" + idRequests + " ]";
    }
    
}
