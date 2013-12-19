package manhattan.jeu;

import org.springframework.stereotype.Component;

@Component
public class JoueurProvider {
	private Jeu jeu;
	
	public JoueurProvider() {
		System.out.println("Test");
		jeu = new Jeu(4);
	}
	
	public Jeu getJeu() {
		return jeu;
	}
}
