/**
 * 
 */
package fr.eservice.rallyman.model.entite;


/**
 * @author alexandre
 *
 */
public class De {
	
	public enum TypeDe {
		vitesse, gaz
	}
	
	protected TypeDe 	type;
	protected Boolean	disponible;
	protected Boolean	utilise;
	protected int		valeur;

	public De(TypeDe type, int valeur) {
		this.type = type;
		this.valeur = valeur;
		this.disponible = true;
		this.utilise = false;
	}

	
	
	/**
	 * @return the utilise
	 */
	public Boolean getUtilise() {
		return utilise;
	}

	/**
	 * @param utilise the utilise to set
	 */
	public void setUtilise(Boolean utilise) {
		this.utilise = utilise;
	}

	/**
	 * @return the disponible
	 */
	public Boolean getDisponible() {
		return disponible;
	}

	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}	
	
}
