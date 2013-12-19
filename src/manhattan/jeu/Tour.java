package manhattan.jeu;

import java.util.ArrayList;

import manhattan.cartes.Carte;
import manhattan.cartes.Pioche;
import manhattan.plateau.Quartier;

public class Tour {
	public Tour(TourListener tourListener, int nbJoueurs, ArrayList<Joueur> joueurs, ArrayList<Quartier> quartiers){
		for(int joueur=0;joueur<nbJoueurs;joueur++){
			tourListener.choisirElementsPourLeTour(joueurs.get(joueur));
		}
			
		for(int joueur=0;joueur<nbJoueurs;joueur++){
			tourListener.nextPlayer(joueur);
			Carte carte = tourListener.choisirCarte(joueurs.get(joueur));
			Piece piece = tourListener.choisirPiece(joueurs.get(joueur));
			Quartier quartier = tourListener.choisirQuartier(quartiers);
			ajouterEtages(joueur, piece.nombre(), quartier, carte.x(), carte.y());
			piocherCarte(joueurs.get(joueur));
		}
		calculerScore();
	}
	
	/**
	 * Ajoute un ou plusieurs étages à un batiment
	 * @param joueur Le joueur qui ajoute
	 * @param nombre Le nombre d'étages à ajouter
	 * @param quartier Le quartier dans lequel ajouter
	 * @param batimentX La coordonnée X du bâtiment
	 * @param batimentY La coordonnée Y du bâtiment
	 * @return Faux si la construction a échoué (l'adversaire possède plus d'étages)
	 */
	public boolean ajouterEtages(int joueur, int nombre, Quartier quartier, int batimentX, int batimentY){
		if(quartier.ajouterEtages(joueur, nombre, batimentX, batimentY)){
			return true;
		}else{
			return false;
		}
	}
	
	public void piocherCarte(Joueur joueur){
		joueur.ajouterCarteEnMain(Pioche.piocher());
	}
	
	public void calculerScore(){
		//TODO
	}
}
