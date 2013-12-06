package fr.eservice.rallyman.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	protected Des des;
	protected Carte carte;
	protected int specialeCourante;
	protected boolean isDemarre = false;
	protected boolean isTermine = false;
	protected Joueur joueurCourant;
	
	static int cpt = 1; // à supprimer plus tard
	
	public void demarrerJeu() {
		System.out.println("[DEMARRAGE DU JEU]");
		
		isDemarre = true;
		specialeCourante = 1;
		
		// ordre aléatoire de jeu au lancement du jeu.
		Collections.shuffle(listeJoueurs);
		joueurCourant = listeJoueurs.get(0);
		
		// initialiastion de la carte
		carte = CarteHelper.initialiserCarte1();
		des = new Des();
		des.reinitialiserDes();
		
	}
	
	@RequestMapping("/rallyman-partie")
	public String deroulerPartie(@RequestParam(required=false) String deJoue, @RequestParam(required=false) String action, Model modele, @ModelAttribute Joueur joueur) {
		
		System.out.println("Le joueur " + joueur.getIdentifiant() + " a rafraichit l'état de la partie");

		if(isDemarre) {
			// utilisateur en cours
			if(joueur.getIdentifiant() == joueurCourant.getIdentifiant()) {
				
				if("passerSonTour".equals(action)) {
					passerJoueurSuivant(joueur);
				} else if("jouer".equals(action)) {
					if(deJoue != null && ! deJoue.isEmpty()) {
						// TODO gérer les voitures sur même case
						joueur.setAvancement(joueur.getAvancement() + 1);
						
						// le jour a-t-il fini sa manche ?
						if (joueur.getAvancement() == carte.getListeCellules().size()) {
							enregistrerFinManche(joueur);
						} else {
							calculerNouvelleVitesse(deJoue, joueur);
						}
					}
					
				}
				// vérification qu'il reste encore des dés
				verifierActionPossible(modele, joueur);
			}
		}
		
		// transmission à la vue des informations
		modele.addAttribute("carte", carte);
		modele.addAttribute("joueurs", listeJoueurs);
		modele.addAttribute("isDemarre", isDemarre);
		modele.addAttribute("isTermine", isTermine);
		modele.addAttribute("specialeCourante", specialeCourante);
		modele.addAttribute("joueurCourant", joueurCourant.getIdentifiant());

		return "rallyman/partie";
	}

	private void verifierActionPossible(Model modele, Joueur joueur) {
		List<String> desDisponibles = des.getListeDesDisponibles(joueur.getVoiture().getVitesseCourante(), carte.getListeCellules().get(joueur.getAvancement()), carte.getListeCellules().get(joueur.getAvancement()+1));
		if(desDisponibles != null && !desDisponibles.isEmpty()) {
			modele.addAttribute("des", desDisponibles);
		} else {
			passerJoueurSuivant(joueur);
		}
	}

	private void enregistrerFinManche(Joueur pJoueur) {
		System.out.println("Le joueur " + pJoueur.getIdentifiant() + " a fini la manche en " + pJoueur.getTemps() + "secondes !");
		
		boolean finiPourTous = true;
		
		// si tous les joueurs ont fini la spéciale
		for(final Joueur joueur : listeJoueurs) {
			if(joueur.getAvancement() != carte.getListeCellules().size()) {
				finiPourTous = false;
				break;
			}
		}
		
		if (finiPourTous) {
			if(specialeCourante == Constantes.NOMBRE_COURSES) {
				// fin du jeu
				isTermine = true;
			} else {
				initialiserNouvelleSpeciale();
			}
		}
	}

	/**
	 * Initialise le plateau et les joueurs pour démarrer la nouvelle spéciale.
	 */
	private void initialiserNouvelleSpeciale() {
		
		System.out.println("Démarrage d'une nouvelle spéciale !");
		
		specialeCourante++;
		
		// réinitialisation des dés
		des.reinitialiserDes();
		
		// réinitialisation des joueurs
		for(final Joueur joueur : listeJoueurs) {
			joueur.setAvancement(0);
			joueur.getVoiture().setVitesseCourante(0);
		}
		
		// réinitilisation du plateau
		carte.reinitialiser();
	}

	/**
	 * Calcul de la nouvelle vitesse courante du joueur.
	 * @param deJoue
	 * @param joueur
	 */
	private void calculerNouvelleVitesse(String deJoue, Joueur joueur) {
		int nouvelleVitesse = -1;
		if(deJoue.equals(Constantes.DE_VITESSE1)) {
			nouvelleVitesse = 1;
		} else if(deJoue.equals(Constantes.DE_VITESSE2)) {
			nouvelleVitesse = 2;
		} else if(deJoue.equals(Constantes.DE_VITESSE3)) {
			nouvelleVitesse = 3;
		} else if(deJoue.equals(Constantes.DE_VITESSE4)) {
			nouvelleVitesse = 4;
		} else if(deJoue.equals(Constantes.DE_VITESSE5)) {
			nouvelleVitesse = 5;
		}
		
		des.supprimerDe(deJoue);
		
		if(nouvelleVitesse != -1) {
			joueur.getVoiture().setVitesseCourante(nouvelleVitesse);
			System.out.println("Nouvelle vitesse du joueur " + joueur.getIdentifiant() + " : " + nouvelleVitesse);
		}
	}
	

	protected void passerJoueurSuivant(Joueur joueur) {
		
		// on enregistre le temps passé durant le tour
		enregistrerTempsDuTour(joueur);
		
		// TODO ne pas rendre la main à un utilisateur qui a déjà fini la spéciale
		int index = listeJoueurs.indexOf(joueurCourant);
		
		if (index == (listeJoueurs.size() - 1)) {
			index = 0;
		} else {
			index++;
		}
		
		joueurCourant = listeJoueurs.get(index);
		
		des.reinitialiserDes();
	}
	
	private void enregistrerTempsDuTour(Joueur joueur) {
		// TODO comptabiliser le temps passé sur le parcours
		
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
