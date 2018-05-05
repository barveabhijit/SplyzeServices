package splyzeservices;

import java.util.ArrayList;

public class EventDetails {
    private int eventID = 0;
    private String eventDescription = null;
    private String startDate = null;
    private String endDate = null;
    private String startTime = null;
    private String endTime = null;
    private String locationName = null;
    private String locationAddressLine1 = null;
    private String locationAddressLine2 = null;
    private String locationCity = null;
    private String locationState = null;
    private String locationZipPostalCode = null;
    private String locationCountry = null;
    private ArrayList<EventItem> eventItemList = null;
    
    
    public EventDetails() {
        super();
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationAddressLine1(String locationAddressLine1) {
        this.locationAddressLine1 = locationAddressLine1;
    }

    public String getLocationAddressLine1() {
        return locationAddressLine1;
    }

    public void setLocationAddressLine2(String locationAddressLine2) {
        this.locationAddressLine2 = locationAddressLine2;
    }

    public String getLocationAddressLine2() {
        return locationAddressLine2;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationZipPostalCode(String locationZipPostalCode) {
        this.locationZipPostalCode = locationZipPostalCode;
    }

    public String getLocationZipPostalCode() {
        return locationZipPostalCode;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setEventItemList(ArrayList<EventItem> eventItemList) {
        this.eventItemList = eventItemList;
    }

    public ArrayList<EventItem> getEventItemList() {
        return eventItemList;
    }
}
