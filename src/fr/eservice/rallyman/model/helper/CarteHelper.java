package fr.eservice.rallyman.model.helper;

import java.util.ArrayList;
import java.util.List;

import fr.eservice.rallyman.model.Constantes;
import fr.eservice.rallyman.model.entite.Carte;
import fr.eservice.rallyman.model.entite.Cellule;

/**
 * Helper pour instancier un tracé.
 * @author rally-devteam
 */
public class CarteHelper {

	
	/**
	 * Initialise une carte de jeu.
	 * @return {@link Carte}
	 */
	public static Carte initialiserCarte1() {
		
		Carte carte = new Carte();
		
		List<Cellule> listeCellules = new ArrayList<Cellule>();
		
		listeCellules.add(new Cellule(1, 5, Constantes.TYPE_FORET, null, 0));
		listeCellules.add(new Cellule(2, 4, null, null, 0));
		listeCellules.add(new Cellule(3, 4, null, Constantes.TYPE_PLAN_EAU, 0));
		listeCellules.add(new Cellule(4, 5, null, null, 0));
		listeCellules.add(new Cellule(5, 5, null, null, 0));
		
		carte.setListeCellules(listeCellules);
		return carte;
	}
	
}
