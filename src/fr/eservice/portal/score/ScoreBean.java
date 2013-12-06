package fr.eservice.portal.score;

/**
 * Classe pour contenir un score.
 * TODO : ajouter les annotations pour la persistance.
 * @author rally-devteam
 */
public class ScoreBean {

	/**
	 * Identifiant de l'utilisateur.
	 */
	protected int identifiantUtilisateur;
	
	/**
	 * Score réalisé au cours de la partie par l'utilisateur.
	 */
	protected int score;
	
	/**
	 * Placement dans la partie (par exemple 1 pour 1er, 2 pour deuxième, ...).
	 * On ne peut pas se baser sur le score puisque dans certains cas, il faut le plus grand score pour
	 * gagner, et dans d'autres, il faut le plus petit score.
	 */
	protected int placement;
	
	
	public int getIdentifiantUtilisateur() {
		return identifiantUtilisateur;
	}
	
	public void setIdentifiantUtilisateur(int identifiantUtilisateur) {
		this.identifiantUtilisateur = identifiantUtilisateur;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getPlacement() {
		return placement;
	}
	
	public void setPlacement(int placement) {
		this.placement = placement;
	}
	
}
