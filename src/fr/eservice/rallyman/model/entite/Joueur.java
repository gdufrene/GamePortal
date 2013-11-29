package fr.eservice.rallyman.model.entite;

import java.io.Serializable;


/**
 * Mod�lisation d'un joueur du jeu.
 * @author rally-devteam
 */
public class Joueur implements Serializable {

	private static final long serialVersionUID = 1237704765278333747L;

	protected int identifiant;
	
	protected Voiture voiture;
	
	protected int temps;

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}
	
}
