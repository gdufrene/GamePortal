package fr.eservice.portal.sessions;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.eservice.portal.Person;

@Controller
public class SessionTools {
	
	public static HashMap<String, ArrayList<Person>> joueurs = new HashMap<String, ArrayList<Person>>();
	
	@Autowired
	Person myself;
	
	@RequestMapping( value= "/choix_jeu", method=RequestMethod.GET )
	public String form(HttpSession httpsession, Model model) {
		
		return "choix_jeu";
		
	}
	
	@RequestMapping( value= "/check_joueurs", method=RequestMethod.GET, params="jeu" )
	@ResponseBody
	public String check_joueur(@RequestParam("jeu") String jeu) {
		if (joueurs.containsKey(jeu) && !joueurs.get(jeu).isEmpty())
			return "Joindre";
		else
			return "Jouer";
	}
	
	@RequestMapping( value= "/connexion", method=RequestMethod.GET, params="nom" )
	@ResponseBody
	public String connexion(@RequestParam("nom") String nom) {
		myself = new Person();
		myself.setName(nom);
		return nom;
	}
	
	@RequestMapping( value= "/myself", method=RequestMethod.GET)
	@ResponseBody
	public String myself(HttpSession httpsession) {
		return (String)httpsession.getAttribute("myself");
	}
	
	@RequestMapping( value= "/setMyself", method=RequestMethod.GET, params="nom")
	@ResponseBody
	public String setMyself(HttpSession httpsession, @RequestParam("nom") String nom) {
		httpsession.setAttribute("myself", nom);
		return nom;
	}
	
	@RequestMapping( value= "/attente", method=RequestMethod.GET, params={"jeu", "nom", "ademarre"})
	public String attente(HttpSession httpsession, @RequestParam("jeu") String jeu, @RequestParam("nom") String nom, @RequestParam("ademarre") String ademarre) {
		ArrayList<Person> p;
		if (joueurs.containsKey(jeu)) {
			p = joueurs.get(jeu);
		} else {
			p = new ArrayList<Person>();
			joueurs.put(jeu,p);
		}
		Person person = new Person();
		person.setName(nom);
		p.add(person);
		joueurs.put(jeu, p);
		
		return "attente";
	}
	
	@RequestMapping( value= "/check_attente", method=RequestMethod.GET, params="jeu")
	@ResponseBody
	public String check_attente(HttpSession httpsession, @RequestParam("jeu") String jeu) {
		ArrayList<Person> p;
		String res = "";
		if (joueurs.containsKey(jeu)) {
			p = joueurs.get(jeu);
			for (Person person : p) {
				res += person.getName()+";";
			}
			return res;
		}
		return "";
	}
	
	@RequestMapping( value= "/joueur_quit", method=RequestMethod.GET, params={"jeu", "nom"})
	@ResponseBody
	public String joueur_quit(@RequestParam("jeu") String jeu, @RequestParam("nom") String nom) {
		ArrayList<Person> p;
		if (joueurs.containsKey(jeu)) {
			p = joueurs.get(jeu);
			for (int i=0; i<p.size(); i++) {
				if (p.get(i).getName().equals(nom)) {
					p.remove(i);
					joueurs.put(jeu, p);
					return "";
				}
			}
		}
		return "";
	}
}
