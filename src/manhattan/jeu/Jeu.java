package manhattan.jeu;

import java.util.ArrayList;

import manhattan.cartes.Carte;
import manhattan.cartes.Pioche;
import manhattan.plateau.Quartier;

public class Jeu {
	private ArrayList<Quartier> quartiers = new ArrayList<Quartier>();
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private int currentPlayer = 1;// TODO
	private int nbJoueurs = 4;
	private int tour = 0;

	public Jeu(int nbJoueurs) {
		for (int i = 0; i < 6; i++) {
			quartiers.add(new Quartier());
		}

		// On initialise
		Pioche.init();
		this.nbJoueurs = setNombreDeJoueurs();
		quiCommence(nbJoueurs);
		distribuerCartes();
	}

	/**
	 * Renvoie le numéro du tour qui débute
	 * @return
	 */
	public int nextTurn(){
		return tour++;
	}
	
	/**
	 * Renvoie le numéro du joueur qui débute son tour
	 * @return
	 */
	public int nextPlayer(){
		return currentPlayer++;
	}
	
	/**
	 * Liste les pièces en stock pour le joueur "joueur"
	 * @return ArrayList<Piece>
	 */
	public ArrayList<Piece> getElementsPourLeTour(int joueur){
		return joueurs.get(joueur).listerPiecesDispo();
	}
	
	/**
	 * Liste les cartes en main pour le joueur "joueur"
	 * @return ArrayList<Carte>
	 */
	public ArrayList<Carte> getCartesPourLeTour(int joueur){
		return joueurs.get(joueur).listerCartesEnMain();
	}
	
	/**
	 * Renvoie la liste des quartiers
	 * @return
	 */
	public ArrayList<Quartier> getQuartiers(){
		return quartiers;
	}
	
	/**
	 * Joue une pièce dans un quartier en fonction d'une carte
	 * @param joueur
	 * @param quartier
	 * @param carte
	 * @param piece
	 */
	public void jouerCartePiece(int joueur, Quartier quartier, Carte carte, Piece piece){
		Tour.jouer(joueurs, joueur, quartier, piece, carte);
	}
	
	/**
	 * Détermine le nombre de joueurs
	 * 
	 * @return
	 */
	public int setNombreDeJoueurs() {
		int nb = 4;
		for (int i = 0; i < nb; i++) {
			joueurs.add(new Joueur());
		}
		return 4;
	}

	/**
	 * Détermine qui commence
	 * 
	 * @param nbJoueurs
	 *            Le nombre de joueurs
	 */
	public void quiCommence(int nbJoueurs) {
		int j = (int) Math.floor(Math.random() * nbJoueurs);
		setCurrentPlayer(j);
	}

	/**
	 * Distribue les cartes
	 */
	public void distribuerCartes() {
		for (int i = 0; i < joueurs.size(); i++) {
			for (int c = 0; c < 6; c++)
				joueurs.get(i).ajouterCarteEnMain(Pioche.piocher());
		}
	}
	
	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}
