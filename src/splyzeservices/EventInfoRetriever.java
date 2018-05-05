package splyzeservices;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class EventInfoRetriever extends SplyzeTableHandler {
    
    public EventInfoRetriever() throws ClassNotFoundException, SQLException {
        super();
        statement = null;
        resultSet = null;
        connection = null;
    }
    
    public ArrayList<EventBriefInfo> getEventList() throws ClassNotFoundException, SQLException {
               
        ArrayList<EventBriefInfo> eventList = null;
        try {            
            connection = getConnection();        
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + EVENT);
            
            while (resultSet.next()){
                if (eventList == null){
                    eventList = new ArrayList<EventBriefInfo>();   
                }   
                
                eventList.add(new EventBriefInfo(resultSet.getString(EVENT_DESC),
                                                resultSet.getInt(ID)));
            }
        }
        catch (SQLException e) {
            Close(resultSet);
            if( statement != null){
                statement.close();
            }
            releaseConnection(connection);
            throw e;            
        }
        finally{
            Close(resultSet);
            if( statement != null){
                statement.close();
            }
        releaseConnection(connection);
        }        
        
        return eventList;
    }
    
    public EventDetails returnEventDetails( int eventId, String eventCode ) throws ClassNotFoundException, SQLException {
        EventDetails eventDetails = null;

        try {
            prepareDatabaseCall();
            
            resultSet = ExecuteQuery( resultSet, 
                "SELECT * FROM " + EVENT + " " +
                "WHERE ID = " + eventId +
                " AND EVENT_CODE = " + eventCode );
                            
            if (resultSet.next()){
                    
                if (eventDetails == null){
                    eventDetails = new EventDetails();
                }
                
                eventDetails.setEventID(resultSet.getInt(ID));
                eventDetails.setEventDescription(resultSet.getString(EVENT_DESC));
                eventDetails.setStartDate(resultSet.getString(EVENT_START_DATE));
                eventDetails.setEndDate(resultSet.getString(EVENT_END_DATE));
                eventDetails.setStartTime(resultSet.getString(EVENT_START_TIME));
                eventDetails.setEndTime(resultSet.getString(EVENT_END_TIME));
                    
                int locationId = resultSet.getInt(EVENT_LOCATION_ID);
                    
                resultSet = ExecuteQuery( resultSet,
                    "SELECT * FROM " + LOCATION + " " +
                    "WHERE ID = " + locationId);
                                        
                if( resultSet.next()){
                    
                    eventDetails.setLocationName(resultSet.getString(LOCATION_NAME));
                    eventDetails.setLocationAddressLine1(resultSet.getString(LOCATION_ADDR_LN_1));
                    eventDetails.setLocationAddressLine2(resultSet.getString(LOCATION_ADDR_LN_2));
                    eventDetails.setLocationCity(resultSet.getString(LOCATION_CITY));
                    eventDetails.setLocationState(resultSet.getString(LOCATION_STATE));
                    eventDetails.setLocationZipPostalCode(resultSet.getString(LOCATION_ZIP_PSTL_CD));
                    eventDetails.setLocationCountry(resultSet.getString(LOCATION_COUNTRY));
                }
                    
                    
                resultSet = ExecuteQuery( resultSet,
                    "SELECT * FROM " + EVENT_ITEM + " " +
                    "WHERE EVENT_ID = " + eventDetails.getEventID());
                    
                if( resultSet.next()){
                    
                    ArrayList<EventItem> eventItemList = new ArrayList<EventItem>();
                    
                    while (resultSet.next()){
                        ResultSet resultSet2 = null;
                        
                        EventItem eventItem = new EventItem();
                        
                        eventItem.setItemId(resultSet.getInt(EVENT_ITEM_ID));
                        eventItem.setItemDescription(resultSet.getString(EVENT_ITEM_DESC));
                        eventItem.setStartDate(resultSet.getString(EVENT_ITEM_START_DATE));
                        eventItem.setEndDate(resultSet.getString(EVENT_ITEM_END_DATE));
                        eventItem.setStartTime(resultSet.getString(EVENT_ITEM_START_TIME));
                        eventItem.setEndTime(resultSet.getString(EVENT_ITEM_END_TIME));
                        eventItem.setHotSpot(resultSet.getString(EVENT_ITEM_HOTSPOT).equals("Y") ? true : false);
                        
                        int areaId = resultSet.getInt(EVENT_ITEM_AREA_ID);
                        int roomId = resultSet.getInt(EVENT_ITEM_ROOM_ID);
                        int speakerPanelId = resultSet.getInt(EVENT_ITEM_SPEAKER_PANEL_ID);
                        
                        resultSet2 = ExecuteQuery( resultSet2,
                                "SELECT * FROM " + LOCATION_AREA + " " +
                                "WHERE ID = " + areaId +
                                " AND LOCATION_ID = " + locationId);
                        
                        if( resultSet2.next()){
                            eventItem.setAreaName(resultSet2.getString(LOCATION_AREA_NAME));
                        }
                                                                                
                        resultSet2 = ExecuteQuery( resultSet2,
                                "SELECT * FROM " + LOCATION_ROOM + " " +
                                "WHERE ID = " + roomId +
                                " AND AREA_ID = "+ areaId +
                                " AND LOCATION_ID = " + locationId);
                        
                        if( resultSet2.next()){
                            eventItem.setAreaName(resultSet2.getString(LOCATION_ROOM_NAME));
                        }
                        
                        resultSet2 = ExecuteQuery( resultSet2,
                                "SELECT DISTINCT(NAME) FROM " + SPEAKER_PANEL + " " +
                                "WHERE ID = " +    speakerPanelId);
                        
                        if( resultSet2.next()){
                            eventItem.setSpeakerPanelName(resultSet2.getString(SPEAKER_PANEL_NAME));
                        }
                        
                        resultSet2 = ExecuteQuery( resultSet2,
                            "SELECT * FROM " + SPEAKER + " " +
                            "WHERE ID IN (" +
                            "               SELECT SPEAKER_ID FROM " + SPEAKER_PANEL + " " +
                            "               WHERE ID = " + speakerPanelId + ")");
                        
                        if( resultSet2.next()) {
                            ArrayList<Speaker> speakerList = new ArrayList<Speaker>();
                            while( resultSet2.next()){
                                Speaker speaker = new Speaker();
                                
                                speaker.setSpeakerName(resultSet2.getString(SPEAKER_NAME));
                                speaker.setSpeakerProfileInfo(resultSet2.getString(SPEAKER_PROFILE_INFO));
                                
                                speakerList.add(speaker);
                            }
                            
                            eventItem.setSpeakerList(speakerList);
                            Close(resultSet2);
                        }                            
                        
                        eventItemList.add(eventItem);
                    }
                    eventDetails.setEventItemList(eventItemList);
                    Close(resultSet);
                }
            }
        }
        
        catch (SQLException e) {
            if (resultSet != null) {
                if (!(resultSet.isClosed())) {
                    resultSet.close();
                }
            }
            cleanupDatabaseCall();
            throw e;
        } finally {
            if (resultSet != null) {
                if (!(resultSet.isClosed())) {
                    resultSet.close();
                }
            }
            cleanupDatabaseCall();

            return eventDetails;
        }
    }

}
