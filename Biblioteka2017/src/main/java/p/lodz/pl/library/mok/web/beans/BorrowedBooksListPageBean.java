/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mok.web.beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import p.lodz.pl.library.facades.RequestsFacadeLocal;

/**
 *
 * @author nero1
 */
@Named(value = "borrowedBooksListPageBean")
@Dependent
public class BorrowedBooksListPageBean {

    @EJB
    private RequestsFacadeLocal requestsFacade;

    /**
     * Creates a new instance of BorrowedBooksListPageBean
     */
    public BorrowedBooksListPageBean() 
    {
        
    }
    
}
