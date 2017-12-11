/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lopez
 */
@Entity
@Table(name = "books")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findByIdBooks", query = "SELECT b FROM Books b WHERE b.idBooks = :idBooks"),
    @NamedQuery(name = "Books.findByTitle", query = "SELECT b FROM Books b WHERE b.title = :title"),
    @NamedQuery(name = "Books.findByIsbn", query = "SELECT b FROM Books b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Books.findByDate", query = "SELECT b FROM Books b WHERE b.date = :date")})
public class Books implements Serializable {
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBooks")
    private Integer idBooks;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "isbn")
    private String isbn;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_borrowed")
    private boolean isBorrowed;
    
    @JoinColumn(name = "idCategories", referencedColumnName = "idCategories")
    @ManyToOne(optional = false)
    private Categories idCategories;
    
    @JoinColumn(name = "idAuthors", referencedColumnName = "idAuthors")
    @ManyToOne(optional = false)
    private Authors idAuthors;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBooks")
    private List<Requests> requestsList;

    public Books() {
    }

    public Books(Integer idBooks) {
        this.idBooks = idBooks;
    }

    public Books(Integer idBooks, String title, String isbn, Date date) {
        this.idBooks = idBooks;
        this.title = title;
        this.isbn = isbn;
        this.date = date;
    }

    public Integer getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(Integer idBooks) {
        this.idBooks = idBooks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public boolean isIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public Categories getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(Categories idCategories) {
        this.idCategories = idCategories;
    }

    public Authors getIdAuthors() {
        return idAuthors;
    }

    public void setIdAuthors(Authors idAuthors) {
        this.idAuthors = idAuthors;
    }

    @XmlTransient
    public List<Requests> getRequestsList() {
        return requestsList;
    }

    public void setRequestsList(List<Requests> requestsList) {
        this.requestsList = requestsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBooks != null ? idBooks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.idBooks == null && other.idBooks != null) || (this.idBooks != null && !this.idBooks.equals(other.idBooks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "p.lodz.pl.library.entities.Books[ idBooks=" + idBooks + " ]";
    }
    
}
