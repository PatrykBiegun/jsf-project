package projectBB;



import java.sql.Timestamp;
import java.time.Instant;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import dao.uzytkownicydao;
import jezioro.Uzytkownicy;


@Named
@RequestScoped
public class registerBB {

	private static final String PAGE_PERSON_LIST = "index?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private Uzytkownicy uzytkownicy = new Uzytkownicy();
	

	
	public Uzytkownicy getUzytkownicy() {
		return uzytkownicy;
	}
	
	@EJB
	uzytkownicydao uzytkownicydao;

	@Inject
	FacesContext context;

	@Inject
	Flash flash;



	public String saveData() {  
	
		if(!uzytkownicydao.validateCreate(uzytkownicy.getLogin()).isEmpty()){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login zazjêty." , null));
            return PAGE_STAY_AT_THE_SAME;
		}
		
		if(!uzytkownicydao.validatePesel(uzytkownicy.getPesel()).isEmpty()){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Pesel ju¿ jest w bazie." , null));
            return PAGE_STAY_AT_THE_SAME;
		}
		
		if(!uzytkownicydao.validateEmail(uzytkownicy.getEmail()).isEmpty()){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Email ju¿ jest w bazie." , null));
            return PAGE_STAY_AT_THE_SAME;
		}
		
        try {
        	Uzytkownicy system = (Uzytkownicy) uzytkownicydao.validateCreate("system").get(0);
        	uzytkownicy.setUzytkownicy1(system);
        	uzytkownicy.setSuma(0);
        	uzytkownicy.setRola("uzytkownik");
        	uzytkownicydao.insert(uzytkownicy);
            
      
        } catch (Exception e) {
            e.printStackTrace();
            return PAGE_STAY_AT_THE_SAME;
        }

        return PAGE_PERSON_LIST;
    }
}
