package fr.eservice.portal.score;

import java.util.List;

/**
 * Interface permettant de gérer les scores.
 * @author rally-devteam
 */
public interface IScore {

	/**
	 * Enregistre les scores de la session du jeu qui vient de se terminer. 
	 * @param identifiantJeu - identifiant du jeu joué
	 * @param identifiantPartie - identifiant de la session de jeu
	 * @param scores - liste de {@link ScoreBean}
	 */
	public void enregistrerScores(int identifiantJeu, int identifiantSession, final List<ScoreBean> scores);
	
	/**	
	 * Récupère les scores de la session du jeu passés en paramètre.
	 * @param identifiantJeu - identifiant du jeu
	 * @param identifiantPartie - identifiant de la session	 
	 * @return {@link List<ScoreBean>} liste de scores
	 */
	public List<ScoreBean> recupererScores(int identifiantJeu, int identifiantSession);

	/**
	 * Récupère la liste des sessions jouées pour le jeu passé en paramètre.
	 * @param identifiantJeu
	 * @return List<Integer>
	 */
	public List<Integer> recupererSessions(int identifiantJeu);
	
}
