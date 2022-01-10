package com.example.demo.application;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.EventSystem;
public class UserAcceptEvent  extends EventSystem {
    private String userId;

    public UserAcceptEvent ( String eventName , String time , String userId ) {
        super ( eventName , time );
        this.userId = userId;
    }

    @Override
    public void AddEvent ( ) {
        SystemData.getInstence ().getUserAcceptEvents ().add ( this );
    }

    public String getUserId ( ) {
        return userId;
    }

    public void setUserId ( String userId ) {
        this.userId = userId;
    }
}
