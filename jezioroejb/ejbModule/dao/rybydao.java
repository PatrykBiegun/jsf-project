package dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jezioro.Ryby;
import jezioro.Uzytkownicy;

@Stateless
public class rybydao {

	
	@PersistenceContext
    EntityManager em;
	
	
    public void insert(Ryby ryby) {
        em.persist(ryby);
    }

    public Ryby update(Ryby ryby) {
        return em.merge(ryby);
    }

    public void delete(Ryby ryby) {
        em.remove(em.merge(ryby));
    }
	
    public List<Ryby> getAcceptedListPaginated(Map<String, Object> searchName, int pagesize, int offset) {
        List<Ryby> list = null;

        String select = "select r ";
        String from = "from Ryby r ";
        String where = "";

        String name = (String) searchName.get("name");
        if (name != null) {

            where += "where r.nazwa_ryby like :custName ";
        }

        Query query = em.createQuery(select + from + where);

        if (name != null) {
            query.setParameter("custName", name + "%");
        }


        query.setMaxResults(pagesize).setFirstResult(offset);

        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int getAcceptedListCount(Map<String, Object> searchName) {
        int count = 0;

        String select = "select r ";
        String from = "from Ryby r ";
        String where = "";

        String name = (String) searchName.get("name");
        if (name != null) {

            where += "where r.nazwa_ryby like :custName ";
        }

        Query query = em.createQuery(select + from + where);

        if (name != null) {
            query.setParameter("custName", name + "%");
        }


        try {
            List list = query.getResultList();
            count = list.size();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    
   public List<Ryby> getFullList(Map<String, Object> searchName){

       List<Ryby> list = null;

       String select = "select r ";
       String from = "from Ryby r ";
       String where = "";

       String name = (String) searchName.get("name");
       if (name != null) {

           where += "where r.nazwa_ryby like :custName ";
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
