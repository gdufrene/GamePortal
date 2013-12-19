package fr.eservice.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.eservice.portal.score.ScoreBean;
import fr.eservice.portal.score.ScoreService;


/**
 * Contrôleur pour manipuler les scores.
 * @author rallyman-devteam
 */
@Controller
public class ScoreController {

	private ScoreService scoreService;

	@Autowired
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	

	@RequestMapping("/portail-afficherScores")
	public ModelAndView recupererScores() {

		ModelAndView modele = new ModelAndView("portail/afficherScores");
		
		// dans le cas de notre application "bouchonnée", on récupère les scores de notre jeu, dont l'id est 1
		System.out.println("Affichage des sessions pour lesquelles on a un score");
		List<Integer> listes = scoreService.recupererSessions(1);
		for(final Integer l : listes) {
			System.out.println(l);
		}
		
		System.out.println("Récupération des scores du jeu 1 - session 15");
		List<ScoreBean> scores = scoreService.recupererScores(1, 15);
		for(final ScoreBean score : scores) {
			System.out.println("Utilisateur : " + score.getIdentifiantUtilisateur() + 
					" - Placement : " + score.getPlacement() + " - Score : " + score.getScore());
		}
		
		return modele;
	}
	
	
}
