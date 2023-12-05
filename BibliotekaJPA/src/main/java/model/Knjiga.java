package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the Knjiga database table.
 * 
 */
@Entity
@NamedQuery(name="Knjiga.findAll", query="SELECT k FROM Knjiga k")
public class Knjiga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKnjiga;

	private String autor;

	private String godinaIzdanja;

	private String izdavac;

	private String naslov;

	//bi-directional many-to-one association to Primerak
	@OneToMany(mappedBy="knjiga")
	private List<Primerak> primeraks;

	public Knjiga() {
	}

	public int getIdKnjiga() {
		return this.idKnjiga;
	}

	public void setIdKnjiga(int idKnjiga) {
		this.idKnjiga = idKnjiga;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGodinaIzdanja() {
		return this.godinaIzdanja;
	}

	public void setGodinaIzdanja(String godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	public String getIzdavac() {
		return this.izdavac;
	}

	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public List<Primerak> getPrimeraks() {
		return this.primeraks;
	}

	public void setPrimeraks(List<Primerak> primeraks) {
		this.primeraks = primeraks;
	}

	public Primerak addPrimerak(Primerak primerak) {
		getPrimeraks().add(primerak);
		primerak.setKnjiga(this);

		return primerak;
	}

	public Primerak removePrimerak(Primerak primerak) {
		getPrimeraks().remove(primerak);
		primerak.setKnjiga(null);

		return primerak;
	}

}