/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mob.web.beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import p.lodz.pl.library.entities.Books;
import p.lodz.pl.library.entities.Requests;

/**
 *
 * @author Lopez
 */
@ManagedBean
@RequestScoped
public class AddRequestPageBean {
    
    @Inject
    private Session session;
    
    private final Requests request = new Requests();
    private Books book;
    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    public String addRequest() {
        book = session.getCurrentlyUsedBook();
        book.setIsBorrowed(true);
        session.saveEditedBook(book);
        request.setIdBooks(book);
        request.setBorrowDate(new Date());
        request.setIdUsers(session.getCurrentUsersAccount());
        request.setArchival(false);
        session.addRequest(request);
        
        return "successAfterRequestAdded";
    }
}
