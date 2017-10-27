/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.models;

import java.io.Serializable;
import p.lodz.pl.library.entities.Books;

/**
 *
 * @author nero1
 */
public class BookModel  implements Serializable {
    private String authorName;
    private String cathegory;
    private Books book;

    public BookModel(String authotName, String Cathegory, Books book) {
        this.authorName = authotName;
        this.cathegory = Cathegory;
        this.book = book;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authotName) {
        this.authorName = authotName;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String Cathegory) {
        this.cathegory = Cathegory;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }
    
    
    
}
