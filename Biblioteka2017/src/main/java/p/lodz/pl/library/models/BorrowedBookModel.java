/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.models;

import java.io.Serializable;
import p.lodz.pl.library.entities.Requests;

/**
 *
 * @author nero1
 */
public class BorrowedBookModel implements Serializable 
{
    private String userName;
    private String bookTitle;
    private String returned;
    private Requests request;

    public BorrowedBookModel(String userName, String bookTitle, Requests request) {
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.request = request;
        if(request.getArchival())
        {
            returned = "TAK";
        }
        else
        {
            returned = "NIE";
        }
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String zwrocono) {
        this.returned = zwrocono;
    }
   
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Requests getRequest() {
        return request;
    }

    public void setRequest(Requests request) {
        this.request = request;
    }
    
}
