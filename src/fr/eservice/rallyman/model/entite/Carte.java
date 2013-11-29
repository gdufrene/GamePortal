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
	
}
