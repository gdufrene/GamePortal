package fr.eservice.portal.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service de gestion des scores.
 * @author rally-devteam
 */
@Component
public class ScoreService implements IScore {

	private ScoreDAO scoreDAO;

	@Autowired
	public void setScoreDAO(ScoreDAO scoreDAO) {
		this.scoreDAO = scoreDAO;
	}

	public void enregistrerScores(int identifiantJeu, int identifiantSession,
			List<ScoreBean> scores) {
		scoreDAO.enregistrerScores(identifiantJeu, identifiantSession, scores);
	}

	public List<ScoreBean> recupererScores(int identifiantJeu,
			int identifiantSession) {
		return scoreDAO.recupererScores(identifiantJeu, identifiantSession);
	}

	public List<Integer> recupererSessions(int identifiantJeu) {
		return scoreDAO.recupererSessions(identifiantJeu);
	}
	
	
}
