package projectBB;


import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.simplesecurity.RemoteClient;
import javax.faces.view.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.enterprise.context.RequestScoped;



import dao.uzytkownicydao;
import jezioro.Uzytkownicy;


@Named
@ViewScoped
public class loginBB implements Serializable{
    private static final long serialVersionUID = 1L;

	
	
	private static final String PAGE_PERSON_LIST = "panel?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
    private static final String GO_TO_MAIN_PAGE = "index" + "?faces-redirect=true";


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
	
	@Inject
    ExternalContext ctx;
	
	
	
	public String saveData() {  
        FacesContext ctx = FacesContext.getCurrentInstance();

		if(uzytkownicydao.validateLogin(uzytkownicy.getLogin(), uzytkownicy.getHaslo()).isEmpty()){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "b³êdny login lub has³o." , null));
            return PAGE_STAY_AT_THE_SAME;
		}
		
		
		
		
        uzytkownicy = (Uzytkownicy) uzytkownicydao.validateLogin(uzytkownicy.getLogin(), uzytkownicy.getHaslo()).get(0);
	    
        
        RemoteClient<Uzytkownicy> client = new RemoteClient<Uzytkownicy>(); 
        client.setDetails(uzytkownicy);
        client.setSuma(uzytkownicy.getSuma());
        String role = (String) uzytkownicydao.checkRole(uzytkownicy.getId()).get(0); 
        client.getRoles().add(role);
		  
        HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
        client.store(request);
		
		
        return PAGE_PERSON_LIST;
	}
	
	   public String logout(){
	        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	                .getExternalContext().getSession(true);
	        session.invalidate();
	        return GO_TO_MAIN_PAGE;
	    }
	
	
}
