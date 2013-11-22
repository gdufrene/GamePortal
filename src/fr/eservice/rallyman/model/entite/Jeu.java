package fr.eservice.rallyman.model.entite;

import java.util.Collections;
import java.util.List;

/**
 * Mod�lisation du jeu Rallyman.
 * @author rally-devteam
 */
public class Jeu {

	protected List<Joueur> listeJoueurs;
	
	protected List<Des> listeDe;
	
	protected Carte carte;
	
	protected int courseCourante;
	
	public void demarrerJeu() {
		
		// ordre al�atoire de jeu au lancement du jeu.
		Collections.shuffle(listeJoueurs);
	}
	
}
