package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entitaetsklassen.Person;
import service.PersonService;

@Controller
@RequestMapping("/personen") // Parent-Mapping
public class PersonenController {
	
	// Controller mit der Service-Klasse verbinden
	@Autowired
	private PersonService personService;
	
	// Entweder RequestMapping, oder Get/Post Mapping um die Methode zu bestimmen
	@GetMapping("/liste") // Child-Mapping
	public String personenAuflisten(Model model) {
		
		// Personen über die DAO_Klasse abspeichern
		List<Person> personen = personService.getPerson();
		
		// Liste als Key/Value-Paar ans Model anhängen
		model.addAttribute("personen", personen);
		
		// entspricht http://localhost:8080/HibernateWebApp/personen/liste
		return "personenliste";
	}
}
