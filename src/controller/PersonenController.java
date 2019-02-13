package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.PersonDAO;
import entitaetsklassen.Person;

@Controller
@RequestMapping("/personen") // Parent-Mapping
public class PersonenController {
	
	// Controller mit der DAO_Klasse verbinden
	@Autowired
	private PersonDAO personDAO;
	// Entweder RequestMapping, oder Get/Post Mapping um die Methode zu bestimmen
	@GetMapping("/liste") // Child-Mapping
	public String personenAuflisten(Model model) {
		
		// Personen über die DAO_Klasse abspeichern
		List<Person> personen = personDAO.getPerson();
		
		// Liste als Key/Value-Paar ans Model anhängen
		model.addAttribute("personen", personen);
		
		// entspricht http://localhost:8080/HibernateWebApp/personen/liste
		return "personenliste";
	}
}
