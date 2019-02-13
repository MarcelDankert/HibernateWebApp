package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.PersonDAO;
import entitaetsklassen.Person;

@Controller
@RequestMapping("/personen")
public class PersonenController {
	
	// Controller mit der DAO_Klasse verbinden
	@Autowired
	private PersonDAO personDAO;
	
	@RequestMapping("/liste")
	public String personenAuflisten(Model model) {
		
		// Personen �ber die DAO_Klasse abspeichern
		List<Person> personen = personDAO.getPerson();
		
		// Liste ans Model anh�ngen
		model.addAttribute(personen);
		
		return "personenliste";
	}
}
