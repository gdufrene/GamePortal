package fr.eservice.rallyman.model.entite;

import java.util.ArrayList;
import java.util.List;

import fr.eservice.rallyman.model.Constantes;

/**
 * Modélisation des dés du jeu.
 * @author rally-devteam
 */
public class Des {

	// vitesse1 - vitesse2 - vitesse3 - vitesse4 - vitesse5 - gaz1 - gaz2
	protected List<String> listeDes;
	
	public Des() {
		listeDes = new ArrayList<String>();
		reinitialiserDes();
	}

	public void reinitialiserDes() {
		listeDes.clear();
		listeDes.add(Constantes.DE_VITESSE1);
		listeDes.add(Constantes.DE_VITESSE2);
		listeDes.add(Constantes.DE_VITESSE3);
		listeDes.add(Constantes.DE_VITESSE4);
		listeDes.add(Constantes.DE_VITESSE5);
		listeDes.add(Constantes.DE_GAZ1);
		listeDes.add(Constantes.DE_GAZ2);
	}
	
	/**
	 * Supprime un dé de la liste (intervient quand un joueur a utilisé le dé durant un tour).
	 * @param de : le nom du dé.
	 */
	public void supprimerDe(String de) {
		listeDes.remove(de);
	}

	public List<String> getListeDes() {
		return listeDes;
	}

	public List<String> getListeDesDisponibles(int vitesseCourante, Cellule cellule, Cellule celluleSuivante) {
		
		List<String> desDisponibles = new ArrayList<String>();
		
		for(String de : listeDes) {
			desDisponibles.add(de);
		}
		
		// retrait des dés selon la vitesse courante
		switch(vitesseCourante) {
			case 0:
				desDisponibles.remove(Constantes.DE_VITESSE2);
				desDisponibles.remove(Constantes.DE_VITESSE3);
				desDisponibles.remove(Constantes.DE_VITESSE4);
				desDisponibles.remove(Constantes.DE_VITESSE5);
				desDisponibles.remove(Constantes.DE_GAZ1);
				desDisponibles.remove(Constantes.DE_GAZ2);
			break;
			case 1:
				desDisponibles.remove(Constantes.DE_VITESSE1);
				desDisponibles.remove(Constantes.DE_VITESSE3);
				desDisponibles.remove(Constantes.DE_VITESSE4);
				desDisponibles.remove(Constantes.DE_VITESSE5);
			break;
			case 2:
				desDisponibles.remove(Constantes.DE_VITESSE2);
				desDisponibles.remove(Constantes.DE_VITESSE4);
				desDisponibles.remove(Constantes.DE_VITESSE5);
			break;
			case 3:
				desDisponibles.remove(Constantes.DE_VITESSE1);
				desDisponibles.remove(Constantes.DE_VITESSE3);
				desDisponibles.remove(Constantes.DE_VITESSE5);
			break;
			case 4:
				desDisponibles.remove(Constantes.DE_VITESSE1);
				desDisponibles.remove(Constantes.DE_VITESSE2);
				desDisponibles.remove(Constantes.DE_VITESSE4);
			break;
			case 5:
				desDisponibles.remove(Constantes.DE_VITESSE1);
				desDisponibles.remove(Constantes.DE_VITESSE2);
				desDisponibles.remove(Constantes.DE_VITESSE3);
				desDisponibles.remove(Constantes.DE_VITESSE5);
			break;
		}
		
		// retrait des dés si limitation de vitesse sur la cellule
		switch(cellule.getLimitationVitesse()) {
			case 2:
				desDisponibles.remove(Constantes.DE_VITESSE3);
				desDisponibles.remove(Constantes.DE_VITESSE4);
				desDisponibles.remove(Constantes.DE_VITESSE5);
			break;
			case 3:
				desDisponibles.remove(Constantes.DE_VITESSE4);
				desDisponibles.remove(Constantes.DE_VITESSE5);
			break;
			case 4:
				desDisponibles.remove(Constantes.DE_VITESSE5);
			break;
		}
		
		// retrait des dés si la cellule suivante contient déjà deux voitures
		if(celluleSuivante.getNombreVoitures() == 2){
			desDisponibles.remove(Constantes.DE_VITESSE1);
			desDisponibles.remove(Constantes.DE_VITESSE2);
			desDisponibles.remove(Constantes.DE_VITESSE3);
			desDisponibles.remove(Constantes.DE_VITESSE4);
			desDisponibles.remove(Constantes.DE_VITESSE5);
			desDisponibles.remove(Constantes.DE_GAZ1);
			desDisponibles.remove(Constantes.DE_GAZ2);
		}
		
		return desDisponibles;
	}
	
}
