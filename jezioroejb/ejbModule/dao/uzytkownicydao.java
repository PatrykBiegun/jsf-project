package dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jezioro.Ryby;
import jezioro.Sprzet;
import jezioro.Uzytkownicy;

@Stateless
public class uzytkownicydao {

	@PersistenceContext
	EntityManager em;

	public void insert(Uzytkownicy uzytkownicy) {
		em.persist(uzytkownicy);
	}

	public Uzytkownicy update(Uzytkownicy uzytkownicy) {
		return em.merge(uzytkownicy);
	}

	public void delete(Uzytkownicy uzytkownicy) {
		em.remove(em.merge(uzytkownicy));
	}

	public Uzytkownicy get(Object iduser) {
		return em.find(Uzytkownicy.class, iduser);
	}

	public List validateCreate(String login) {
		return em.createQuery("SELECT u FROM Uzytkownicy u WHERE u.login LIKE :custLogin")
				.setParameter("custLogin", login).getResultList();
	}

	public List validatePesel(String pesel) {
		return em.createQuery("SELECT u FROM Uzytkownicy u WHERE u.pesel LIKE :custPesel")
				.setParameter("custPesel", pesel).getResultList();
	}

	public List validateEmail(String email) {
		return em.createQuery("SELECT u FROM Uzytkownicy u WHERE u.email LIKE :custEmial")
				.setParameter("custEmial", email).getResultList();
	}

	public List validateLogin(String login, String haslo) {
		return em.createQuery("SELECT u FROM Uzytkownicy u WHERE u.login LIKE :custLogin AND u.haslo LIKE :custHaslo")
				.setParameter("custLogin", login).setParameter("custHaslo", haslo).getResultList();
	}

	public List checkRole(int ID) {
		return em.createQuery("SELECT u.rola FROM Uzytkownicy u WHERE u.id LIKE :custID").setParameter("custID", ID)
				.getResultList();
	}

	public List<Uzytkownicy> getFullList(Map<String, Object> searchName) {

		List<Uzytkownicy> list = null;

		String select = "select r ";
		String from = "from Uzytkownicy r ";
		String where = "";

		String name = (String) searchName.get("name");
		if (name != null) {

			where += "where r.login like :custName ";
		}

		Query query = em.createQuery(select + from + where);

		if (name != null) {
			query.setParameter("custName", name + "%");
		}

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
