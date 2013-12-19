package manhattan.controller;

import manhattan.jeu.JoueurProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManhattanController {
	
	@Autowired JoueurProvider init;
	
	@RequestMapping("/manhattan")
	public String manhattan(Model model) {
		model.addAttribute("test", init);
		return "manhattan";
	}	

	
	
}
