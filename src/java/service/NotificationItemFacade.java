/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.NotificationItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lenovo
 */
@Stateless
public class NotificationItemFacade extends AbstractFacade<NotificationItem> {

    @PersistenceContext(unitName = "FacebookWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificationItemFacade() {
        super(NotificationItem.class);
    }
    
}
