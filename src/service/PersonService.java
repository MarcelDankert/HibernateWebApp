/**
 * 
 */
package service;

import java.util.List;

import entitaetsklassen.Person;

/**
 * @author s15
 *
 */
public interface PersonService {

	public List<Person> getPersonen();

	/**
	 * @param person
	 */
	public void personSpeichern(Person person);

	/**
	 * @param personenNr
	 * @return
	 */
	public Person getPerson(int personenNr);	
	
}
