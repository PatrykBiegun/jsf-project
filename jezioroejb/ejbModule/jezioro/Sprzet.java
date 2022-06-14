package jezioro;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the sprzet database table.
 * 
 */
@Entity
@NamedQuery(name = "Sprzet.findAll", query = "SELECT s FROM Sprzet s")
public class Sprzet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sprzetu")
	private int idSprzetu;

	private int cena;

	@Column(name = "czy_wypozyczono")
	private int czyWypozyczono;

	@Column(name = "nazwa_sprzetu")
	private String nazwaSprzetu;

	// bi-directional many-to-one association to Kategorie
	@ManyToOne
	private Kategorie kategorie;

	// bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	private Uzytkownicy uzytkownicy;

	public Sprzet() {
	}

	public int getIdSprzetu() {
		return this.idSprzetu;
	}

	public void setIdSprzetu(int idSprzetu) {
		this.idSprzetu = idSprzetu;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getCzyWypozyczono() {
		return this.czyWypozyczono;
	}

	public void setCzyWypozyczono(int czyWypozyczono) {
		this.czyWypozyczono = czyWypozyczono;
	}

	public String getNazwaSprzetu() {
		return this.nazwaSprzetu;
	}

	public void setNazwaSprzetu(String nazwaSprzetu) {
		this.nazwaSprzetu = nazwaSprzetu;
	}

	public Kategorie getKategorie() {
		return this.kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

}