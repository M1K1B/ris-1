package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the Omiljene database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljene.findAll", query="SELECT o FROM Omiljene o")
public class Omiljene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOmiljene;

	private int idPosetilac;

	private int idPredstava;

	public Omiljene() {
	}

	public int getIdOmiljene() {
		return this.idOmiljene;
	}

	public void setIdOmiljene(int idOmiljene) {
		this.idOmiljene = idOmiljene;
	}

	public int getIdPosetilac() {
		return this.idPosetilac;
	}

	public void setIdPosetilac(int idPosetilac) {
		this.idPosetilac = idPosetilac;
	}

	public int getIdPredstava() {
		return this.idPredstava;
	}

	public void setIdPredstava(int idPredstava) {
		this.idPredstava = idPredstava;
	}

}