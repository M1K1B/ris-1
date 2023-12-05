package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Ocena database table.
 * 
 */
@Entity
@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOcena;

	private int idIzvodjenje;

	private int idPosetilac;

	private String komentar;

	private String ocena;

	public Ocena() {
	}

	public int getIdOcena() {
		return this.idOcena;
	}

	public void setIdOcena(int idOcena) {
		this.idOcena = idOcena;
	}

	public int getIdIzvodjenje() {
		return this.idIzvodjenje;
	}

	public void setIdIzvodjenje(int idIzvodjenje) {
		this.idIzvodjenje = idIzvodjenje;
	}

	public int getIdPosetilac() {
		return this.idPosetilac;
	}

	public void setIdPosetilac(int idPosetilac) {
		this.idPosetilac = idPosetilac;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public String getOcena() {
		return this.ocena;
	}

	public void setOcena(String ocena) {
		this.ocena = ocena;
	}

}