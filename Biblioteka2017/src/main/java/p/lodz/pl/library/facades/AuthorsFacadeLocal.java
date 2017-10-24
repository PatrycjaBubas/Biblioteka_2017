/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.facades;

import java.util.List;
import javax.ejb.Local;
import p.lodz.pl.library.entities.Authors;

/**
 *
 * @author Paweł Cała
 */
@Local
public interface AuthorsFacadeLocal {

    void create(Authors authors);

    void edit(Authors authors);

    void remove(Authors authors);

    Authors find(Object id);

    List<Authors> findAll();

    List<Authors> findRange(int[] range);

    int count();
    
}
