package manhattan;

import java.util.ArrayList;
import java.util.Scanner;

import manhattan.cartes.Carte;
import manhattan.jeu.Jeu;
import manhattan.jeu.Joueur;
import manhattan.jeu.Piece;
import manhattan.jeu.TourListener;
import manhattan.plateau.Quartier;

public class Main {
	private static Jeu jeu = new Jeu(4);
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		jeu.start(new TourListener() {
			@Override
			public Quartier choisirQuartier(ArrayList<Quartier> quartiers) {
				// TODO à refaire pour les graphismes
				int val = -1;

				// On demande le quartier
				do {
					System.out.println("Quel quartier ?");
					try {
						val = sc.nextInt();
					} catch (Exception e) {
						val = -1;
					}
				} while (val < 0 || val >= quartiers.size());

				// Et on le renvoie
				return quartiers.get(val);
			}

			@Override
			public Piece choisirPiece(Joueur joueur) {
				// TODO à refaire pour les graphismes
				int val = -1;

				// On demande la pièce
				do {
					System.out.println("Quelle pièce ?");
					try {
						val = sc.nextInt();
						System.out.println(val + "");
					} catch (Exception e) {
						val = -1;
					}
				} while (val < 0 || val >= joueur.listerPiecesEnMain().size());

				// Et on la renvoie
				return joueur.listerPiecesEnMain().get(val);
			}

			@Override
			public Carte choisirCarte(Joueur joueur) {
				// TODO à refaire pour les graphismes
				int val = -1;

				// On demande la carte
				do {
					System.out.println("Quelle carte ?");
					try {
						val = sc.nextInt();
					} catch (Exception e) {
						val = -1;
					}
				} while (val < 0 || val >= joueur.listerCartesEnMain().size());

				// Et on la renvoie
				return joueur.listerCartesEnMain().get(val);
			}

			@Override
			public void choisirElementsPourLeTour(Joueur joueur) {
				// TODO à faire
				for (int i = 0; i < 4; i++) {
					if (joueur.listerPiecesDispo().size() > 0) {
						joueur.ajouterPieceEnMain(joueur.listerPiecesDispo().get(0));
						joueur.listerPiecesDispo().remove(0);
					}
				}
			}

			@Override
			public void nextPlayer(int joueur) {
				// TODO à refaire pour les graphismes
				System.out.println("Joueur " + joueur);
			}

			@Override
			public void nextTurn(int turn) {
				System.out.println("Tour " + turn);
			}
		});
	}
}
