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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lopez
 */
@Entity
@Table(name = "requests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requests.findAll", query = "SELECT r FROM Requests r"),
    @NamedQuery(name = "Requests.findByIdRequests", query = "SELECT r FROM Requests r WHERE r.idRequests = :idRequests"),
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
    
    @JoinColumn(name = "idBooks", referencedColumnName = "idBooks")
    @ManyToOne(optional = false)
    private Books idBooks;
    
    @JoinColumn(name = "idUsers", referencedColumnName = "idUsers")
    @ManyToOne(optional = false)
    private Users idUsers;

    public Requests() {
    }

    public Requests(Integer idRequests) {
        this.idRequests = idRequests;
    }

    public Requests(Integer idRequests, Date borrowDate, boolean archival) {
        this.idRequests = idRequests;
        this.borrowDate = borrowDate;
        this.archival = archival;
    }

    public Integer getIdRequests() {
        return idRequests;
    }

    public void setIdRequests(Integer idRequests) {
        this.idRequests = idRequests;
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

    public Books getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(Books idBooks) {
        this.idBooks = idBooks;
    }

    public Users getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Users idUsers) {
        this.idUsers = idUsers;
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
