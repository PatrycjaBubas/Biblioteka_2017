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
import javax.enterprise.context.Dependent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import p.lodz.pl.library.entities.Books;
import p.lodz.pl.library.entities.Requests;
import p.lodz.pl.library.entities.Users;
import p.lodz.pl.library.facades.BooksFacadeLocal;
import p.lodz.pl.library.facades.RequestsFacadeLocal;
import p.lodz.pl.library.facades.UsersFacadeLocal;
import p.lodz.pl.library.mob.web.beans.Session;
import p.lodz.pl.library.models.BorrowedBookModel;

/**
 *
 * @author nero1
 */
@Named(value = "borrowedBooksListPageBean")
@Dependent
public class BorrowedBooksListPageBean implements Serializable {

    @EJB
    private RequestsFacadeLocal requestsFacade;
    
    @EJB
    private UsersFacadeLocal usersFacade;

    @EJB
    private BooksFacadeLocal booksFacade;
    /**
     * Creates a new instance of BorrowedBooksListPageBean
     */
    
    @Inject
    private Session session;
    
    private DataModel<Books> booksDataModel;

    public DataModel<Books> getBooksDataModel() {
        return booksDataModel;
    }

    public void setBooksDataModel(DataModel<Books> booksDataModel) {
        this.booksDataModel = booksDataModel;
    }
    
    public BorrowedBooksListPageBean() 
    {
    }
    
    public List<BorrowedBookModel> getBorrowedBooks()
    {
        List<BorrowedBookModel> borrowedBooks = new ArrayList<>();
        List<Requests> requests = new ArrayList<>();
        
        requests = requestsFacade.findAll();
        
        for(Requests r : requests)
        {
            borrowedBooks.add(new BorrowedBookModel(usersFacade.find(r.getIdUsers()).getName() + " " + usersFacade.find(r.getIdUsers()).getSurname(), booksFacade.find(r.getIdBooks()).getTitle(),r));   
        }
        
        return borrowedBooks;
    }
    
    @PostConstruct
    public void getAllBorrowedBooksList() {
        this.booksDataModel = new ListDataModel(this.getBorrowedBooksOfUser());
    }
    
    public List<Books> getBorrowedBooksOfUser() {
        Users user = session.getCurrentUsersAccount();
        List<Books> borrowedList = new ArrayList<>();
        for(Requests r : user.getRequestsList()) {
            borrowedList.add(r.getIdBooks());
        }
        return borrowedList;
    }
    
    public String giveBackSelectedBook() {
        Books book = booksDataModel.getRowData();
        book.setIsBorrowed(false);
        session.saveEditedBook(book);
        
        return null;
    }
}
