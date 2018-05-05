package splyzeservices;

public class LocationRoom {
    public LocationRoom() {
        super();
    }
    
    private int roomId;
    private String roomName;

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }
}
