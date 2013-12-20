package manhattan.plateau;

import java.util.TreeMap;

import manhattan.interfaces.GetResultInterface;

/**
 * @author drubay
 */
public class Quartier {
	private Batiment[][] quartier = new Batiment[3][3];
	
	public Quartier() {
		for(int i=0;i<quartier.length;i++){
			for(int j=0;j<quartier[i].length;j++){
				quartier[i][j]=new Batiment();
			}
		}
	}
	
	/**
	 * Renvoie le joueur qui a la majorité. null si au moins deux joueurs se la partage.
	 * @return
	 */
	public int majorite(){
		TreeMap<Integer,Integer> compte = new TreeMap<Integer,Integer>();
		for(int i=0;i<quartier.length;i++){
			for(int j=0;j<quartier[i].length;j++){
				compte.put(quartier[i][j].appartientA(),compte.get(quartier[i][j].appartientA())+1);
			}
		}
		
		//On cherche le meilleur
		if(
				compte.get(0)>compte.get(1) &&
				compte.get(0)>compte.get(2) &&
				compte.get(0)>compte.get(3)
				)
			return 0;
		else if(
				compte.get(1)>compte.get(0) &&
				compte.get(1)>compte.get(2) &&
				compte.get(1)>compte.get(3)
				)
			return 1;
		else if(
				compte.get(2)>compte.get(0) &&
				compte.get(2)>compte.get(1) &&
				compte.get(2)>compte.get(3)
				)
			return 2;
		else if(
				compte.get(3)>compte.get(0) &&
				compte.get(3)>compte.get(1) &&
				compte.get(3)>compte.get(2)
				)
			return 3;
		//Si deux joueurs ont le même résultat (et le max), on ignore la majorité
		else return -1;
	}
	
	/**
	 * Renvoie, via l'interface, le joueur et la taille de sa plus grande tour.
	 * Si deux joueurs ont la même taille de tour, on renvoie -1 pour le joueur et -1 pour la taille.
	 * @param getResultInterface
	 */
	public void plusGrand(GetResultInterface getResultInterface){
		int joueur = -1;
		int max = 0;
		for(int i=0;i<quartier.length;i++){
			for(int j=0;j<quartier[i].length;j++){
				max = Math.max(max, quartier[i][j].getTaille());
				if(max==-1 && max==quartier[i][j].getTaille()){
					joueur=-1;
					max=-1;
				}else
					joueur=quartier[i][j].appartientA();
			}
		}
		getResultInterface.onResult(joueur,max);
	}
	
	/**
	 * Ajoute un étage à un batiment en fonction de ses coordonnées dans le quartier
	 * @param x
	 * @param y
	 * @return Faux si l'étage n'a pas pu être construit
	 */
	public boolean ajouterEtages(int joueur, int nombre, int x, int y){
		return quartier[x][y].ajouterEtages(joueur, nombre);
	}
}
