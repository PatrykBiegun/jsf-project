package dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import jezioro.Sprzet;
import jezioro.Uzytkownicy;

@Stateless
public class sprzetdao {
	private static final String PAGE_STAY_AT_THE_SAME = null;
	private static final String PANEL = null;

	@PersistenceContext
	EntityManager em;

	public void insert(Sprzet sprzet) {
		em.persist(sprzet);
	}

	public Sprzet update(Sprzet sprzet) {
		return em.merge(sprzet);
	}

	public void delete(Sprzet sprzet) {
		em.remove(em.merge(sprzet));
	}

	public List<Sprzet> getFullList(Map<String, Object> searchName) {

		List<Sprzet> list = null;

		String select = "select r ";
		String from = "from Sprzet r ";
		String where = "where r.czyWypozyczono like :custE";

		String name = (String) searchName.get("name");
		if (name != null) {

			where += " and r.kategorie.nazwa like :custName";
		}

		Query query = em.createQuery(select + from + where);

		if (name != null) {
			query.setParameter("custName", name + "%");

		}
		query.setParameter("custE", 0);

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Sprzet> getYourList(Map<String, Object> searchName, Uzytkownicy uzytkownicy) {
			
		
		List<Sprzet> list = null;
		
		
        
		String select = "select r ";
		String from = "from Sprzet r ";
		String where = "where r.czyWypozyczono like :custE and r.uzytkownicy.id like :custUser";

		String name = (String) searchName.get("name");
		if (name != null) {

			where += " and r.kategorie.nazwa like :custName";
		}

		Query query = em.createQuery(select + from + where);

		if (name != null) {
			query.setParameter("custName", name + "%");

		}
		query.setParameter("custE", 1);
		query.setParameter("custUser", uzytkownicy.getId() );

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
}
