/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevice;

import bean.GroupeAdmin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lenovo
 */
@Stateless
public class GroupeAdminFacade extends AbstractFacade<GroupeAdmin> {

    @PersistenceContext(unitName = "FacebookWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupeAdminFacade() {
        super(GroupeAdmin.class);
    }
    
}
