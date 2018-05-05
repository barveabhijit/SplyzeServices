package splyzeservices;

import java.sql.SQLException;
import java.util.List;

public class EventInfoInserter extends SplyzeTableHandler{
    public EventInfoInserter() throws ClassNotFoundException, SQLException {
        super();
    }
    
    public int addLocation( String name, String address_line_1, String address_line_2, String city,
                             String state, String zip_postal_code, String country) throws ClassNotFoundException, SQLException,
                                                                          Exception {
        int locationId = 0;
        if( name == null || 
            address_line_1 == null || 
            address_line_2 == null || 
            city == null ||
            state == null ||
            zip_postal_code == null ||
            country == null){
            
            StringBuilder nullList = new StringBuilder();
            
            if( name == null )
                nullList.append("[Name]");
            if( address_line_1 == null )
                nullList.append("[Address Line 1]");
            if( address_line_2 == null )
                nullList.append("[Address Line 2]");
            if( city == null )
                nullList.append("[City]");
            if( state == null )
                nullList.append("[State]");
            if( zip_postal_code == null )
                nullList.append("[Zip/ Postal Code]");
            if( country == null )
                nullList.append("[Country]");
            
            throw(new Exception("Cannot create Location record.  " + nullList + " cannot be zero or null."));
            
            }

        try {
            prepareDatabaseCall();
            
            if (statement != null ){
                //Create a unique random number for Id
                 locationId = getUniqueId(LOCATION );
                
                result = statement.executeUpdate(
                    "INSERT INTO " + LOCATION + " " +
                    "VALUES("   + locationId + COMMA 
                                + name + COMMA
                                + address_line_1 + COMMA
                                + address_line_2 + COMMA
                                + city + COMMA
                                + state + COMMA
                                + zip_postal_code + COMMA
                                + country + ")"
                    );
            }
            
        } catch (SQLException e) {
            Close(resultSet);
            cleanupDatabaseCall();
            throw e;
        }
        finally {
            Close(resultSet);
            cleanupDatabaseCall();
            return locationId;
        }
    }
    
    public int addLocationArea( int locationId, String name ) throws ClassNotFoundException, SQLException, Exception {
        int areaId = 0;
        
        if( locationId == 0 ||
            name == null ){
            
            StringBuilder nullList = new StringBuilder();
            
            if( locationId == 0 )
                nullList.append("[Location Id]");
            if( name == null )
                nullList.append("[name]");
            throw(new Exception("Cannot create Location Area record.  " + nullList + " cannot be zero or null."));
            }

        try {
            prepareDatabaseCall();
            
            if( statement != null ){
                areaId = getUniqueId( LOCATION_AREA, LOCATION_ID, locationId );
                
                result = statement.executeUpdate( 
                    "INSERT INTO " + LOCATION_AREA + " " +
                    "VALUES("   + areaId + COMMA
                                + locationId + COMMA
                                + name + ")" 
                    
                    );
            }
            
        } catch (SQLException e) {
            Close(resultSet);
            cleanupDatabaseCall();
            throw e;
        }
        finally {
            Close(resultSet);
            cleanupDatabaseCall();
            return areaId;
        }
    }

    public int addLocationRoom( int locationId, int areaId, String name ) throws ClassNotFoundException, SQLException,
                                                                               Exception {
        
        int roomId = 0;
        
        if( locationId == 0 ||
            areaId == 0 ||
            name == null ){
            
            StringBuilder nullList = new StringBuilder();
            
            if( locationId == 0 )
                nullList.append("[Location Id]");
            if( areaId == 0 )
                nullList.append("[Area Id]");
            if( name == null )
                nullList.append("[Name]");
            
            throw(new Exception("Cannot create Location Room record.  " + nullList + " cannot be zero or null."));
            }

        try {
            prepareDatabaseCall();
            
            if( statement != null ){
                roomId = getUniqueId( LOCATION_ROOM, LOCATION_ID, locationId, AREA_ID, areaId );
                
                result = statement.executeUpdate( 
                    "INSERT INTO " + LOCATION_ROOM + " " +
                    "VALUES("   + roomId + COMMA 
                                + locationId + COMMA
                                + areaId + COMMA
                                + name + ")" 
                    
                    );
            }
            
        } catch (SQLException e) {
            Close(resultSet);
            cleanupDatabaseCall();
            throw e;
        }
        finally {
            Close(resultSet);
            cleanupDatabaseCall();
            return roomId;
        }
    }
    
    public int addSpeaker( String name, String profileInfo ) throws ClassNotFoundException, SQLException, Exception {
        int speakerId = 0;
        
        if( name == null ){
            StringBuilder nullList = new StringBuilder();
            
            if( name == null )
                nullList.append("[Name]");
            
            throw(new Exception("Cannot create Speaker record.  " + nullList + " cannot be zero or null."));
        }

        try {
            prepareDatabaseCall();
            
            if( statement != null ){
               speakerId = getUniqueId(LOCATION );
                
                result = statement.executeUpdate( 
                    "INSERT INTO " + SPEAKER + " " +
                    "VALUES("   + speakerId + COMMA 
                                + name + COMMA
                                + profileInfo + ")" 
                    );
            }
            
        } catch (SQLException e) {
            Close(resultSet);
            cleanupDatabaseCall();
            throw e;
        }
        finally {
            Close(resultSet);
            cleanupDatabaseCall();
            return speakerId;
        }
    }

    public int addSpeakerPanel( List speakerIdList, String name) throws ClassNotFoundException, SQLException,
                                                                       Exception {
        int speakerPanelId = 0;
        
        if( speakerIdList == null ||
            name == null ){
            
            StringBuilder nullList = new StringBuilder();
            
            if( speakerIdList == null )
                nullList.append("[Speaker Id List]");
            if( name == null )
                nullList.append("[Name]");
            
            throw(new Exception("Cannot create Speaker panel record.  " + nullList + " cannot be zero or null."));
            }
        
        if( speakerIdList.isEmpty()){
            throw(new Exception("Cannot create Speaker panel record.  Speaker Id List cannot empty."));
        }

        try {
            prepareDatabaseCall();
            
            if( statement != null ){
                speakerPanelId = getUniqueId(SPEAKER_PANEL);
                
                for ( int speakerId = 0; speakerId < speakerIdList.size(); speakerId++ ){
                    result = statement.executeUpdate( 
                        "INSERT INTO " + SPEAKER_PANEL + " " +
                        "VALUES("   + speakerPanelId + COMMA 
                                    + speakerId + COMMA
                                    + name + ")" 
                        );                    
                }
            }
            
        } catch (SQLException e) {
            Close(resultSet);
            cleanupDatabaseCall();
            throw e;
        }
        finally {
            Close(resultSet);
            cleanupDatabaseCall();
            return speakerPanelId;
        }
    }
    
    public int addEvent (String description, String startDate, String endDate, 
                         String startTime, String endTime, int locationId, String eventCode) throws ClassNotFoundException, SQLException, Exception {
                             
        int eventId = 0;
        
        if( description == null ||
            startDate == null ||
            endDate == null ||
            startTime == null ||
            endTime == null ||
            eventCode == null ){
            
            StringBuilder nullList = new StringBuilder();
            
            if( description == null )
                nullList.append("[Description]");
            if( startDate == null )
                nullList.append("[Start Date]");
            if( endDate == null )
                nullList.append("[End Date]");
            if( startTime == null )
                nullList.append("[Start Time]");
            if( endTime == null )
                nullList.append("[End Time]");
            if( eventCode == null )
                nullList.append("[Event Code]");
            
            throw(new Exception("Cannot create Event record.  " + nullList + " cannot be zero or null."));
            }

        try {
            prepareDatabaseCall();
            
            if( statement != null ) {
                eventId = getUniqueId(EVENT);
                
                result = statement.executeUpdate(
                    "INSERT INTO " + EVENT + " " +
                    "VALUES("   + eventId + COMMA 
                                + description + COMMA
                                + startDate + COMMA
                                + endDate + COMMA
                                + startTime + COMMA
                                + endTime + COMMA
                                + locationId + COMMA
                                + eventCode + ")"
                    );
                
            }
                            
            
        } catch (SQLException e) {
            Close(resultSet);
            cleanupDatabaseCall();
            throw e;
        }
        finally {
            Close(resultSet);
            cleanupDatabaseCall();
            return eventId;
        }
    }
    
    public int addEventItem( int eventId, int locationId, int areaId, int roomId,  
                             String startDate, String endDate, String startTime, String endTime,
                             String description, String speakerPanelId, String hotspot) throws ClassNotFoundException, SQLException, Exception {
        int eventItemId = 0;
        
        if( eventId == 0 ||
            startDate == null ||
            endDate == null ||
            startTime == null ||
            endTime == null ||
            description == null ||
            hotspot == null){
            
            StringBuilder nullList = new StringBuilder();
            
            if( eventId == 0 )
                nullList.append("[Event Id]");
            if( startDate == null )
                nullList.append("[Start Date]");
            if( endDate == null )
                nullList.append("[End Date]");
            if( startTime == null )
                nullList.append("[Start Time]");
            if( endTime == null )
                nullList.append("[End Time]");
            if( description == null )
                nullList.append("[Description]");
            if( hotspot == null )
                nullList.append("[Hotspot flag]");
            
            throw(new Exception("Cannot create Event record.  " + nullList + " cannot be zero or null."));
            }

        try {
            prepareDatabaseCall();
            
            if( statement != null){
                eventItemId = getUniqueId(EVENT_ITEM, EVENT_ID, eventId);
                
                result = statement.executeUpdate(
                    "INSERT INTO " + EVENT_ITEM + " " +
                    "VALUES("   + eventItemId + COMMA 
                                + eventId + COMMA
                                + locationId + COMMA
                                + areaId + COMMA
                                + roomId + COMMA
                                + startDate + COMMA
                                + endDate + COMMA
                                + startTime + COMMA
                                + endTime + COMMA
                                + description + COMMA
                                + speakerPanelId + COMMA
                                + hotspot + ")"
                    );
            }
            
        } catch (SQLException e) {
            Close(resultSet);
            cleanupDatabaseCall();
            throw e;
        }
        finally {
            Close(resultSet);
            cleanupDatabaseCall();
            return eventId;
        }
    }
    

}
