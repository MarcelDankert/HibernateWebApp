package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entitaetsklassen.Person;

@Repository //kennzeichnet eine Klasse als DAO=Klasse, wichtig fürs Exception-Handling
public class PersonDAOImpl implements PersonDAO {

	@Autowired // holt bean aus der config-xml
	private SessionFactory sessionFactory;
	
	/*
	 * @Transactional übernimmt die Methoden der Session Factory.
	 * Dadurch spart man "session.beginTransaction();" und
	 * session.getTransaction().commit();
	 */
	@Override
	@Transactional	
	public List<Person> getPerson() {
		
		// Hibernate Session starten
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Abfrage schreiben - Import beachten
		Query<Person> query =  currentSession.createQuery("from person", Person.class);
		
		List<Person> personen = query.getResultList();
		
		return personen;
	}

}
