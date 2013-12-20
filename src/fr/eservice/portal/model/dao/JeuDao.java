package fr.eservice.portal.model.dao;

import java.util.List;

import fr.eservice.portal.model.entite.Jeu;

/**
 * Interface fa�ade qui permet de gerer l'entit� JEU.
 * 
 * @author nath
 */
public interface JeuDao {

    /**
     * Cette methode permet de recuperer la liste de tous les jeux disponibles
     * sur le portail.
     * 
     * @return la liste de tous les jeux disponibles en base de donn�es
     */
    List<Jeu> listerJeu();

}
