package jezioro;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategorie database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorie.findAll", query="SELECT k FROM Kategorie k")
public class Kategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_Kategorii;

	private String nazwa;

	private String opis;

	//bi-directional many-to-one association to Sprzet
	@OneToMany(mappedBy="kategorie")
	private List<Sprzet> sprzets;

	public Kategorie() {
	}

	public int getID_Kategorii() {
		return this.ID_Kategorii;
	}

	public void setID_Kategorii(int ID_Kategorii) {
		this.ID_Kategorii = ID_Kategorii;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Sprzet> getSprzets() {
		return this.sprzets;
	}

	public void setSprzets(List<Sprzet> sprzets) {
		this.sprzets = sprzets;
	}

	public Sprzet addSprzet(Sprzet sprzet) {
		getSprzets().add(sprzet);
		sprzet.setKategorie(this);

		return sprzet;
	}

	public Sprzet removeSprzet(Sprzet sprzet) {
		getSprzets().remove(sprzet);
		sprzet.setKategorie(null);

		return sprzet;
	}

}