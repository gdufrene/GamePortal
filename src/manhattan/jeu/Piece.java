package manhattan.jeu;

public class Piece {
	private int nombre = 1;
	
	public Piece(int nombre){
		this.nombre=nombre;
	}
	
	public int nombre(){
		return this.nombre;
	}
}