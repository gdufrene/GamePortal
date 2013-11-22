package fr.eservice.rallyman.model.entite;

import java.util.List;

/**
 * Modélisation des dés du jeu.
 * @author rally-devteam
 */
public class Des {

	// vitesse1 - vitesse2 - vitesse3 - vitesse4 - vitesse5 - gaz1 - gaz2
	protected List<String> listeDes;
	
	
	
	/**
	 * Supprime un dé de la liste (intervient quand un joueur a utilisé le dé durant un tour).
	 * @param de : le nom du dé.
	 */
	public void supprimerDe(String de) {
		
	}
}
