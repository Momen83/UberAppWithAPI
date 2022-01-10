package com.example.demo.application;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.Person;
import com.example.demo.core.UserInfo;

import java.util.ArrayList;

public class Admin {
    public  String admin_Name;
    public String admin_Password;
    public  static Admin admin;
    private Admin ( String admin_Name , String admin_Password ) {
        this.admin_Name = admin_Name;
        this.admin_Password = admin_Password;
    }
   private Admin()
   {
       admin_Name="ahmed";
       admin_Password="1234";
   }
    public String getAdmin_Name ( ) {
        return admin_Name;
    }

    public void setAdmin_Name ( String admin_Name ) {
        this.admin_Name = admin_Name;
    }

    public String getAdmin_Password ( ) {
        return admin_Password;
    }

    public void setAdmin_Password ( String admin_Password ) {
        this.admin_Password = admin_Password;
    }
    public static Admin getinstence()
    {
        if(admin==null)return admin=new Admin (  );
        return admin;
    }
    public void verfiyDriver(String driverId)
    {
        System.out.println ( driverId );
        System.out.println (SystemData.getInstence ().getDriverById ( driverId )  );
        SystemData.getInstence ().getDriverById ( driverId ).setAccountState ( true );
    }
    public void susbendDriver(String driverId)
    {
        SystemData.getInstence ().getDriverById ( driverId ).setAccountState ( false );
    }
    public void susbendUser(String UserId)
    {
        SystemData.getInstence ().getUserById  ( UserId ).setAccountState ( false );
    }
    public ArrayList< DriverService > WaitedDrivers()
    {
        return SystemData.getInstence ().WaitingDrivers ();
    }
    public ArrayList< DriverService > ActiveDrivers()
    {
        return SystemData.getInstence ().DriversActive ();
    }
    public ArrayList< UserInfo >Passengers()
    {
        return SystemData.getInstence ().getPassengers ();
    }
    public ArrayList< CaptinSetPriceEvent >CaptinSetPriceEvents()

    {
        return SystemData.getInstence ().getCaptinSetEvent();
    }
    public ArrayList< UserAcceptEvent >UserAcceptEvents()

    {
        return SystemData.getInstence ().getUserAcceptEvents ();
    }
    public ArrayList< LocationEvent >SourceEvents()

    {
        return SystemData.getInstence ().SourceEvent();
    }
    public ArrayList< LocationEvent >DisEvents()

    {
        return SystemData.getInstence ().DistEvent ();
    }
    public void AddDiscountArea(String area)
    {
        SystemData.getInstence ().addDiscountArea ( area );
    }
}
