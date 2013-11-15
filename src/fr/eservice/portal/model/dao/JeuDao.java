package fr.eservice.portal.model.dao;

import java.util.List;

import fr.eservice.portal.model.entite.Jeu;

/**
 * Interface façade qui permet de gerer l'entité JEU.
 * 
 * @author nath
 */
public interface JeuDao {

    /**
     * Cette methode permet de recuperer la liste de tous les jeux disponibles
     * sur le portail.
     * 
     * @return la liste de tous les jeux disponibles en base de données
     */
    List<Jeu> listerJeu();

}
