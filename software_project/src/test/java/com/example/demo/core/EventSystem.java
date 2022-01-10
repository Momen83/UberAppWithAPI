package com.example.demo.core;

public abstract class EventSystem {
    private String eventName;
    private String Time;

    public String getEventName ( ) {
        return eventName;
    }

    public void setEventName ( String eventName ) {
        this.eventName = eventName;
    }

    public String getTime ( ) {
        return Time;
    }

    public void setTime ( String time ) {
        Time = time;
    }

    public EventSystem ( String eventName , String time ) {
        this.eventName = eventName;
        Time = time;
    }
    public abstract void AddEvent();
}
