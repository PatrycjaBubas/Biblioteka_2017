/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mob.web.beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import p.lodz.pl.library.entities.Authors;

/**
 *
 * @author Paweł
 */
@ManagedBean
@ViewScoped
public class AddAuthorPageBean {
    
    @Inject
    private Session session;
    
    private String name;
    private String surname;
    private Date birthDate;
    
    private final Authors author = new Authors();

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public String addAuthor() {
        author.setName(name);
        author.setSurname(surname);
        author.setDateOfBrith(birthDate);
        
        session.addAuthor(author);
        return "successAfterAuthorAdded";
    }
}
