package fr.eservice.rallyman.model.entite;

import java.util.List;

/**
 * Modélisaiton du plateau de jeu.
 * @author rally-devteam
 */
public class Carte {

	protected List<Cellule> listeCellules;

	public List<Cellule> getListeCellules() {
		return listeCellules;
	}

	public void setListeCellules(List<Cellule> listeCellules) {
		this.listeCellules = listeCellules;
	}

	/**
	 * Réinitialise la carte pour une nouvelle course.
	 */
	public void reinitialiser() {
		for(final Cellule cellule : listeCellules) {
			cellule.setNombreVoitures(0);
		}
	}
	
}
