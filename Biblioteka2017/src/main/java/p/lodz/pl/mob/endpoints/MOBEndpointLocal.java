/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.mob.endpoints;

import java.util.List;
import p.lodz.pl.library.entities.Authors;
import p.lodz.pl.library.entities.Books;
import p.lodz.pl.library.entities.Categories;

/**
 *
 * @author Paweł
 */
public interface MOBEndpointLocal {

    public void addBook(Books book);

    public List<Categories> getAllCategories();

    public List<Authors> getAllAuthors();

    public Object getCategoryByName(String value);

    public Object getAuthorByName(String value);

    public void saveEditedBook(Books book);

    public Books getBookToEdit(Books book);

    public void addAuthor(Authors author);
    
}
