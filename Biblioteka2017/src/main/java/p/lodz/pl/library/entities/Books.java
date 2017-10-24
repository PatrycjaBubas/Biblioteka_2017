/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Paweł Cała
 */
@Entity
@Table(name = "books")
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findByIdBooks", query = "SELECT b FROM Books b WHERE b.idBooks = :idBooks"),
    @NamedQuery(name = "Books.findByTitle", query = "SELECT b FROM Books b WHERE b.title = :title"),
    @NamedQuery(name = "Books.findByIdAuthors", query = "SELECT b FROM Books b WHERE b.idAuthors = :idAuthors"),
    @NamedQuery(name = "Books.findByIdCategories", query = "SELECT b FROM Books b WHERE b.idCategories = :idCategories"),
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
    @Column(name = "idAuthors")
    private int idAuthors;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCategories")
    private int idCategories;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "isbn")
    private String isbn;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    private int date;

    public Books() {
    }

    public Books(Integer idBooks) {
        this.idBooks = idBooks;
    }

    public Books(Integer idBooks, String title, int idAuthors, int idCategories, String isbn, int date) {
        this.idBooks = idBooks;
        this.title = title;
        this.idAuthors = idAuthors;
        this.idCategories = idCategories;
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

    public int getIdAuthors() {
        return idAuthors;
    }

    public void setIdAuthors(int idAuthors) {
        this.idAuthors = idAuthors;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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
