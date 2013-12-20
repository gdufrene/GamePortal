package manhattan.cartes;

public class Carte {
	private int x = 0;
	private int y = 0;

	public Carte(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}
	
	@Override
	public String toString() {
		return String.valueOf(x)+String.valueOf(y);
	}
}
