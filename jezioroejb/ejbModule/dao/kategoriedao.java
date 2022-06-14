package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jezioro.Kategorie;

@Stateless
public class kategoriedao {

	
	@PersistenceContext
    EntityManager em;

    public void insert(Kategorie kategorie) {
        em.persist(kategorie);
    }

    public Kategorie update(Kategorie kategorie) {
        return em.merge(kategorie);
    }

    public void delete(Kategorie kategorie) {
        em.remove(em.merge(kategorie));
    }
	
	
}
