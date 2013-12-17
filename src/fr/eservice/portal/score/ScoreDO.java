package fr.eservice.portal.score;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Objet score persisté en base de données.
 * @author rally-devteam
 */
@Entity(name="GAMEPORTAL")
public class ScoreDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="identifiant")
	protected int identifiant;
	
	@Column(name="identifiant_jeu")
	protected int identifiantJeu;
	
	@Column(name="identifiant_session")
	protected int identifiantSession;
	
	/*
	 * Attributs issus de {@link ScoreBean}
	 */
	@Column(name="identifiant_utilisateur")
	protected int identifiantUtilisateur;
	
	@Column(name="score")
	protected int score;
	
	@Column(name="placement")
	protected int placement;
	
	
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public int getIdentifiantJeu() {
		return identifiantJeu;
	}
	public void setIdentifiantJeu(int identifiantJeu) {
		this.identifiantJeu = identifiantJeu;
	}
	public int getIdentifiantSession() {
		return identifiantSession;
	}
	public void setIdentifiantSession(int identifiantSession) {
		this.identifiantSession = identifiantSession;
	}
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
