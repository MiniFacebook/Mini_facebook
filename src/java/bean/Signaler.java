/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author lenovo
 */
@Entity
public class Signaler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User userSignale;
    @ManyToOne
    private Publication publicationSignale;
    private String cause;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSuppression;

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public User getUserSignale() {
        return userSignale;
    }

    public void setUserSignale(User userSignale) {
        this.userSignale = userSignale;
    }

    public Publication getPublicationSignale() {
        return publicationSignale;
    }

    public void setPublicationSignale(Publication publicationSignale) {
        this.publicationSignale = publicationSignale;
    }

    public List<SignalerItem> getSignalerItems() {
        return signalerItems;
    }

    public void setSignalerItems(List<SignalerItem> signalerItems) {
        this.signalerItems = signalerItems;
    }
    @OneToMany(mappedBy = "signaler")
    private List<SignalerItem> signalerItems;

    public Signaler() {
    }

    public Signaler(Long id) {
        this.id = id;
    }

    public Signaler(Long id, User userSignale, Publication publicationSignale) {
        this.id = id;
        this.userSignale = userSignale;
        this.publicationSignale = publicationSignale;
    }

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
        if (!(object instanceof Signaler)) {
            return false;
        }
        Signaler other = (Signaler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Signaler{" + "id=" + id + ", cause=" + cause + ", dateSuppression=" + dateSuppression + '}';
    }

}
