package fr.eservice.portal.model.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jeu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJeu;

    @Column(name = "nom_jeu")
    private String nomJeu;

    @Column(name = "date_creation_jeu")
    private Date dateCreation;

    @Column(name = "type_jeu")
    private String type;

    /**
     * @return the nomJeu
     */
    public String getNomJeu() {
        return nomJeu;
    }

    /**
     * @param nomJeu
     *            the nomJeu to set
     */
    public void setNomJeu(String nomJeu) {
        this.nomJeu = nomJeu;
    }

    /**
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * @param dateCreation
     *            the dateCreation to set
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
