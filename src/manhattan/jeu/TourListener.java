package manhattan.jeu;

import java.util.ArrayList;

import manhattan.cartes.Carte;
import manhattan.plateau.Quartier;

public interface TourListener {
	public void choisirElementsPourLeTour(Joueur joueur);
	public Carte choisirCarte(Joueur joueur);
	public Piece choisirPiece(Joueur joueur);
	public Quartier choisirQuartier(ArrayList<Quartier> quartiers);
	public void nextPlayer(int joueur);
	public void nextTurn(int turn);
}
