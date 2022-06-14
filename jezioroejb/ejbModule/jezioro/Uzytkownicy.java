package jezioro;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the uzytkownicy database table.
 * 
 */
@Entity
@NamedQuery(name = "Uzytkownicy.findAll", query = "SELECT u FROM Uzytkownicy u")
public class Uzytkownicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Timestamp data_Modyfiakcji;

	private String email;

	private String haslo;

	private String imie;

	@Column(name = "kiedy_dezaktywowana")
	private Timestamp kiedyDezaktywowana;

	private String login;

	private String nazwisko;

	private String pesel;

	private String rola;

	private int suma;

	// bi-directional many-to-one association to Sprzet
	@OneToMany(mappedBy = "uzytkownicy")
	private List<Sprzet> sprzets;

	// bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name = "kto_stworzyl")
	private Uzytkownicy uzytkownicy1;

	// bi-directional many-to-one association to Uzytkownicy
	@OneToMany(mappedBy = "uzytkownicy1")
	private List<Uzytkownicy> uzytkownicies1;

	// bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name = "kto_modyfikowal")
	private Uzytkownicy uzytkownicy2;

	// bi-directional many-to-one association to Uzytkownicy
	@OneToMany(mappedBy = "uzytkownicy2")
	private List<Uzytkownicy> uzytkownicies2;

	public Uzytkownicy() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getData_Modyfiakcji() {
		return this.data_Modyfiakcji;
	}

	public void setData_Modyfiakcji(Timestamp data_Modyfiakcji) {
		this.data_Modyfiakcji = data_Modyfiakcji;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Timestamp getKiedyDezaktywowana() {
		return this.kiedyDezaktywowana;
	}

	public void setKiedyDezaktywowana(Timestamp kiedyDezaktywowana) {
		this.kiedyDezaktywowana = kiedyDezaktywowana;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getRola() {
		return this.rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public int getSuma() {
		return this.suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public List<Sprzet> getSprzets() {
		return this.sprzets;
	}

	public void setSprzets(List<Sprzet> sprzets) {
		this.sprzets = sprzets;
	}

	public Sprzet addSprzet(Sprzet sprzet) {
		getSprzets().add(sprzet);
		sprzet.setUzytkownicy(this);

		return sprzet;
	}

	public Sprzet removeSprzet(Sprzet sprzet) {
		getSprzets().remove(sprzet);
		sprzet.setUzytkownicy(null);

		return sprzet;
	}

	public Uzytkownicy getUzytkownicy1() {
		return this.uzytkownicy1;
	}

	public void setUzytkownicy1(Uzytkownicy uzytkownicy1) {
		this.uzytkownicy1 = uzytkownicy1;
	}

	public List<Uzytkownicy> getUzytkownicies1() {
		return this.uzytkownicies1;
	}

	public void setUzytkownicies1(List<Uzytkownicy> uzytkownicies1) {
		this.uzytkownicies1 = uzytkownicies1;
	}

	public Uzytkownicy addUzytkownicies1(Uzytkownicy uzytkownicies1) {
		getUzytkownicies1().add(uzytkownicies1);
		uzytkownicies1.setUzytkownicy1(this);

		return uzytkownicies1;
	}

	public Uzytkownicy removeUzytkownicies1(Uzytkownicy uzytkownicies1) {
		getUzytkownicies1().remove(uzytkownicies1);
		uzytkownicies1.setUzytkownicy1(null);

		return uzytkownicies1;
	}

	public Uzytkownicy getUzytkownicy2() {
		return this.uzytkownicy2;
	}

	public void setUzytkownicy2(Uzytkownicy uzytkownicy2) {
		this.uzytkownicy2 = uzytkownicy2;
	}

	public List<Uzytkownicy> getUzytkownicies2() {
		return this.uzytkownicies2;
	}

	public void setUzytkownicies2(List<Uzytkownicy> uzytkownicies2) {
		this.uzytkownicies2 = uzytkownicies2;
	}

	public Uzytkownicy addUzytkownicies2(Uzytkownicy uzytkownicies2) {
		getUzytkownicies2().add(uzytkownicies2);
		uzytkownicies2.setUzytkownicy2(this);

		return uzytkownicies2;
	}

	public Uzytkownicy removeUzytkownicies2(Uzytkownicy uzytkownicies2) {
		getUzytkownicies2().remove(uzytkownicies2);
		uzytkownicies2.setUzytkownicy2(null);

		return uzytkownicies2;
	}

}