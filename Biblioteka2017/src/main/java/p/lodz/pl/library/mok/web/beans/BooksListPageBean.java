/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mok.web.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author nero1
 */
@Named(value = "booksListPageBean")
@RequestScoped
public class BooksListPageBean implements Serializable{

    /**
     * Creates a new instance of BooksListPageBean
     */
    public BooksListPageBean() {
    }
    
}
