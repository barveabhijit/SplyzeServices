package splyzeservices;

import java.util.ArrayList;

public class LocationDetails {
    public LocationDetails() {
        super();
        locationAreaList = new ArrayList<LocationArea>();
    }
       
    private int locationId;
    private String locationName;
    private String locationAddressLine1;
    private String locationAddressLine2;
    private String locationCity;
    private String locationState;
    private String locationZipPostalCode;
    private String locationCountry;
    
    private int numAreas;
    private ArrayList<LocationArea> locationAreaList;

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
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

    public void setLocationAreaList(ArrayList<LocationArea> locationAreaList) {
        this.locationAreaList = locationAreaList;
    }

    public ArrayList<LocationArea> getLocationAreaList() {
        return locationAreaList;
    }

    public void setNumAreas(int numAreas) {
        this.numAreas = numAreas;
    }

    public int getNumAreas() {
        return numAreas;
    }
}
