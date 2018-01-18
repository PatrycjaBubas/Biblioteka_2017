/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import p.lodz.pl.library.entities.Requests;

/**
 *
 * @author Paweł Cała
 */
@Stateless
public class RequestsFacade extends AbstractFacade<Requests> implements RequestsFacadeLocal {
    @PersistenceContext //(unitName = "com.zmzp_Biblioteka2017_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequestsFacade() {
        super(Requests.class);
    }
    
}
