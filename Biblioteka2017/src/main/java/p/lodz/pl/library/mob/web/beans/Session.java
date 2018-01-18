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
import p.lodz.pl.library.entities.Requests;
import p.lodz.pl.library.entities.Users;
import p.lodz.pl.library.facades.UsersFacade;
import p.lodz.pl.mob.endpoints.MOBEndpointLocal;

/**
 *
 * @author Lopez
 */
@SessionScoped
public class Session implements Serializable {

    @EJB
    private MOBEndpointLocal mOBEndpoint;
    
    private Books currentlyEditedBook;
    
    private Books currentBook;
    
    public void addBook(Books book) {
        mOBEndpoint.addBook(book);
    }

    public List<Categories> getAllCategories() {
        return mOBEndpoint.getAllCategories();
    }

    public List<Authors> getAllAuthors() {
        return mOBEndpoint.getAllAuthors();
    }

    public Books getCurrentlyEditedBook() {
        return currentlyEditedBook;
    }

    public void saveEditedBook(Books book) {
        mOBEndpoint.saveEditedBook(book);
    }

    public void getBookToEdit(Books book) {
        currentlyEditedBook = mOBEndpoint.getBookToEdit(book);
    }

    public void addAuthor(Authors author) {
        mOBEndpoint.addAuthor(author);
    }

    public void addCategory(Categories category) {
        mOBEndpoint.addCategory(category);
    }

    public void getCurrentBook(Books book) {
        this.currentBook = mOBEndpoint.getCurrentBook(book);
    }
    
    public Books getCurrentlyUsedBook() {
        return currentBook;
    }

    public Users getCurrentUsersAccount() {
        return mOBEndpoint.getCurrentUsersAccount();
    }

    public void addRequest(Requests request) {
        mOBEndpoint.addRequest(request);
    }
    
}
