package fr.eservice.portal.score;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implémentation de l'interface de gestion des scores.
 * @author rally-devteam
 */
@Repository
public class ScoreDAO implements IScore {

	private static int staticIdentifiant = 10;
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void enregistrerScores(int identifiantJeu, int identifiantSession,
			List<ScoreBean> scores) {
		
		System.out.println("[DEBUT] Sauvegarde des scores");
		
		sessionFactory.getCurrentSession().beginTransaction();
		try {
			for(final ScoreBean score : scores) {
				ScoreDO scoreDO = alimenterDo(score, identifiantJeu, identifiantSession);
				sessionFactory.getCurrentSession().save(scoreDO);
			}
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (HibernateException exception) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
		
		System.out.println("[FIN] Sauvegarde des scores");

	}

	@Override
	public List<ScoreBean> recupererScores(int identifiantJeu,
			int identifiantSession) {
		List<ScoreBean> resultat = new ArrayList<ScoreBean>();
		
		Query requete = sessionFactory.getCurrentSession().createSQLQuery(
				"from ScoreDO as s where identifiantJeu = :idJeu and identifiantSession = :idSession order by placement");
		requete.setParameter("idJeu", identifiantJeu);
		requete.setParameter("idSession", identifiantSession);
		
		List<?> liste = requete.list();
		
		for(final Object score : liste) {
			ScoreBean scoreBean = alimenterBean((ScoreDO) score);
			resultat.add(scoreBean);
		}
		
		return resultat;
	}
	
	/**
	 * Alimente un {@link ScoreBean} à partir d'un {@link ScoreDO}.
	 * @param scoreDo
	 * @return scoreBean
	 */
	private ScoreBean alimenterBean(ScoreDO score) {
		ScoreBean scoreBean = new ScoreBean();
		
		scoreBean.setIdentifiantUtilisateur(score.getIdentifiantUtilisateur());
		scoreBean.setPlacement(score.getPlacement());
		scoreBean.setScore(score.getScore());
		
		return scoreBean;
	}

	/**
	 * Alimente un {@link ScoreDO} pour sauvegarde en base.
	 * @param score {@link ScoreBean}
	 * @param identifiantJeu
	 * @param identifiantSession
	 * @return {@link ScoreDO}
	 */
	private ScoreDO alimenterDo(ScoreBean score, int identifiantJeu, int identifiantSession) {
		ScoreDO scoreDO = new ScoreDO();
		
		scoreDO.setIdentifiant(staticIdentifiant++);
		scoreDO.setIdentifiantUtilisateur(score.getIdentifiantUtilisateur());
		scoreDO.setPlacement(score.getPlacement());
		scoreDO.setScore(score.getScore());
		scoreDO.setIdentifiantJeu(identifiantJeu);
		scoreDO.setIdentifiantSession(identifiantSession);
		
		return scoreDO;
	}

}
