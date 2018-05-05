package splyzeservices;

import java.util.ArrayList;

public class EventItem {
    private int itemId = 0;
    private String itemDescription = null;
    private String areaName = null;
    private String roomName = null;
    private String startDate = null;
    private String endDate = null;
    private String startTime = null;
    private String endTime = null;
    private boolean hotSpot = false;
    private String speakerPanelName = null;
    private ArrayList<Speaker> speakerList = null;
    
    public EventItem() {
        super();
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
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

    public void setHotSpot(boolean hotSpot) {
        this.hotSpot = hotSpot;
    }

    public boolean isHotSpot() {
        return hotSpot;
    }

    public void setSpeakerList(ArrayList<Speaker> speakerList) {
        this.speakerList = speakerList;
    }

    public ArrayList<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerPanelName(String speakerPanelName) {
        this.speakerPanelName = speakerPanelName;
    }

    public String getSpeakerPanelName() {
        return speakerPanelName;
    }
}
