package manhattan.jeu;

import java.util.ArrayList;

import manhattan.cartes.Carte;

/**
 * @author drubay
 */
public class Joueur {
	private ArrayList<Carte> main = new ArrayList<Carte>();
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	private ArrayList<Piece> piecesRestantes = new ArrayList<Piece>();

	public Joueur() {
		for (int i = 0; i < 12; i++) {
			piecesRestantes.add(new Piece(i % 3 + 1));
		}
	}

	public void ajouterCarteEnMain(Carte carte) {
		main.add(carte);
	}

	public void enleverCarteEnMain(Carte carte) {
		main.remove(main.indexOf(carte));
	}

	public void ajouterPieceEnMain(Piece piece) {
		pieces.add(piece);
	}

	public void enleverPieceEnMain(Piece piece) {
		pieces.remove(pieces.indexOf(piece));
	}

	public void ajouterPieceReserve(Piece piece) {
		piecesRestantes.add(piece);
	}

	public void enleverPieceReserve(Piece piece) {
		piecesRestantes.remove(piecesRestantes.indexOf(piece));
	}

	public ArrayList<Carte> listerCartesEnMain() {
		return main;
	}

	public ArrayList<Piece> listerPiecesEnMain() {
		return pieces;
	}

	public ArrayList<Piece> listerPiecesDispo() {
		return piecesRestantes;
	}
}
