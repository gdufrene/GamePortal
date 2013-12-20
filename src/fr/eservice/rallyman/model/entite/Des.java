package fr.eservice.rallyman.model.entite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import fr.eservice.rallyman.model.Constantes;
import fr.eservice.rallyman.model.entite.De.TypeDe;

/**
 * Mod��lisation des d��s du jeu.
 * @author rally-devteam
 */
public class Des {

	// vitesse1 - vitesse2 - vitesse3 - vitesse4 - vitesse5 - gaz1 - gaz2
	/*protected De vitesse1;
	protected De vitesse2;
	protected De vitesse3;
	protected De vitesse4;
	protected De vitesse5;
	protected De gaz1;
	protected De gaz2;*/
	public HashMap<String, De> listDes;
	
	
	public Des() {
		this.listDes = new HashMap<String, De>();
		
		this.listDes.put(Constantes.DE_VITESSE1, new De(TypeDe.vitesse, 1));
		this.listDes.put(Constantes.DE_VITESSE2, new De(TypeDe.vitesse, 2));
		this.listDes.put(Constantes.DE_VITESSE3, new De(TypeDe.vitesse, 3));
		this.listDes.put(Constantes.DE_VITESSE4, new De(TypeDe.vitesse, 4));
		this.listDes.put(Constantes.DE_VITESSE5, new De(TypeDe.vitesse, 5));
		this.listDes.put(Constantes.DE_GAZ1, new De(TypeDe.gaz, -1));
		this.listDes.put(Constantes.DE_GAZ2, new De(TypeDe.gaz, -1));
		
		reinitialiserDes();
	}

	public void reinitialiserDes() {
		for(Entry<String, De> entry : listDes.entrySet()) {
		    //String key = entry.getKey();
		    De de = entry.getValue();
		    de.setDisponible(true); 
		    de.setUtilise(false);
		}
	}

	public List<String> getListeDesDisponibles(int vitesseCourante, Cellule cellule, Cellule celluleSuivante) {
		
		// retrait des d��s selon la vitesse courante
		switch(vitesseCourante) {
			case 0:
				this.listDes.get(Constantes.DE_VITESSE1).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE2).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE3).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE4).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE5).setDisponible(false);
				this.listDes.get(Constantes.DE_GAZ1).setDisponible(false);
				this.listDes.get(Constantes.DE_GAZ2).setDisponible(false);
			break;
			case 1:
				this.listDes.get(Constantes.DE_VITESSE1).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE2).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE3).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE4).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE5).setDisponible(false);
				this.listDes.get(Constantes.DE_GAZ1).setDisponible(true);
				this.listDes.get(Constantes.DE_GAZ2).setDisponible(true);
			break;
			case 2:
				this.listDes.get(Constantes.DE_VITESSE1).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE2).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE3).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE4).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE5).setDisponible(false);
				this.listDes.get(Constantes.DE_GAZ1).setDisponible(true);
				this.listDes.get(Constantes.DE_GAZ2).setDisponible(true);
			break;
			case 3:
				this.listDes.get(Constantes.DE_VITESSE1).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE2).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE3).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE4).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE5).setDisponible(false);
				this.listDes.get(Constantes.DE_GAZ1).setDisponible(true);
				this.listDes.get(Constantes.DE_GAZ2).setDisponible(true);
			break;
			case 4:
				this.listDes.get(Constantes.DE_VITESSE1).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE2).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE3).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE4).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE5).setDisponible(true);
				this.listDes.get(Constantes.DE_GAZ1).setDisponible(true);
				this.listDes.get(Constantes.DE_GAZ2).setDisponible(true);
			break;
			case 5:
				this.listDes.get(Constantes.DE_VITESSE1).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE2).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE3).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE4).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE5).setDisponible(false);
				this.listDes.get(Constantes.DE_GAZ1).setDisponible(true);
				this.listDes.get(Constantes.DE_GAZ2).setDisponible(true);
			break;
		}
		
		// retrait des d��s si limitation de vitesse sur la cellule
		if(celluleSuivante != null) {
			switch(celluleSuivante.getLimitationVitesse()) {
			case 2:
				this.listDes.get(Constantes.DE_VITESSE1).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE2).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE3).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE4).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE5).setDisponible(false);
			break;
			case 3:
				this.listDes.get(Constantes.DE_VITESSE1).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE2).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE3).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE4).setDisponible(false);
				this.listDes.get(Constantes.DE_VITESSE5).setDisponible(false);
			break;
			case 4:
				this.listDes.get(Constantes.DE_VITESSE1).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE2).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE3).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE4).setDisponible(true);
				this.listDes.get(Constantes.DE_VITESSE5).setDisponible(false);
			break;
			}
			if(celluleSuivante.getLimitationVitesse() < vitesseCourante){
				this.listDes.get(Constantes.DE_GAZ1).setDisponible(false);
				this.listDes.get(Constantes.DE_GAZ2).setDisponible(false);
			}
			
			
		}
		
		// retrait des d��s si la cellule suivante contient d��j�� deux voitures
		if(celluleSuivante != null && (celluleSuivante.getNombreVoitures() == 2)){
			this.listDes.get(Constantes.DE_VITESSE1).setDisponible(false);
			this.listDes.get(Constantes.DE_VITESSE2).setDisponible(false);
			this.listDes.get(Constantes.DE_VITESSE3).setDisponible(false);
			this.listDes.get(Constantes.DE_VITESSE4).setDisponible(false);
			this.listDes.get(Constantes.DE_VITESSE5).setDisponible(false);
			this.listDes.get(Constantes.DE_GAZ1).setDisponible(false);
			this.listDes.get(Constantes.DE_GAZ2).setDisponible(false);

		}
		
		List<String> list = new ArrayList<String>();
		for(Entry<String, De> entry : listDes.entrySet()) {
		    String key = entry.getKey();
		    De de = entry.getValue();
		    if(de.getDisponible() && !de.getUtilise()){
		    	list.add(key);
		    }
		}
		return list;
	}

	/**
	 * @return the listDes
	 */
	public HashMap<String, De> getListDes() {
		return listDes;
	}	
	
}
