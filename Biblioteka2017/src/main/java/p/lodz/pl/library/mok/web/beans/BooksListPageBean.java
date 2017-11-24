/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mok.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import p.lodz.pl.library.entities.Books;
import p.lodz.pl.library.facades.AuthorsFacadeLocal;
import p.lodz.pl.library.facades.BooksFacadeLocal;
import p.lodz.pl.library.facades.CategoriesFacadeLocal;
import p.lodz.pl.library.mob.web.beans.Session;
import p.lodz.pl.library.models.BookModel;

/**
 *
 * @author nero1
 */
@Named(value = "booksListPageBean")
@RequestScoped
public class BooksListPageBean implements Serializable{

    @EJB
    private BooksFacadeLocal booksFacade;
    
    @Inject
    private Session session;
    
    private DataModel<Books> booksDataModel;

    public DataModel<Books> getBooksDataModel() {
        return booksDataModel;
    }

    public void setBooksDataModel(DataModel<Books> booksDataModel) {
        this.booksDataModel = booksDataModel;
    }
    
    

    /**
     * Creates a new instance of BooksListPageBean
     */
    public BooksListPageBean() {
    }
    
    @PostConstruct
    public void getResulBooksList(){
        booksDataModel = new ListDataModel(booksFacade.findAll());
        
    }
    
    public String editBook() {
        session.getBookToEdit(booksDataModel.getRowData());
        return "editBook";
    }
    
    public String borrowBook() {        
        session.getBookToBorrow(booksDataModel.getRowData());
        return "borrowBook";
    }
    
}
