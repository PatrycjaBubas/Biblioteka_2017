/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.managers;

import p.lodz.pl.library.entities.Users;

/**
 *
 * @author Paweł Cała
 */
public interface UserRegistrationManagerLocal {
    
    public Users prepareUserAccountToRegister(Users user);
}
