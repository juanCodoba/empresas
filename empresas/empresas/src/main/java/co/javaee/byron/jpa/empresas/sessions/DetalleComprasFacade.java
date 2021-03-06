/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.javaee.byron.jpa.empresas.sessions;

import co.javaee.byron.jpa.empresas.entities.DetalleCompras;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi1199561
 */
@Stateless
public class DetalleComprasFacade extends AbstractFacade<DetalleCompras> {

    @PersistenceContext(unitName = "co.javaee.byron.jpa_empresas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleComprasFacade() {
        super(DetalleCompras.class);
    }
    
}
