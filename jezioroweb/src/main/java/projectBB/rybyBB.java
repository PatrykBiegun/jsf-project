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
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import javax.enterprise.context.RequestScoped;

import dao.rybydao;
import dao.uzytkownicydao;
import jezioro.Ryby;
import jezioro.Uzytkownicy;


@Named
@RequestScoped
public class rybyBB {

	private static final String PAGE_PERSON_LIST = "index?faces-redirect=true";
	private static final String PANEL= "panel?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	private LazyDataModel<Ryby> lazyModel;
	private String name;
	private Ryby ryby = new Ryby();
	
	public String getName() {
        return name;
    }
	
	public Ryby getRyby() {
		return ryby;
	}
	
	public LazyDataModel<Ryby> getLazyModel() {
		return lazyModel;
	}
	
    public void setName(String name) {
        this.name = name;
    }
	
	@PostConstruct
	public void init() {
		lazyModel = new LazyDataModel<Ryby>() {

			@Override
			public List<Ryby> load(int offset, int PageSize, Map<String, SortMeta> arg2, Map<String, FilterMeta> arg3) {

				List<Ryby> list = null;

				Map<String, Object> searchName = new HashMap<String, Object>();

				if (name != null && name.length() > 0) {
					searchName.put("name", name);
				}

				list = rybydao.getAcceptedListPaginated(searchName, PageSize, offset);

				this.setRowCount(rybydao.getAcceptedListCount(searchName));

				return list;
			}
		};
		}
	
	@Inject
	FacesContext context;

	@Inject
	Flash flash;

	@EJB
	rybydao rybydao;
	
	  public String addfish() {  
	    	
			
	        try {

	        	rybydao.insert(ryby);
	            
	      
	        } catch (Exception e) {
	            e.printStackTrace();
	            return PAGE_STAY_AT_THE_SAME;
	        }

	        return PANEL;
	    }
	  
	  public String deletefish(Ryby ryby) {

			rybydao.delete(ryby);
			return PAGE_STAY_AT_THE_SAME;
		}
	
	  public List<Ryby> getFullList(){
		  
		  List<Ryby> list = null;

			Map<String, Object> searchName = new HashMap<String, Object>();

			if (name != null && name.length() > 0) {
				searchName.put("name", name);
				
				
			}
		 
			list = rybydao.getFullList(searchName);
			return list;
	  }
	  
	  
}
