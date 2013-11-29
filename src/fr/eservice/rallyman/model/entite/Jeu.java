package fr.eservice.rallyman.model.entite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.eservice.rallyman.model.Constantes;

/**
 * TODO à supprimer car tout est balancé dans le controllr ?!
 * Modélisation du jeu Rallyman.
 * @author rally-devteam
 */
public class Jeu {

	protected List<Joueur> listeJoueurs;
	
	protected List<Des> listeDe;
	
	protected Carte carte;
	
	protected int courseCourante;
	
	protected boolean isDemarre;
	
	public Jeu() {
		listeJoueurs = new ArrayList<Joueur>();
		listeDe = new ArrayList<Des>();
		isDemarre = false;
	}
	
	public void demarrerJeu() {
		System.out.println("[DEMARRAGE DU JEU]");
		
		isDemarre = true;
		// ordre aléatoire de jeu au lancement du jeu.
		Collections.shuffle(listeJoueurs);
		
		// avertir chaque participant que la partie va commencer
		
		
	}
	
	public boolean ajouterJoueur(Joueur joueur) {
		listeJoueurs.add(joueur);
		System.out.println("[JEU EN PREPARATION] Actuellement " + listeJoueurs.size() + " joueurs ! ");
		return listeJoueurs.size() == Constantes.NOMBRE_JOUEURS;
	}

	public boolean isDemarre() {
		return isDemarre;
	}

	public void setDemarre(boolean isDemarre) {
		this.isDemarre = isDemarre;
	}
	
}
