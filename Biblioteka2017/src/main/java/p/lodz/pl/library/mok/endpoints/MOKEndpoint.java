/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mok.endpoints;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import p.lodz.pl.library.entities.Users;
import p.lodz.pl.library.facades.UsersFacadeLocal;
import p.lodz.pl.library.managers.UserRegistrationManager;
import p.lodz.pl.library.managers.UserRegistrationManagerLocal;

/**
 *
 * @author Paweł Cała
 */
@Stateful
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MOKEndpoint implements MOKEndpointLocal {

    @EJB
    private UsersFacadeLocal usersFacade;
    
    @EJB
    private UserRegistrationManagerLocal userRegistrationManager;
    
    @Override
    public void registerAccount(Users user) {
        Users userToRegister = userRegistrationManager.prepareUserAccountToRegister(user);
        usersFacade.create(user);
    }
    
}
