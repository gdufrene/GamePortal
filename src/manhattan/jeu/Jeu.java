package manhattan.jeu;

import java.util.ArrayList;

import manhattan.cartes.Pioche;
import manhattan.plateau.Quartier;

public class Jeu {
	private ArrayList<Quartier> quartiers = new ArrayList<Quartier>();
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	private int currentPlayer = 1;// TODO
	private int nbJoueurs = 4;

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

	public void start(TourListener tourListener) {
		for (int tour = 0; tour < 6; tour++) {
			tourListener.nextTurn(tour);
			new Tour(tourListener, nbJoueurs, joueurs, quartiers);
		}
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
		currentPlayer = j;
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
}
