package fr.eservice.rallyman.model.entite;


/**
 * Mod�lisation d'une voiture.
 * @author rally-devteam
 */
public class Voiture {

	protected int identifiant;
	
	protected String couleur;
	
	protected int vitesseCourante;

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getVitesseCourante() {
		return vitesseCourante;
	}

	public void setVitesseCourante(int vitesseCourante) {
		this.vitesseCourante = vitesseCourante;
	}
	
	
}
