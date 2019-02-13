package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personen")
public class PersonenController {
	
	@RequestMapping("/liste")
	public String personenAuflisten(Model model) {
		return "personenliste";
	}
}
