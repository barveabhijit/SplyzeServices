package splyzeservices;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@ManagedBean(name="backing_confirmlocation")
@RequestScoped

public class ConfirmLocationDetails {
    
    private HtmlForm confirm_location_form;
    private HtmlCommandButton confirm_submit;
    private HtmlCommandButton confirm_back;
    
    
    public ConfirmLocationDetails() {
    }

    public void setConfirm_location_form(HtmlForm confirm_location_form) {
        this.confirm_location_form = confirm_location_form;
    }

    public HtmlForm getConfirm_location_form() {
        return confirm_location_form;
    }

    public void setConfirm_submit(HtmlCommandButton confirm_submit) {
        this.confirm_submit = confirm_submit;
    }

    public HtmlCommandButton getConfirm_submit() {
        return confirm_submit;
    }

    public void setConfirm_back(HtmlCommandButton confirm_back) {
        this.confirm_back = confirm_back;
    }

    public HtmlCommandButton getConfirm_back() {
        return confirm_back;
    }
    
    public Object confirm_submit_action() {
        HttpServletRequest request = (HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest());
        HttpSession session = request.getSession();
        
        LocationDetails locationDetails = (LocationDetails) session.getAttribute("locationDetails");


        try {
            addLocation(locationDetails);
        } catch (ClassNotFoundException e) {
            session.removeAttribute("locationDetails");
            session.setAttribute("splyzeException", e.getStackTrace());
            return "exception";
        } catch (SQLException e) {
            session.removeAttribute("locationDetails");
            session.setAttribute("splyzeException", e.getStackTrace());
            return "exception";
        } catch (Exception e) {
            session.removeAttribute("locationDetails");
            session.setAttribute("splyzeException", e.getStackTrace());
            return "exception";
        }
        
        session.removeAttribute("locationDetails");
        return "submit";
    }
    
    public Object confirm_back_action(){
        return "back";
    }

    private void addLocation(LocationDetails locationDetails) throws ClassNotFoundException, SQLException, Exception {
        EventInfoInserter inserter = new EventInfoInserter();
        int locationId = inserter.addLocation(locationDetails.getLocationName(), 
                                              locationDetails.getLocationAddressLine1(), 
                                              locationDetails.getLocationAddressLine2(), 
                                              locationDetails.getLocationCity(), 
                                              locationDetails.getLocationState(), 
                                              locationDetails.getLocationZipPostalCode(), 
                                              locationDetails.getLocationCountry());
                
        for (int i = 0; i < locationDetails.getLocationAreaList().size(); i++){
            LocationArea area = locationDetails.getLocationAreaList().get(i);
            int locationAreaId = inserter.addLocationArea(locationId, area.getAreaName());
            
            for (int j = 0; j < area.getLocationRoomList().size(); j++ ){
                LocationRoom room = area.getLocationRoomList().get(j);
                int locationRoomId = inserter.addLocationRoom(locationId, locationAreaId, room.getRoomName());
            }
        }
    }
}
