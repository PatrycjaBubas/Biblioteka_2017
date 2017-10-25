/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mok.web.beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import p.lodz.pl.library.entities.Users;

/**
 *
 * @author Paweł Cała
 */
@Named
@RequestScoped
public class UserRegistrationPageBean implements Serializable {
    
    @Inject
    private UserSession userSession;
    
    private Users user = new Users();

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public String registerUser() {
        userSession.registerUser(user);
        return "successAfterRegister";
    }
}
