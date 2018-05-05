package splyzeservices;

public class Speaker {
    private String speakerName = null;
    private String speakerProfileInfo = null;
    
    public Speaker() {
        super();
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerProfileInfo(String speakerProfileInfo) {
        this.speakerProfileInfo = speakerProfileInfo;
    }

    public String getSpeakerProfileInfo() {
        return speakerProfileInfo;
    }
}
