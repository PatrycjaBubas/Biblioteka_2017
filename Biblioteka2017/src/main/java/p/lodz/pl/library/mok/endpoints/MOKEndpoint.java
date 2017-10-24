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

/**
 *
 * @author Paweł Cała
 */
@Stateful
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MOKEndpoint implements MOKEndpointLocal {

    @EJB
    private UsersFacadeLocal usersFacade;
    
    @Override
    public void registerAccount(Users user) {
        usersFacade.create(user);
    }
    
}
