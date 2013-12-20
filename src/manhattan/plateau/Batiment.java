package manhattan.plateau;

import java.util.ArrayList;

/**
 * @author drubay
 */
public class Batiment {
	private ArrayList<Integer> liste = new ArrayList<Integer>();
	
	/**
	 * Ajoute un morceau au batiment
	 * @param joueur
	 * @param nombre Le nombre d'étages
	 */
	public boolean ajouterEtages(int joueur, int nombre){
		//Si le joueur a moins de morceaux que le joueur auquel la tour appartient, cela ne peut pas fonctionner
		if(getNombreMorceaux(joueur)+nombre<getNombreMorceaux(appartientA()))
			return false;
		//Sinon on ajoute les étages
		for(int i=0;i<nombre;i++)
			liste.add(joueur);
		return true;
	}
	
	/**
	 * Renvoie le nombre d'étages appartenant au joueur demandé
	 * @param joueur
	 * @return Le nombre d'étages appartenant au joueur demandé
	 */
	public int getNombreMorceaux(int joueur){
		int ret = 0;
		for(int i=liste.size()-1;i>=0;i--)
			if(liste.get(i)==joueur)
				ret++;
		
		return ret;
	}
	
	/**
	 * Renvoie le joueur à qui appartient le batiment
	 * @return
	 */
	public int appartientA(){
		try {
			return liste.get(liste.size()-1);
		}catch(Exception e){
			return Integer.MAX_VALUE;
		}
	}
	
	/**
	 * Renvoie la taille du bâtiment
	 * @return
	 */
	public int getTaille(){
		return liste.size();
	}
}
