package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Zaduzenje database table.
 * 
 */
@Entity
@NamedQuery(name="Zaduzenje.findAll", query="SELECT z FROM Zaduzenje z")
public class Zaduzenje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZaduzenja;

	@Temporal(TemporalType.DATE)
	private Date datumVracanja;

	@Temporal(TemporalType.DATE)
	private Date datumZaduzenja;

	//bi-directional many-to-one association to Clan
	@ManyToOne
	@JoinColumn(name="clanskiBroj")
	private Clan clan;

	//bi-directional many-to-one association to Primerak
	@ManyToOne
	@JoinColumn(name="invBroj")
	private Primerak primerak;

	public Zaduzenje() {
	}

	public int getIdZaduzenja() {
		return this.idZaduzenja;
	}

	public void setIdZaduzenja(int idZaduzenja) {
		this.idZaduzenja = idZaduzenja;
	}

	public Date getDatumVracanja() {
		return this.datumVracanja;
	}

	public void setDatumVracanja(Date datumVracanja) {
		this.datumVracanja = datumVracanja;
	}

	public Date getDatumZaduzenja() {
		return this.datumZaduzenja;
	}

	public void setDatumZaduzenja(Date datumZaduzenja) {
		this.datumZaduzenja = datumZaduzenja;
	}

	public Clan getClan() {
		return this.clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Primerak getPrimerak() {
		return this.primerak;
	}

	public void setPrimerak(Primerak primerak) {
		this.primerak = primerak;
	}

}