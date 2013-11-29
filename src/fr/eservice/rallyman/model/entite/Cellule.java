package fr.eservice.rallyman.model.entite;

/**
 * Modélisation d'une cellule.
 * @author rally-devteam
 */
public class Cellule {
	
	protected int identifiant;

	protected int limitationVitesse;
	
	protected String natureAGauche;
	
	protected String natureADroite;
	
	protected int nombreVoitures;
	
	public Cellule(int identifiant, int limitationVitesse, String natureAGauche, String natureADroite, int nombreVoitures) {
		super();
		this.identifiant = identifiant;
		this.limitationVitesse = limitationVitesse;
		this.natureAGauche = natureAGauche;
		this.natureADroite = natureADroite;
		this.nombreVoitures = nombreVoitures;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public int getLimitationVitesse() {
		return limitationVitesse;
	}

	public void setLimitationVitesse(int limitationVitesse) {
		this.limitationVitesse = limitationVitesse;
	}

	public String getNatureAGauche() {
		return natureAGauche;
	}

	public void setNatureAGauche(String natureAGauche) {
		this.natureAGauche = natureAGauche;
	}

	public String getNatureADroite() {
		return natureADroite;
	}

	public void setNatureADroite(String natureADroite) {
		this.natureADroite = natureADroite;
	}

	public int getNombreVoitures() {
		return nombreVoitures;
	}

	public void setNombreVoitures(int nombreVoitures) {
		this.nombreVoitures = nombreVoitures;
	}
	
}
