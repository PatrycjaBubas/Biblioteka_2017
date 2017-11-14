/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.facades;

import java.util.List;
import javax.ejb.Local;
import p.lodz.pl.library.entities.Categories;

/**
 *
 * @author Paweł Cała
 */
@Local
public interface CategoriesFacadeLocal {

    void create(Categories categories);

    void edit(Categories categories);

    void remove(Categories categories);

    Categories find(Object id);

    List<Categories> findAll();

    List<Categories> findRange(int[] range);

    int count();

    public Object findByName(String name);
    
}
