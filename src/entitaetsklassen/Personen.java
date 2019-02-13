package entitaetsklassen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// Als Entität markieren und mit der Tabelle verknüpfen
@Entity
@Table(name="tbl_personen")
public class Personen {
	// Attribute deklarieren und mit den Tabellenspalten verknüpfen
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="personennr")
	private int personenNr;
	@Column(name="vorname")
	private String vorname;
	@Column(name="nachname")
	private int nachname;
	@Column(name="land")
	private String land;
	
	// Konstruktor
	public Personen() {
	}
	// Getter und Setter
	public int getPersonenNr() {
		return personenNr;
	}

	public void setPersonenNr(int personenNr) {
		this.personenNr = personenNr;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getNachname() {
		return nachname;
	}

	public void setNachname(int nachname) {
		this.nachname = nachname;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}
	// to String Methode
	@Override
	public String toString() {
		return "Personen [personenNr=" + personenNr + ", vorname=" + vorname + ", nachname=" + nachname + ", land="
				+ land + "]";
	}
		
}
