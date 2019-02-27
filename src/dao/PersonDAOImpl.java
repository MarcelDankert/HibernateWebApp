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
	public List<Person> getPersonen() {

		// Hibernate Session starten
		Session currentSession = sessionFactory.getCurrentSession();

		// Abfrage schreiben - Import beachten
		Query<Person> query = currentSession.createQuery("from Person order by nachname", Person.class);

		// Abfrage ausführen und in die Liste speichern
		List<Person> personen = query.getResultList();

		// Liste ausgeben
		return personen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDAO#personSpeichern(entitaetsklassen.Person)
	 */
	@Override
	public void personSpeichern(Person person) {

		// Hibernate Session starten
		Session currentSession = sessionFactory.getCurrentSession();

		// Person speichern oder updaten
		currentSession.saveOrUpdate(person);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDAO#getPersonen(int)
	 */
	@Override
	public Person getPerson(int personenNr) {

		// Hibernate Session starten
		Session currentSession = sessionFactory.getCurrentSession();

		// Daten mit PK aus der Datenbank holen
		Person person = currentSession.get(Person.class, personenNr);

		return person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDAO#personLoeschen(int)
	 */
	@Override
	public void personLoeschen(int nr) {
		// Hibernate Session starten
		Session currentSession = sessionFactory.getCurrentSession();

		// Datensatz mit PK löschen
		Query q = currentSession.createQuery("DELETE FROM Person WHERE personenNr=:nr");
		q.setParameter("nr", nr);
		
		q.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see dao.PersonDAO#personSuchen(java.lang.String)
	 */
	@Override
	public List<Person> personSuchen(String suchName) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        // Es wird nur gesucht, wenn das Suchfeld nicht leer ist
        if (suchName != null && suchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Person where lower(vorname) like :theName or lower(nachname) like :theName", Person.class);
            theQuery.setParameter("theName", "%" + suchName.toLowerCase() + "%");

        }
        else {
            // Liste leer, alle Personen ausgeben
            theQuery =currentSession.createQuery("from Person", Person.class);            
        }
        
        // Query ausführen und Resultset in Liste speichern
        List<Person> personen = theQuery.getResultList();
                
        // return the results        
        return personen;
	}

}
