package projectBB;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import jezioro.Ryby;
import jezioro.Uzytkownicy;

@Named
@ViewScoped
public class adminBB implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_PERSON_LIST = "panel?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	private static final String GO_TO_MAIN_PAGE = "index" + "?faces-redirect=true";
	private static final String PAGE_EDIT_USER = "editUser" + "?faces-redirect=true";
	private static final String PAGE_ADMIN_PANEL = "adminpanel" + "?faces-redirect=true";

	private String name;

	private Uzytkownicy uzytkownicy = new Uzytkownicy();

	public Uzytkownicy getUzytkownicy() {
		return uzytkownicy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	@EJB
	uzytkownicydao uzytkownicydao;

	@Inject
	FacesContext context;

	@Inject
	Flash flash;

	@Inject
	ExternalContext ctx;

	@Inject
	ExternalContext extcontext;

	public String deleteUser(Uzytkownicy uzytkownicy) {

		uzytkownicydao.delete(uzytkownicy);
		return PAGE_STAY_AT_THE_SAME;
	}

	public List<Uzytkownicy> getFullList() {

		List<Uzytkownicy> list = null;

		Map<String, Object> searchName = new HashMap<String, Object>();

		if (name != null && name.length() > 0) {
			searchName.put("name", name);

		}

		list = uzytkownicydao.getFullList(searchName);
		return list;
	}

	public String editview(Uzytkownicy uzytkownicy) {

		uzytkownicy = (Uzytkownicy) uzytkownicydao.validateCreate(uzytkownicy.getLogin()).get(0);

		HttpSession session2 = (HttpSession) extcontext.getSession(true);
		session2.setAttribute("uzytkownicy", uzytkownicy);

		return PAGE_EDIT_USER;
	}

	public String useredited() {

		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		uzytkownicy = (Uzytkownicy) session.getAttribute("uzytkownicy");
		try {
			uzytkownicydao.update(uzytkownicy);
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Blad zapisu.", null));
			return PAGE_STAY_AT_THE_SAME;
		}

		return PAGE_ADMIN_PANEL;
	}
	
	  public String Userdeleted(Uzytkownicy uzytkownicy) {

		  uzytkownicydao.delete(uzytkownicy);
			return PAGE_STAY_AT_THE_SAME;
		}
	
	
	
	
	
	
	
	
	
	
}
