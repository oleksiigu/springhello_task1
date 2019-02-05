package hellospring.task1;

import java.util.Date;

// Contains time when random number was generated
// and generated value
public class RndInfo {
    private Date eventTime;
    private int value;

    public RndInfo(int inValue){
        value = inValue;
        eventTime = new Date();
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
