/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author lenovo
 */
@Entity
public class SignalerItem implements Serializable {

    public Date getDateSignaler() {
        return dateSignaler;
    }

    public void setDateSignaler(Date dateSignaler) {
        this.dateSignaler = dateSignaler;
    }

    public User getUserAction() {
        return userAction;
    }

    public void setUserAction(User userAction) {
        this.userAction = userAction;
    }

    public Signaler getSignaler() {
        return signaler;
    }

    public void setSignaler(Signaler signaler) {
        this.signaler = signaler;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSignaler;
    @ManyToOne
    private User userAction;
    @ManyToOne
    private Signaler signaler; 
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SignalerItem)) {
            return false;
        }
        SignalerItem other = (SignalerItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.SignalerItem[ id=" + id + " ]";
    }
    
}
