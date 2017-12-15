/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.mob.endpoints;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import p.lodz.pl.library.entities.Authors;
import p.lodz.pl.library.entities.Books;
import p.lodz.pl.library.entities.Categories;
import p.lodz.pl.library.facades.AuthorsFacadeLocal;
import p.lodz.pl.library.facades.BooksFacadeLocal;
import p.lodz.pl.library.facades.CategoriesFacadeLocal;

/**
 *
 * @author Paweł
 */
@Stateful
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MOBEndpoint implements MOBEndpointLocal {

    @EJB
    private BooksFacadeLocal bookFacade;
    
    @EJB
    private CategoriesFacadeLocal categoryFacade;
    
    @EJB
    private AuthorsFacadeLocal authorFacade;
    
    @Override
    public void addBook(Books book) {
       bookFacade.create(book);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoryFacade.findAll();
    }

    @Override
    public List<Authors> getAllAuthors() {
        return authorFacade.findAll();
    }

    @Override
    public Object getCategoryByName(String name) {
        return categoryFacade.findByName(name);
    }

    @Override
    public Object getAuthorByName(String name) {
        return authorFacade.findByName(name);
    }

    @Override
    public void saveEditedBook(Books book) {
        bookFacade.edit(book);
    }

    @Override
    public Books getBookToEdit(Books book) {
        return bookFacade.find(book.getIdBooks());
    }

    @Override
    public void addAuthor(Authors author) {
        authorFacade.create(author);
    }

    @Override
    public void addCategory(Categories category) {
        categoryFacade.create(category);
    }
    
}
