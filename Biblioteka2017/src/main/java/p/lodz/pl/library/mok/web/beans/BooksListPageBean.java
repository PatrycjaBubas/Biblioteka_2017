/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mok.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import p.lodz.pl.library.entities.Books;
import p.lodz.pl.library.facades.BooksFacadeLocal;

/**
 *
 * @author nero1
 */
@Named(value = "booksListPageBean")
@RequestScoped
public class BooksListPageBean implements Serializable{

    @EJB
    private BooksFacadeLocal booksFacade;

    /**
     * Creates a new instance of BooksListPageBean
     */
    public BooksListPageBean() {
    }
    
    public List<Books> getBooks(){
        
        List<Books> books = new ArrayList<Books>();
        books = booksFacade.findAll();
        
        return books;
        
    }
    
}
