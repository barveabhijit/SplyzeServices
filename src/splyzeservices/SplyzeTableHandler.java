package splyzeservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SplyzeTableHandler {
    private  Connection splyzeConnection = null;
    private final String DATABASE_DRIVER = "org.sqlite.JDBC";
    private final String CONNECTION_URL = "jdbc:sqlite:/Users/barvea2/splyze";
    
    protected Statement statement;
    protected ResultSet resultSet;
    protected Connection connection;
    protected int result;
    
    final String ROWCOUNT = "rowcount";
    
    //Table names
    protected final String EVENT = "event";
    protected final String EVENT_ITEM = "event_item";
    protected final String LOCATION = "location";
    protected final String LOCATION_AREA = "location_area";
    protected final String LOCATION_ROOM = "location_room";
    protected final String SPEAKER = "speaker";
    protected final String SPEAKER_PANEL = "speaker_panel";
    
    //EVENT TABLE COLUMN NAMES
    protected final String ID = "id";
    protected final String EVENT_DESC = "description";
    protected final String EVENT_START_DATE = "start_date";
    protected final String EVENT_END_DATE = "end_date";
    protected final String EVENT_START_TIME = "start_time";
    protected final String EVENT_END_TIME = "end_time";
    protected final String EVENT_LOCATION_ID = "location_id";
    protected final String EVENT_CODE = "event_code";
        
    //LOCATION TABLE COLUMN NAMES
    protected final String LOCATION_NAME = "name";
    protected final String LOCATION_ADDR_LN_1 = "address_line_1";
    protected final String LOCATION_ADDR_LN_2 = "address_line_2";
    protected final String LOCATION_CITY = "city";
    protected final String LOCATION_STATE = "state";
    protected final String LOCATION_ZIP_PSTL_CD = "zip_postal_code";
    protected final String LOCATION_COUNTRY   = "country";
    
    //EVENT_ITEM column details
    protected final String EVENT_ITEM_ID = "id";
    protected final String EVENT_ITEM_DESC = "description";
    protected final String EVENT_ITEM_AREA_ID = "area_id";
    protected final String EVENT_ITEM_ROOM_ID = "room_id";
    protected final String EVENT_ITEM_START_DATE = "start_date";
    protected final String EVENT_ITEM_END_DATE = "end_date";
    protected final String EVENT_ITEM_START_TIME = "start_time";
    protected final String EVENT_ITEM_END_TIME = "end_time";
    protected final String EVENT_ITEM_HOTSPOT = "hotspot";
    protected final String EVENT_ITEM_SPEAKER_PANEL_ID = "speaker_panel_id";
    
    //Primary Key Column for EVENT's children
    protected final String EVENT_ID = "event_id";
    
    // Primary Key Column for LOCATION's children
    protected final String LOCATION_ID = "location_id";
    
    // Primary Key Column for LOCATION AREA's children
    protected final String AREA_ID = "area_id";
    
    //LOCATION_AREA column names
    protected final String LOCATION_AREA_NAME = "name";
    
    // LOCATION_ROOM column names
    protected final String LOCATION_ROOM_NAME = "name";
    
    //SPEAKER_PANEL COLUMN NAME
    protected final String SPEAKER_PANEL_NAME = "name";
    
    //SPEAKER COLUMN NAMES
    protected final String SPEAKER_NAME = "name";
    protected final String SPEAKER_PROFILE_INFO = "profile_info";
    
    protected final String COMMA = ",";
    
    public SplyzeTableHandler() throws ClassNotFoundException, SQLException {
        super();
        
    }

    protected int getUniqueId(String tableName) throws SQLException {
        Random random = new Random();
        boolean isUnique = false;
        int uniqueId = 0;
        ResultSet uniqueCheck = null;

        while( !isUnique ){
            while (uniqueId == 0)
                uniqueId = random.nextInt();
            uniqueCheck = ExecuteQuery( uniqueCheck,
                "SELECT * FROM " + tableName + " " +
                "WHERE ID = " + uniqueId);
            if( !uniqueCheck.next() ){
                isUnique = true;
            }
        }
        
        Close(uniqueCheck);
        return uniqueId;
    }
    
    protected int getUniqueId(String tableName, String extraField, int extraId) throws SQLException {
        Random random = new Random(extraId);
        boolean isUnique = false;
        int uniqueId = 0;
        ResultSet uniqueCheck = null;

        while( !isUnique ){
            while (uniqueId == 0)
                uniqueId = random.nextInt();
            uniqueCheck = ExecuteQuery( uniqueCheck,
                "SELECT * FROM " + tableName + " " +
                "WHERE ID = " + uniqueId + 
                " AND " + extraField + " = " + extraId );
            if( !uniqueCheck.next() ){
                isUnique = true;
            }
        }
        
        Close(uniqueCheck);
        return uniqueId;
    }

    
    protected int getUniqueId(String tableName, String extraField1, int extraId1, String extraField2, int extraId2) throws SQLException {
        Random random = new Random(extraId1 & extraId2);
        boolean isUnique = false;
        int uniqueId = 0;
        ResultSet uniqueCheck = null;

        while( !isUnique ){
            while (uniqueId == 0)
                uniqueId = random.nextInt();
            uniqueCheck = ExecuteQuery( uniqueCheck,
                "SELECT * FROM " + tableName + " " +
                "WHERE ID = " + uniqueId + 
                " AND " + extraField1 + " = " + extraId1 +
                " AND " + extraField2 + " = " + extraId2 );
            if( !uniqueCheck.next() ){
                isUnique = true;
            }
        }
        
        Close(uniqueCheck);
        return uniqueId;
    }
    
    protected ResultSet ExecuteQuery(ResultSet resultSet, String query) throws SQLException {
        
        Close(resultSet);
        
        resultSet = statement.executeQuery(query);
        
        return resultSet;
    }


    protected Connection getConnection() throws ClassNotFoundException, SQLException {

        if( splyzeConnection == null ){
            Class.forName(DATABASE_DRIVER);
            splyzeConnection = DriverManager.getConnection(CONNECTION_URL);            
        }
        
        return splyzeConnection;
    }
    
    protected void releaseConnection( Connection connection) throws SQLException {
        if( connection != null ){
            
            connection.close();
            connection = null;
        }
    }
    protected void prepareDatabaseCall() throws ClassNotFoundException, SQLException {
        try {
            connection = getConnection();
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (SQLException e) {
            throw e;
        }

        try {
            if (statement == null ){
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            releaseConnection(connection);
            throw e;
        }
        
    }
    
    protected void cleanupDatabaseCall() throws SQLException {
        if( statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                releaseConnection(connection);                
            }
            releaseConnection(connection);
        }
    }

    protected void Close(ResultSet resultSet) throws SQLException {
        if( resultSet != null)
            if (!resultSet.isClosed() )
                resultSet.close();
        
    }
}
