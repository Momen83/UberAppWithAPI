package com.example.demo.application;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.EventSystem;

public class CaptinSetPriceEvent extends EventSystem {

    private String captinID;
    private double price;

    public CaptinSetPriceEvent ( String eventName , String time , String captinID , double price ) {
        super ( eventName , time );
        this.captinID = captinID;
        this.price = price;
    }

    @Override
    public void AddEvent ( ) {

        SystemData.getInstence ().getCaptinSetEvent ().add ( this );
    }

    public String getCaptinID ( ) {
        return captinID;
    }

    public void setCaptinID ( String captinID ) {
        this.captinID = captinID;
    }

    public double getPrice ( ) {
        return price;
    }

    public void setPrice ( int price ) {
        this.price = price;
    }
}
