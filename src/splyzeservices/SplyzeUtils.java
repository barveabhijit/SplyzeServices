package splyzeservices;

public class SplyzeUtils {
    
    static final String EMPTY_STRING = "";
    
    public SplyzeUtils() {
        super();
    }
    
    public static void nullToString( String s){
        if (s == null){
            s = EMPTY_STRING;
        }
    }
}
