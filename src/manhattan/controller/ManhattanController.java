package manhattan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManhattanController {
	
	@RequestMapping("/manhattan")
	public String manhattan(Model model) {
		return "manhattan";
		
	}	

}
