package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the Primerak database table.
 * 
 */
@Entity
@NamedQuery(name="Primerak.findAll", query="SELECT p FROM Primerak p")
public class Primerak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int invBroj;

	//bi-directional many-to-one association to Knjiga
	@ManyToOne
	@JoinColumn(name="idKnjiga")
	private Knjiga knjiga;

	//bi-directional many-to-one association to Zaduzenje
	@OneToMany(mappedBy="primerak")
	private List<Zaduzenje> zaduzenjes;

	public Primerak() {
	}

	public int getInvBroj() {
		return this.invBroj;
	}

	public void setInvBroj(int invBroj) {
		this.invBroj = invBroj;
	}

	public Knjiga getKnjiga() {
		return this.knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public List<Zaduzenje> getZaduzenjes() {
		return this.zaduzenjes;
	}

	public void setZaduzenjes(List<Zaduzenje> zaduzenjes) {
		this.zaduzenjes = zaduzenjes;
	}

	public Zaduzenje addZaduzenje(Zaduzenje zaduzenje) {
		getZaduzenjes().add(zaduzenje);
		zaduzenje.setPrimerak(this);

		return zaduzenje;
	}

	public Zaduzenje removeZaduzenje(Zaduzenje zaduzenje) {
		getZaduzenjes().remove(zaduzenje);
		zaduzenje.setPrimerak(null);

		return zaduzenje;
	}

}