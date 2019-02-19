package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<Person> personen = personService.getPersonen();
		
		// Liste als Key/Value-Paar ans Model anhängen
		model.addAttribute("personen", personen);
		
		// entspricht http://localhost:8080/HibernateWebApp/personen/liste
		return "personenliste";
	}
	
	@GetMapping("/addPersonForm") // Child-Mapping
	public String neuePerson(Model model) {
		
		// Personerstellen, welche dann die Formulardaten speichert
		Person person = new Person();
		
		// Person als Key/Value-Paar ans Model anhängen
		model.addAttribute("person", person);
		
		// entspricht http://localhost:8080/HibernateWebApp/personen/addPersonForm
		return "neuePersonFormular";
	}
	
	@GetMapping("/updatePersonForm") // Child-Mapping
	public String updatePerson(@RequestParam("personenNr") int personenNr, Model model) {
		
		// Person aus der Datenbank holen, um das Formular zu befüllen
		Person person = personService.getPerson(personenNr);
		
		// Person als Key/Value-Paar ans Model anhängen
		model.addAttribute("person", person);
		
		// entspricht http://localhost:8080/HibernateWebApp/personen/addPersonForm
		return "neuePersonFormular";
	}
	@PostMapping("/personSpeichern") // @ModelAttribute holt sich die Daten aus der jsp-Datei
	public String personSpeichern(@ModelAttribute("person") Person person) {
		
		// übergebene Person mit dem Service verknüpfen 
		personService.personSpeichern(person);
		
		// entspricht http://localhost:8080/HibernateWebApp/personen/addPersonForm
		return "redirect:/personen/liste";
	}
	
}
