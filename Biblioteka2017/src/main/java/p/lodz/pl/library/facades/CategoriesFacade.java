/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import p.lodz.pl.library.entities.Categories;

/**
 *
 * @author Paweł Cała
 */
@Stateless
public class CategoriesFacade extends AbstractFacade<Categories> implements CategoriesFacadeLocal {
    @PersistenceContext(unitName = "com.zmzp_Biblioteka2017_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriesFacade() {
        super(Categories.class);
    }

    @Override
    public Object findByName(String category) {
        Query q = em.createNamedQuery("Categories.findByName");
        q.setParameter("name", category);
        try {
            return (Categories) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
