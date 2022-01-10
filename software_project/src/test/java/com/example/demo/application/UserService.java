package com.example.demo.application;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.Ride;
import com.example.demo.core.UserInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserInterface {
    private boolean firstTime;
    @Override
    public void add ( UserInfo person ) {
       SystemData.getInstence ().setPassengers ( person );
    }

    @Override
    public UserInfo get ( String name ) {
       return SystemData.getInstence ().getPassenger ( name );
    }

    @Override
    public List < UserInfo > getAll ( ) {
        return SystemData.getInstence ().getPassengers ();
    }

    @Override
    public boolean delete ( String name ) {
        if(SystemData.getInstence ().getPassenger ( name )==null)return false;
        else
        {
            SystemData.getInstence ().DeletePassenger ( name );
            return true;
        }
    }
    @Override
    public void  RequestRide( Ride ride)
    {

        //if(ride.getNumOfPassengers ()==1)
        SystemData.getInstence ().AddRide(ride);
        //else
        //{
          //SystemData.getInstence ().Grouping ( ride );
        //}
    }
    public ArrayList<Ride> showRequests()
    {
       return SystemData.getInstence ().getRides ();
    }
    public void RateDriver(int rate,String driverId)
    {
        SystemData.getInstence ().getDriverById ( driverId ).addRate (  rate);
    }
    public float checkAverage(String driverId)
    {
        return SystemData.getInstence ().getDriverById ( driverId ).calculate_Rate ();
    }
    public void AcceptOffer(String RideId,String driverId,String userId)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time=dtf.format(now);
        UserAcceptEvent c=new UserAcceptEvent ("userPrice", time,userId );
        SystemData.getInstence ().getRides ().remove (  SystemData.getInstence ().getRideById ( RideId ) );

        this.firstTime=false;
    }
    public  ArrayList<Offer> getOffers(String RideId)
    {
        return SystemData.getInstence ().getRideById ( RideId ).getOffers ();
    }

    public boolean isFirstTime ( ) {
        return firstTime;
    }

    public void setFirstTime ( boolean firstTime ) {
        this.firstTime = firstTime;
    }

    public UserService ( ) {
        this.firstTime=true;
    }
}
