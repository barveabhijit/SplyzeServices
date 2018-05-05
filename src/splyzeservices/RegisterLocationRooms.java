package splyzeservices;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name="backing_registerlocationroom")
@RequestScoped

public class RegisterLocationRooms {
    private HtmlForm room_entry_form;
    private HtmlCommandButton room_finish;
    private HtmlCommandButton room_back;
    
    public RegisterLocationRooms() {
    }

    public void setRoom_finish(HtmlCommandButton room_finish) {
        this.room_finish = room_finish;
    }

    public HtmlCommandButton getRoom_finish() {
        return room_finish;
    }

    public void setRoom_back(HtmlCommandButton room_back) {
        this.room_back = room_back;
    }

    public HtmlCommandButton getRoom_back() {
        return room_back;
    }
    
    public Object room_finish_action() {
        
        HttpServletRequest request = (HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest());
        HttpSession session = request.getSession();
        
        LocationDetails locationDetails = (LocationDetails) session.getAttribute("locationDetails");
        
        ArrayList<LocationArea> areaList = locationDetails.getLocationAreaList();                                                      
        
        for (int i=0; i < locationDetails.getNumAreas(); i++){
            LocationArea area = areaList.get(i);
            if( area.getLocationRoomList().size() > 0 ){
                area.getLocationRoomList().clear();
            }
            for(int j = 0; j < area.getNumRooms();j++){
                area.getLocationRoomList().add(new LocationRoom());
            }
        }
                                                                                                                                
        List<UIComponent> componentList = room_entry_form.getChildren();
        
        for (int i=0; i < componentList.size(); i++){
            UIComponent component = componentList.get(i);
            String componentId = component.getId();            
                                
            if( componentId.startsWith("room")){
                if( componentId.endsWith("Name")){
                    
                    String[] splitItems = componentId.split("_");
                    int roomNumIndex = Integer.parseInt(splitItems[1]) - 1;
                    
                    int areaNumIndex = Integer.parseInt(splitItems[3]) - 1;
                    
                    areaList.get(areaNumIndex).getLocationRoomList().get(roomNumIndex).setRoomName(((HtmlInputText)component).getValue().toString());
                }
            }
        }
        
        session.setAttribute("locationDetails", locationDetails);
        return "finish";
    }

    public Object room_back_action() {
        
        return "back";
    }

    public void setRoom_entry_form(HtmlForm room_entry_form) {
        this.room_entry_form = room_entry_form;
    }

    public HtmlForm getRoom_entry_form() {
        return room_entry_form;
    }
}
