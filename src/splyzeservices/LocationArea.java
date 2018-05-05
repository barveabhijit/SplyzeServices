package splyzeservices;

import java.util.ArrayList;

public class LocationArea {
    public LocationArea() {
        super();
        
        locationRoomList = new ArrayList<LocationRoom>();
    }
    
    private int areaId;
    private String areaName;
    
    private int numRooms;
    private ArrayList<LocationRoom> locationRoomList;

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setLocationRoomList(ArrayList<LocationRoom> locationRoomList) {
        this.locationRoomList = locationRoomList;
    }

    public ArrayList<LocationRoom> getLocationRoomList() {
        return locationRoomList;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public int getNumRooms() {
        return numRooms;
    }
}
