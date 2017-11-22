/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Paweł Cała
 */
@Named(value = "roleUtils")
@ApplicationScoped
public class RoleUtils {
    
    public RoleUtils() {

    }
    
    public static boolean isAccountInRole(String roleName) {
        boolean isInRole = FacesContext.getCurrentInstance().getExternalContext().isUserInRole(roleName);
        return isInRole;
    }
    
    public static boolean accountIsAuthorised() {
        String adminRole = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("adminRole");
        String readerRole = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("readerRole");
        return isAccountInRole(adminRole) || isAccountInRole(readerRole);
    }
    
    public static boolean accountIsAdministrator() {
        String role = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("adminRole");
        return isAccountInRole(role);
    }
    
    public static boolean accountIsReader() {
        String role = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("readerRole");
        return isAccountInRole(role);
    }
}
