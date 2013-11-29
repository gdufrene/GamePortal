package fr.eservice.rallyman.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.eservice.rallyman.model.Constantes;
import fr.eservice.rallyman.model.entite.Carte;
import fr.eservice.rallyman.model.entite.Des;
import fr.eservice.rallyman.model.entite.Joueur;
import fr.eservice.rallyman.model.helper.CarteHelper;

/**
 * Contrôleur du jeu Rallyman
 * @author rally-devteam
 */
@Controller
@SessionAttributes({"joueur"})
public class JeuController /* implements interface pour pattern strategy */ {

	protected List<Joueur> listeJoueurs = new ArrayList<Joueur>();
	protected List<Des> listeDe  = new ArrayList<Des>();
	protected Carte carte;
	protected int courseCourante;
	protected boolean isDemarre = false;
	protected int joueurCourant;
	
	static int cpt = 1; // à supprimer plus tard
	
	public void demarrerJeu() {
		System.out.println("[DEMARRAGE DU JEU]");
		
		isDemarre = true;
		joueurCourant = 1;
		courseCourante = 1;
		
		// ordre aléatoire de jeu au lancement du jeu.
		Collections.shuffle(listeJoueurs);
		
		// initialiastion de la carte
		carte = CarteHelper.initialiserCarte1();
		
		
	}
	
	@RequestMapping("/rallyman-partie")
	// TODO APPELER SUR POUR CHAQUE CLIENT EN AJAX CETTE METHODE TOUTES LES 5 SECONDES
	public String deroulerPartie(Model modele, @ModelAttribute Joueur joueur) {
		
		System.out.println("Le joueur " + joueur.getIdentifiant() + " a rafraichit l'état de la partie");
		
		
		
		
		
		modele.addAttribute("isDemarre", isDemarre);
		modele.addAttribute("joueurCourant", joueurCourant);
		
		return "rallyman/partie";
	}
	
	@RequestMapping("/rallyman-rejoindre")
	public ModelAndView simulerNouveauParticipant() {
		UtilisateurMock utilisateur = new UtilisateurMock();
		utilisateur.setIdentifiant(cpt++);
		
		ModelAndView modele = new ModelAndView("rallyman/joueurAjoute");
		
		boolean resultat = false;
		try {
			resultat = ajouterParticipant(utilisateur, modele);
		} catch (Exception e) {
			// osef pour le moment
		}
		
		if (resultat) {
			demarrerJeu();
		}
		
		return modele;
	}
	
	public boolean ajouterParticipant(final UtilisateurMock utilisateur, ModelAndView modele) throws Exception {
		if( ! isDemarre) {
			Joueur joueur = new Joueur();
			joueur.setIdentifiant(utilisateur.getIdentifiant());
			listeJoueurs.add(joueur);
			
			modele.addObject("joueur", joueur);
			
			System.out.println("[JEU EN PREPARATION] Actuellement " + listeJoueurs.size() + " joueurs ! ");
			return listeJoueurs.size() == Constantes.NOMBRE_JOUEURS;
		} else {
			throw new Exception("Le jeu a déjà démarré !");
		}
	}
	
	// classe "bouchon" temporaire tant qu'on relie pas à la base du portail
	class UtilisateurMock {
		protected int identifiant;

		public int getIdentifiant() {
			return identifiant;
		}

		public void setIdentifiant(int identifiant) {
			this.identifiant = identifiant;
		}
		
		
	}
	
}
