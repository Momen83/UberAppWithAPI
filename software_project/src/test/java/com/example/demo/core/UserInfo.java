package com.example.demo.core;

import com.example.demo.core.Person;

public class UserInfo extends Person {
    boolean firstTime;
    public boolean isFirstTime ( ) {
        return firstTime;
    }

    public void setFirstTime ( boolean firstTime ) {
        this.firstTime = firstTime;
    }
    public  UserInfo()
    {
        firstTime=false;
    }

}
