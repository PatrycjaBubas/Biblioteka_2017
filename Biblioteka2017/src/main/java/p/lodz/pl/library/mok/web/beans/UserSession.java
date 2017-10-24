/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mok.web.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import p.lodz.pl.library.entities.Users;
import p.lodz.pl.library.mok.endpoints.MOKEndpointLocal;

/**
 *
 * @author Paweł Cała
 */
@SessionScoped
public class UserSession implements Serializable {
    
    @EJB
    private MOKEndpointLocal mOKEndpoint;

    void registerUser(Users user) {
        mOKEndpoint.registerAccount(user);
    }
    
}
