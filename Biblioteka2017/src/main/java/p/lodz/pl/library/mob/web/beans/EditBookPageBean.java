/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mob.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import p.lodz.pl.library.entities.Authors;
import p.lodz.pl.library.entities.Books;
import p.lodz.pl.library.entities.Categories;

/**
 *
 * @author Paweł Cała
 */
@ManagedBean
@ViewScoped
public class EditBookPageBean implements Serializable {
    
    @Inject
    private Session session;
    
    private Books book;
    private List<Categories> categories;
    private List<Authors> authors;

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }
    
    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }
    
    public EditBookPageBean() {
        
    }
    
    @PostConstruct
    private void initModel() {
        this.book = session.getCurrentlyEditedBook();
        this.categories = getAllCategories();
        this.authors = getAllAuthors();
    }
    
    public String editBook() {
        session.saveEditedBook(book);
        return "successAfterBookEdited";
    }
    
    public List<Categories> getAllCategories() {
        return session.getAllCategories();
    }
    
    public List<Authors> getAllAuthors() {
        return session.getAllAuthors();
    }
}
