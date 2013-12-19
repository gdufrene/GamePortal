/**
 * 
 */
package fr.eservice.rallyman.model.entite;

import java.util.ArrayList;

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
	protected int		valeur;

	public De(TypeDe type, int valeur) {
		this.type = type;
		this.valeur = valeur;
		this.disponible = true;
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
