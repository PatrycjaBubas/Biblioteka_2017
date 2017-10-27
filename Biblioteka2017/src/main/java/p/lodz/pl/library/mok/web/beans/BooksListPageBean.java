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
import p.lodz.pl.library.facades.AuthorsFacadeLocal;
import p.lodz.pl.library.facades.BooksFacadeLocal;
import p.lodz.pl.library.facades.CategoriesFacadeLocal;
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
    
    @EJB
    private AuthorsFacadeLocal authorsFacade;
    
    @EJB
    private CategoriesFacadeLocal categoriesFacade;

    /**
     * Creates a new instance of BooksListPageBean
     */
    public BooksListPageBean() {
    }
    
    public List<BookModel> getResulBooksList(){
        
        List<BookModel> resulBooksList = new ArrayList<BookModel>();
        List<Books> books = new ArrayList<Books>();
        books = booksFacade.findAll();
        
        for(Books b : books)
        {
            resulBooksList.add(new BookModel(authorsFacade.find(b.getIdAuthors()).getName() + " " + authorsFacade.find(b.getIdAuthors()).getSurname(), categoriesFacade.find(b.getIdCategories()).getName(),b));   
        }
        
        return resulBooksList;
        
    }
    
}
