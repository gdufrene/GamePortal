package fr.eservice.portal.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service de gestion des scores.
 * @author rally-devteam
 */
@Component
public class ScoreService {

	private ScoreDAO scoreDAO;

	@Autowired
	public void setScoreDAO(ScoreDAO scoreDAO) {
		this.scoreDAO = scoreDAO;
	}
	
	public void sauvegarderScores(int identifiantJeu, int identifiantSession, List<ScoreBean> scores) {
		scoreDAO.enregistrerScores(identifiantJeu, identifiantSession, scores);
	}
	
	
}
