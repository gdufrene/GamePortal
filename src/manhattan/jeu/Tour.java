package manhattan.jeu;

import java.util.ArrayList;

import manhattan.cartes.Carte;
import manhattan.cartes.Pioche;
import manhattan.plateau.Quartier;

public class Tour {
	/**
	 * Ajoute un ou plusieurs étages à un batiment
	 * @param joueur Le joueur qui ajoute
	 * @param nombre Le nombre d'étages à ajouter
	 * @param quartier Le quartier dans lequel ajouter
	 * @param batimentX La coordonnée X du bâtiment
	 * @param batimentY La coordonnée Y du bâtiment
	 * @return Faux si la construction a échoué (l'adversaire possède plus d'étages)
	 */
	public static boolean ajouterEtages(int joueur, int nombre, Quartier quartier, int batimentX, int batimentY){
		if(quartier.ajouterEtages(joueur, nombre, batimentX, batimentY)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void piocherCarte(Joueur joueur){
		joueur.ajouterCarteEnMain(Pioche.piocher());
	}
	
	public static void jouer(ArrayList<Joueur> joueurs, int joueur, Quartier quartier, Piece piece, Carte carte){
		ajouterEtages(joueur, piece.nombre(), quartier, carte.x(), carte.y());
		piocherCarte(joueurs.get(joueur));
	}


}
