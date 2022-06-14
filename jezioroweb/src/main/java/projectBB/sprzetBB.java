package projectBB;



import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.simplesecurity.RemoteClient;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import javax.enterprise.context.RequestScoped;


import dao.uzytkownicydao;
import jezioro.Uzytkownicy;
import jezioro.Sprzet;
import dao.sprzetdao;

@Named
@RequestScoped
public class sprzetBB {

	private static final String PAGE_PERSON_LIST = "index?faces-redirect=true";
	private static final String PANEL= "panel?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String name;
	
	private Uzytkownicy uzytkownicy = new Uzytkownicy();

	public Uzytkownicy getUzytkownicy() {
		return uzytkownicy;
	}

	
	private Sprzet sprzet = new Sprzet();
	
	public String getName() {
        return name;
    }
	
	public Sprzet getSprzet() {
		return sprzet;
	}
	
    public void setName(String name) {
        this.name = name;
    }
	
	
	@Inject
	FacesContext context;

	@Inject
	Flash flash;

	@EJB
	sprzetdao sprzetdao;
	
	@EJB
	uzytkownicydao uzytkownicydao;
	
	
	
	  public List<Sprzet> getFullList(){
		  
		  List<Sprzet> list = null;

			Map<String, Object> searchName = new HashMap<String, Object>();

			if (name != null && name.length() > 0) {
				searchName.put("name", name);
				
				
			}
		 
			list = sprzetdao.getFullList(searchName);
			return list;
	  }
	  
	  public String reserve(Sprzet sprzet) {  
	    	
			
	        try {
	        	
	        	sprzet.setCzyWypozyczono(1);
	        	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	            RemoteClient<Uzytkownicy> client = RemoteClient.load(session);
	    	    uzytkownicy = client.getDetails();
	    	    uzytkownicy.setSuma(uzytkownicy.getSuma()+sprzet.getCena());
	    	    sprzet.setUzytkownicy(uzytkownicy);
	        	sprzetdao.update(sprzet);
	        	uzytkownicydao.update(uzytkownicy);
	        	client.setSuma(uzytkownicy.getSuma());

	        } catch (Exception e) {
	            e.printStackTrace();
	            return PAGE_STAY_AT_THE_SAME;
	        }

	        return PAGE_STAY_AT_THE_SAME;
	    }
	  
  public List<Sprzet> getYourList(){
		  
		  List<Sprzet> list = null;
		  
		  HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
          RemoteClient<Uzytkownicy> client = RemoteClient.load(session);
  	      uzytkownicy = client.getDetails();
  	      
			Map<String, Object> searchName = new HashMap<String, Object>();

			if (name != null && name.length() > 0) {
				searchName.put("name", name);
				
				
			}
		 
			list = sprzetdao.getYourList(searchName, uzytkownicy);
			return list;
	  }
  
  public String returnn(Sprzet sprzet) {  
  	
		
      try {
      	
      	sprzet.setCzyWypozyczono(0);
      	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
          RemoteClient<Uzytkownicy> client = RemoteClient.load(session);
  	    uzytkownicy = client.getDetails();
  	    uzytkownicy.setSuma(uzytkownicy.getSuma()-sprzet.getCena());
  	    sprzet.setUzytkownicy(null);
      	sprzetdao.update(sprzet);
      	uzytkownicydao.update(uzytkownicy);
      	client.setSuma(uzytkownicy.getSuma());

      } catch (Exception e) {
          e.printStackTrace();
          return PAGE_STAY_AT_THE_SAME;
      }

      return PAGE_STAY_AT_THE_SAME;
  }
}
