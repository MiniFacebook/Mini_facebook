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
public class Publication implements Serializable {
    @OneToMany(mappedBy = "publication")
    private List<Aime> aimes;
    @OneToMany(mappedBy = "publication")
    private List<Commentaire> commentaires;
    @OneToMany(mappedBy = "publication")
    private List<Contenu> contenus;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePublication;
    private String texte;
    @ManyToOne
    private User recepteurPublicartion;
    @ManyToOne
    private User emetteurPublicartion;
    @ManyToOne
    private Groupe groupe;
    @OneToMany(mappedBy = "publicationSignale")
    private List<Signaler> signalers;

    public Publication() {
    }

    public Publication(Long id) {
        this.id = id;
    }

    public List<Aime> getAimes() {
        return aimes;
    }

    public void setAimes(List<Aime> aimes) {
        this.aimes = aimes;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Contenu> getContenus() {
        return contenus;
    }

    public void setContenus(List<Contenu> contenus) {
        this.contenus = contenus;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public User getRecepteurPublicartion() {
        return recepteurPublicartion;
    }

    public void setRecepteurPublicartion(User recepteurPublicartion) {
        this.recepteurPublicartion = recepteurPublicartion;
    }

    public User getEmetteurPublicartion() {
        return emetteurPublicartion;
    }

    public void setEmetteurPublicartion(User emetteurPublicartion) {
        this.emetteurPublicartion = emetteurPublicartion;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
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
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", datePublication=" + datePublication + ", texte=" + texte + '}';
    }

   
    
}
