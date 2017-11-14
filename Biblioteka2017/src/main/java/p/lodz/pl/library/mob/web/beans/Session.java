/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mob.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import p.lodz.pl.library.entities.Authors;
import p.lodz.pl.library.entities.Books;
import p.lodz.pl.library.entities.Categories;
import p.lodz.pl.mob.endpoints.MOBEndpointLocal;

/**
 *
 * @author Lopez
 */
@SessionScoped
public class Session implements Serializable {

    @EJB
    private MOBEndpointLocal mOBEndpoint;
    
    public void addBook(Books book) {
        mOBEndpoint.addBook(book);
    }

    public List<Categories> getAllCategories() {
        return mOBEndpoint.getAllCategories();
    }

    public List<Authors> getAllAuthors() {
        return mOBEndpoint.getAllAuthors();
    }
    
}
