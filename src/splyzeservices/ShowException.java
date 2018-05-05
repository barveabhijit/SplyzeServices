package splyzeservices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="backing_showexception")
@RequestScoped
public class ShowException {
    public ShowException() {
    }

    public Object ok_action() {
        // Add event code here...
        return "ok";
    }
}
