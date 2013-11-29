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
	
	public boolean ajouterParticipant(final UtilisateurMock utilisateur, ModelAndView modele) throws Exception {
		if( ! isDemarre()) {
			Joueur joueur = new Joueur();
			joueur.setIdentifiant(utilisateur.getIdentifiant());
			listeJoueurs.add(joueur);
			
			modele.addObject("joueur", joueur);
			
//			 TODO : mettre en session l'identifiant de l'utilisateur pour pouvoir identifier à qui de jouer par la suite ?
//			final HttpSession session = request.getSession();
//			session.setAttribute("joueur", joueur);
			
			System.out.println("[JEU EN PREPARATION] Actuellement " + listeJoueurs.size() + " joueurs ! ");
			return listeJoueurs.size() == Constantes.NOMBRE_JOUEURS;
		} else {
			throw new Exception("Le jeu a déjà démarré !");
		}
	}
	

	public void demarrerJeu() {
		System.out.println("[DEMARRAGE DU JEU]");
		
		isDemarre = true;
		joueurCourant = 1;

		// ordre aléatoire de jeu au lancement du jeu.
		Collections.shuffle(listeJoueurs);
		
		
		// TODO avertir (en AJAX ?) chaque participant que la partie va commencer
		
	}
	
	@RequestMapping("/partie")
	public String deroulerPartie(Model modele, @ModelAttribute Joueur joueur) {
		
//		HttpSession session = request.getSession();
		
//		Joueur joueur = (Joueur) session.getAttribute("utilisateur");
		System.out.println("Le joueur " + joueur.getIdentifiant() + " a rafraichit l'état de la partie");
		
		modele.addAttribute("isDemarre", isDemarre);
		modele.addAttribute("joueurCourant", joueurCourant);
		
		return "partie";
	}
	
	@RequestMapping("/rejoindre")
	// ajouter response et mettre dans la response un attribut pour identifier joueurs ?!
	public ModelAndView simulerNouveauParticipant() {
		UtilisateurMock utilisateur = new UtilisateurMock();
		utilisateur.setIdentifiant(cpt++);
		
		ModelAndView modele = new ModelAndView("joueurAjoute");
		
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
	
	public boolean isDemarre() {
		return isDemarre;
	}

	public void setDemarre(boolean isDemarre) {
		this.isDemarre = isDemarre;
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
