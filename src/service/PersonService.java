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

	public List<Person> getPerson();

	/**
	 * @param person
	 */
	public void personSpeichern(Person person);	
	
}
