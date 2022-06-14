package jezioro;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ryby database table.
 * 
 */
@Entity
@NamedQuery(name="Ryby.findAll", query="SELECT r FROM Ryby r")
public class Ryby implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_Ryby;

	@Column(name="cena_za_kilogram")
	private int cenaZaKilogram;

	private String nazwa_ryby;

	@Column(name="nr_stawu")
	private int nrStawu;

	public Ryby() {
	}

	public int getID_Ryby() {
		return this.ID_Ryby;
	}

	public void setID_Ryby(int ID_Ryby) {
		this.ID_Ryby = ID_Ryby;
	}

	public int getCenaZaKilogram() {
		return this.cenaZaKilogram;
	}

	public void setCenaZaKilogram(int cenaZaKilogram) {
		this.cenaZaKilogram = cenaZaKilogram;
	}

	public String getNazwa_ryby() {
		return this.nazwa_ryby;
	}

	public void setNazwa_ryby(String nazwa_ryby) {
		this.nazwa_ryby = nazwa_ryby;
	}

	public int getNrStawu() {
		return this.nrStawu;
	}

	public void setNrStawu(int nrStawu) {
		this.nrStawu = nrStawu;
	}

}