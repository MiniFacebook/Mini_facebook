/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Groupe;
import bean.GroupeItem;
import bean.Invitation;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lenovo
 */
@Stateless
public class InvitationFacade extends AbstractFacade<Invitation> {

    @PersistenceContext(unitName = "FacebookWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    GroupeItemFacade groupeItemFacade = new GroupeItemFacade();

    public InvitationFacade() {
        super(Invitation.class);
    }

    //l'invetation va etre remplie en se basant sur les fields de view ***** POUR LES GROUPES PRIVER****
    private void join(Invitation invitation) {
        create(invitation);
    }

    private void accepterJoin(Invitation invitation) {
        invitation.setDateAcceptation(new Date());
        GroupeItem groupeItem = new GroupeItem();
        groupeItem.setDateIntegration(new Date());
        groupeItem.setDemandeur(invitation.getEmetteur());
        groupeItem.setGroupe(invitation.getGroupe());
        edit(invitation);
        groupeItemFacade.create(groupeItem);

    }

    public void invitationTypeGroupe(Invitation invitation) {
        Groupe groupe = invitation.getGroupe();
        if (groupe.getEtat() == 1) {//1= private
            join(invitation);

        } else {//2=public
            accepterJoin(invitation);
        }
    }

}
