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
@Table(name = "authors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a"),
    @NamedQuery(name = "Authors.findByIdAuthors", query = "SELECT a FROM Authors a WHERE a.idAuthors = :idAuthors"),
    @NamedQuery(name = "Authors.findByName", query = "SELECT a FROM Authors a WHERE a.name = :name"),
    @NamedQuery(name = "Authors.findBySurname", query = "SELECT a FROM Authors a WHERE a.surname = :surname"),
    @NamedQuery(name = "Authors.findByDateOfBrith", query = "SELECT a FROM Authors a WHERE a.dateOfBrith = :dateOfBrith")})
public class Authors implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAuthors")
    private Integer idAuthors;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "surname")
    private String surname;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOfBrith")
    @Temporal(TemporalType.DATE)
    private Date dateOfBrith;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAuthors")
    private List<Books> booksList;

    public Authors() {
    }

    public Authors(Integer idAuthors) {
        this.idAuthors = idAuthors;
    }

    public Authors(Integer idAuthors, String name, String surname, Date dateOfBrith) {
        this.idAuthors = idAuthors;
        this.name = name;
        this.surname = surname;
        this.dateOfBrith = dateOfBrith;
    }

    public Integer getIdAuthors() {
        return idAuthors;
    }

    public void setIdAuthors(Integer idAuthors) {
        this.idAuthors = idAuthors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(Date dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    @XmlTransient
    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuthors != null ? idAuthors.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.idAuthors == null && other.idAuthors != null) || (this.idAuthors != null && !this.idAuthors.equals(other.idAuthors))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "p.lodz.pl.library.entities.Authors[ idAuthors=" + idAuthors + " ]";
        //String fullname = ;
        return name + " " + surname;
    }
    
}
