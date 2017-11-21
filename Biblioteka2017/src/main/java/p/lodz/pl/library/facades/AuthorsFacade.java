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
import p.lodz.pl.library.entities.Authors;

/**
 *
 * @author Paweł Cała
 */
@Stateless
public class AuthorsFacade extends AbstractFacade<Authors> implements AuthorsFacadeLocal {
    @PersistenceContext(unitName = "com.zmzp_Biblioteka2017_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthorsFacade() {
        super(Authors.class);
    }

    @Override
    public Object findByName(String author) {
        Query q = em.createNamedQuery("Authors.findByName");
        q.setParameter("name", author);
        try {
            return (Authors) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
