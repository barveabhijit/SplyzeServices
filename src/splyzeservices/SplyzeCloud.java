package splyzeservices;

import java.sql.SQLException;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService

public class SplyzeCloud {
    public SplyzeCloud() {
        super();
    }
    
    @WebMethod
    public ArrayList<EventBriefInfo> returnEventList () {
        ArrayList<EventBriefInfo> eventList = null;

        try {
            eventList = new EventInfoRetriever().getEventList();
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
        return eventList;
    }
    
    @WebMethod
    public EventDetails fetchEventDetails ( int eventId, String eventCode  ) {
        EventDetails eventDetails = null;

        try {
            eventDetails = new EventInfoRetriever().returnEventDetails(eventId, eventCode);
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
        return eventDetails;
    }
}
