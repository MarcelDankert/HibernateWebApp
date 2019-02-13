package dao;

import java.util.List;

import entitaetsklassen.Person;

/*
 * Data Access Object (DAO, englisch f�r Datenzugriffsobjekt) ist ein Entwurfsmuster, 
 * das den Zugriff auf unterschiedliche Arten von Datenquellen (z. B. Datenbanken, Dateisystem) 
 * so kapselt, dass die angesprochene Datenquelle ausgetauscht werden kann, ohne dass der aufrufende 
 * Code ge�ndert werden muss. Dadurch soll die eigentliche Programmlogik von technischen Details 
 * der Datenspeicherung befreit werden und flexibler einsetzbar sein. DAO ist also ein Muster f�r 
 * die Gestaltung von Programmierschnittstellen (APIs). 
 */

public interface PersonDAO {

		public List<Person> getPerson();
}
