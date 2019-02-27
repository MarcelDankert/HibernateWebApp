/**
 * 
 */
package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PersonDAO;
import entitaetsklassen.Person;

/**
 * @author s15
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired 
	private PersonDAO personDAO;
	

	/*
	 * @Transactional übernimmt die Methoden der Session Factory.
	 * Dadurch spart man "session.beginTransaction();" und
	 * session.getTransaction().commit();
	 */
	@Override
	@Transactional
	public List<Person> getPersonen() {
		return personDAO.getPersonen();
	}


	/* (non-Javadoc)
	 * @see service.PersonService#personSpeichern(entitaetsklassen.Person)
	 */
	@Override
	@Transactional
	public void personSpeichern(Person person) {
		personDAO.personSpeichern(person);
		
	}


	/* (non-Javadoc)
	 * @see service.PersonService#getPerson(int)
	 */
	@Override
	@Transactional
	public Person getPerson(int personenNr) {
		// TODO Auto-generated method stub
		return personDAO.getPerson(personenNr);
	}


	/* (non-Javadoc)
	 * @see service.PersonService#personLoeschen(entitaetsklassen.Person)
	 */
	@Override
	@Transactional
	public void personLoeschen(int personenNr) {
		personDAO.personLoeschen(personenNr);
		
	}


	/* (non-Javadoc)
	 * @see service.PersonService#personSuchen(java.lang.String)
	 */
	@Override
	@Transactional
	public List<Person> personSuchen(String suchName) {
		// TODO Auto-generated method stub
		return personDAO.personSuchen(suchName);
	}

}
