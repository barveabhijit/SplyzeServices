package splyzeservices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name="backing_registerlocation")
@RequestScoped
public class RegisterLocation {
    private HtmlInputText country;
    private HtmlInputText zip_postal_code;
    private HtmlInputText state;
    private HtmlInputText city;
    private HtmlInputText address_line_2;
    private HtmlInputText address_line_1;
    private HtmlInputText name;
    private HtmlInputText num_areas;
    private HtmlForm location_entry_form;
    private HtmlCommandButton location_next;
    private HtmlCommandButton cancel;

    public RegisterLocation() {
    }

    public void setCountry(HtmlInputText country) {
        this.country = country;
    }

    public HtmlInputText getCountry() {
        return country;
    }

    public void setZip_postal_code(HtmlInputText zip_postal_code) {
        this.zip_postal_code = zip_postal_code;
    }

    public HtmlInputText getZip_postal_code() {
        return zip_postal_code;
    }

    public void setState(HtmlInputText state) {
        this.state = state;
    }

    public HtmlInputText getState() {
        return state;
    }

    public void setCity(HtmlInputText city) {
        this.city = city;
    }

    public HtmlInputText getCity() {
        return city;
    }

    public void setAddress_line_2(HtmlInputText address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public HtmlInputText getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_1(HtmlInputText address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public HtmlInputText getAddress_line_1() {
        return address_line_1;
    }

    public void setName(HtmlInputText name) {
        this.name = name;
    }

    public HtmlInputText getName() {
        return name;
    }


    public Object location_next_action() {
        // Add event code here...
        
        HttpServletRequest request = (HttpServletRequest) (FacesContext.getCurrentInstance().getExternalContext().getRequest());
        HttpSession session = request.getSession();
        
        LocationDetails locationDetails = new LocationDetails();
        
        locationDetails.setLocationName(this.getName().getValue().toString());
        locationDetails.setLocationAddressLine1(this.getAddress_line_1().getValue().toString());
        locationDetails.setLocationAddressLine2(this.getAddress_line_2().getValue().toString());
        locationDetails.setLocationCity(this.getCity().getValue().toString());
        locationDetails.setLocationState(this.getState().getValue().toString());
        locationDetails.setLocationZipPostalCode(this.getZip_postal_code().getValue().toString());
        locationDetails.setLocationCountry(this.getCountry().getValue().toString());
        locationDetails.setNumAreas(Integer.parseInt(this.getNum_areas().getValue().toString()));
        
        session.setAttribute("locationDetails", locationDetails);
        
        return "next";        
    }

    public void setNum_areas(HtmlInputText num_areas) {
        this.num_areas = num_areas;
    }

    public HtmlInputText getNum_areas() {
        return num_areas;
    }

    public void setLocation_entry_form(HtmlForm location_entry_form) {
        this.location_entry_form = location_entry_form;
    }

    public HtmlForm getLocation_entry_form() {
        return location_entry_form;
    }

    public void setLocation_next(HtmlCommandButton location_next) {
        this.location_next = location_next;
    }

    public HtmlCommandButton getLocation_next() {
        return location_next;
    }

    public Object cancel_action() {
        // Add event code here...
        return "cancel";
    }

    public void setCancel(HtmlCommandButton cancel) {
        this.cancel = cancel;
    }

    public HtmlCommandButton getCancel() {
        return cancel;
    }
}
