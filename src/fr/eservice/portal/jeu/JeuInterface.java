package fr.eservice.portal.jeu;

public interface JeuInterface {
	
	/**
	 * Démarre le jeu
	 */
	public void demarrerJeu();

	/**
	 * Ajoute un participant au jeu
	 * @param utilisateur
	 * @return true si on démarre le jeu, false si on attend encore des joueurs
	 */
	public boolean ajouterParticipant(String utilisateur);
	
	/**
	 * Supprime un utilisateur
	 * @param utilisateur
	 * @return
	 */
	public boolean supprimerParticipant(String utilisateur);
	
}
