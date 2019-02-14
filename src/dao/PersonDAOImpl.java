package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entitaetsklassen.Person;

//kennzeichnet eine Klasse als DAO=Klasse, wichtig fürs Exception-Handling
@Repository 
public class PersonDAOImpl implements PersonDAO {

	@Autowired // holt bean aus der config-xml
	private SessionFactory sessionFactory;
	
	@Override	
	public List<Person> getPerson() {
		
		// Hibernate Session starten
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Abfrage schreiben - Import beachten
		Query<Person> query =  currentSession.createQuery("from Person", Person.class);
		
		// Abfrage ausführen und in die Liste speichern
		List<Person> personen = query.getResultList();
		
		
		// Liste ausgeben
		return personen;
	}

}
