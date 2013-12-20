package manhattan.cartes;

import java.util.ArrayList;

/**
 * @author drubay
 */
public class Pioche {
	private static ArrayList<Carte> pioche = new ArrayList<Carte>();

	public static void init() {
		for (int i = 0; i < 45; i++) {
			pioche.add(new Carte((int) (i / 3) % 3, i % 3));
		}
	}

	public static Carte piocher() {
		if (pioche.size() > 0)
			try {
				return pioche.get(0);
			} finally {
				pioche.remove(0);
			}
		else
			return null;
	}
}
