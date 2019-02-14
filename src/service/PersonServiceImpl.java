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
	public List<Person> getPerson() {
		return personDAO.getPerson();
	}

}
