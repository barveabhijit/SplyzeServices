package splyzeservices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import java.util.List;
import java.util.ArrayList;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name="backing_registerlocationarea")
@RequestScoped

public class RegisterLocationAreas {
    private HtmlForm area_entry_form;
    private HtmlCommandButton area_next;
    private HtmlCommandButton area_back;
    
    public RegisterLocationAreas() {
    }

    public void setArea_entry_form(HtmlForm area_entry_form) {
        this.area_entry_form = area_entry_form;
    }

    public HtmlForm getArea_entry_form() {
        return area_entry_form;
    }

    public void setArea_next(HtmlCommandButton area_next) {
        this.area_next = area_next;
    }

    public HtmlCommandButton getArea_next() {
        return area_next;
    }

    public void setArea_back(HtmlCommandButton area_back) {
        this.area_back = area_back;
    }

    public HtmlCommandButton getArea_back() {
        return area_back;
    }
    
    public Object area_next_action() {
        
        HttpServletRequest request = (HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest());
        HttpSession session = request.getSession();
        
        LocationDetails locationDetails = (LocationDetails) session.getAttribute("locationDetails");
        
        ArrayList<LocationArea> areaList = locationDetails.getLocationAreaList();                                                      
        
        if( areaList.size() > 0){
            areaList.clear();
        }
        
        for (int i=0; i < locationDetails.getNumAreas(); i++){
            areaList.add(new LocationArea());
        }
                                                                                                                                
        List<UIComponent> componentList = area_entry_form.getChildren();
        
        for (int i=0; i < componentList.size(); i++){
            UIComponent component = componentList.get(i);
            String componentId = component.getId();
            
            if( componentId.startsWith("area") ){
                if(componentId.endsWith("Name")){
                    
                    String[] splitItems = componentId.split("_");
                    int areaNumIndex = Integer.parseInt(splitItems[1]) - 1;
                                        
                    areaList.get(areaNumIndex).setAreaName( ((HtmlInputText) component).getValue().toString() );
                }
                if(componentId.endsWith("RoomCount")){
                    
                    String[] splitItems = componentId.split("_");
                    int areaNumIndex = Integer.parseInt(splitItems[1]) - 1;
                    
                    areaList.get(areaNumIndex).setNumRooms( Integer.parseInt(((HtmlInputText) component).getValue().toString()) );
                }
                
            }
        }
        
        session.setAttribute("locationDetails", locationDetails);
        return "next";
    }
    
    public Object area_back_action() {
        
        return "back";
    }

}
