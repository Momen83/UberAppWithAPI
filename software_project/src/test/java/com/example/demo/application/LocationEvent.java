package com.example.demo.application;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.EventSystem;

public class LocationEvent  extends EventSystem {
    private String userId;
    private String driverId;
    private boolean state;

    public LocationEvent ( String eventName , String time , String userId , String driverId , boolean state ) {
        super ( eventName , time );
        this.userId = userId;
        this.driverId = driverId;
        this.state = state;
    }

    @Override
    public void AddEvent ( ) {
        if(state==false)
        {
            SystemData.getInstence ().getLocationEvents ().add ( this );
        }
    }

    public String getUserId ( ) {
        return userId;
    }

    public void setUserId ( String userId ) {
        this.userId = userId;
    }

    public String getDriverId ( ) {
        return driverId;
    }

    public void setDriverId ( String driverId ) {
        this.driverId = driverId;
    }

    public boolean isState ( ) {
        return state;
    }

    public void setState ( boolean state ) {
        this.state = state;
    }
}
