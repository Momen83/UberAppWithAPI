package com.example.demo.core;

import com.example.demo.DataBase.SystemData;
import com.example.demo.application.DriverInterface;
import com.example.demo.application.DriverService;

import java.util.List;

public class DriverInfo implements DriverInterface {
    @Override
    public void add ( DriverService person ) {
        SystemData.getInstence ().setDrivers ( person );
    }

    @Override
    public DriverService get ( String name ) {
        return SystemData.getInstence ().getDriver ( name );
    }

    @Override
    public List < DriverService > getAll ( ) {
       return SystemData.getInstence ().getDrivers ();
    }

    @Override
    public boolean delete ( String name ) {
        if(SystemData.getInstence ().getDriver ( name )==null)return false;
        else
        {
            SystemData.getInstence ().DeleteDriver ( name );
            return true;
        }
    }

}
