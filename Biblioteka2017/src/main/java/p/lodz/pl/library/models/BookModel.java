/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.models;

import java.awt.print.Book;
import java.io.Serializable;

/**
 *
 * @author nero1
 */
public class BookModel  implements Serializable {
    private String authotName;
    private String Cathegory;
    private Book book;

    public BookModel(String authotName, String Cathegory, Book book) {
        this.authotName = authotName;
        this.Cathegory = Cathegory;
        this.book = book;
    }

    public String getAuthotName() {
        return authotName;
    }

    public void setAuthotName(String authotName) {
        this.authotName = authotName;
    }

    public String getCathegory() {
        return Cathegory;
    }

    public void setCathegory(String Cathegory) {
        this.Cathegory = Cathegory;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    
    
}
