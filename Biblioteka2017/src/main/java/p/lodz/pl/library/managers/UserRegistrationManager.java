/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.managers;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import p.lodz.pl.library.entities.Role;
import p.lodz.pl.library.entities.Users;
import p.lodz.pl.library.utils.MD5Hash;

/**
 *
 * @author Paweł Cała
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UserRegistrationManager implements UserRegistrationManagerLocal {

    @Override
    public Users prepareUserAccountToRegister(Users user) {
       
        String md5password = MD5Hash.md5(user.getPassword());
        user.setPassword(md5password);
        
        //brzydkie tymczasowe rozwiązanie
        Role r = new Role();
        r.setIdRole(1);
        user.setIdRole(r);
        return user;
    }
    
}
