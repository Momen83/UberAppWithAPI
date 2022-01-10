package com.example.demo.core;

import com.example.demo.DataBase.SystemData;
import com.example.demo.application.Offer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ride {
   String source;
   String distination;
   String userId;
   String rideId;
   String RideDate;
   ArrayList< Offer >offers=new ArrayList <> (  );
   boolean AriveToSource;
   boolean AriveToDis;
   int numOfPassengers;
    public String getSource ( ) {
        return source;
    }

    public void setSource ( String source ) {
        this.source = source;
    }

    public String getDistination ( ) {
        return distination;
    }
    public void AddOffer(double price,String driverID)
    {
        offers.add (new Offer (driverID,price ));
    }
    public void setDistination ( String distination ) {
        this.distination = distination;
    }

    public String getUserId ( ) {
        return userId;
    }

    public void setUserId ( String userId ) {
        this.userId = userId;
    }

    public ArrayList < Offer > getOffers ( ) {
        ArrayList<Offer>availableOffer=new ArrayList <> (  );
        for(Offer x:offers)
        {
            if(SystemData.getInstence ().getDriverById ( x.getDriverId () ).getCurrArea ()!=null)
            {
                availableOffer.add ( x );
            }
        }
        return availableOffer;
    }

    public void setOffers ( ArrayList < Offer > offers ) {
        this.offers = offers;
    }

    public Ride ( String source , String distination , String userId , String rideId , ArrayList < Offer > offers ) {
        this.source = source;
        this.distination = distination;
        this.   userId = userId;
        this.rideId = rideId;
        this.offers = offers;
        AriveToDis=false;
        AriveToSource=false;
    }

    public Ride ( ) {
        AriveToSource=false;
        AriveToDis=false;
        String time=java.time.LocalDate.now()+"";
        RideDate=time;
    }

    public boolean isAriveToSource ( ) {
        return AriveToSource;
    }

    public void setAriveToSource ( boolean ariveToSource ) {
        AriveToSource = ariveToSource;
    }

    public boolean isAriveToDis ( ) {
        return AriveToDis;
    }

    public void setAriveToDis ( boolean ariveToDis ) {
        AriveToDis = ariveToDis;
    }
    public Offer getDriverOffer(String driverId)
    {
      for(Offer x:offers)
      {
          if(x.getDriverId ().equals ( driverId ))return x;
      }
      return null;
    }

    public String getRideId ( ) {
        return rideId;
    }

    public void setRideId ( String rideId ) {
        this.rideId = rideId;
    }

    public int getNumOfPassengers ( ) {
        return numOfPassengers;
    }

    public void setNumOfPassengers ( int numOfPassengers ) {
        this.numOfPassengers = numOfPassengers;
    }

    public String getRideDate ( ) {
        return RideDate;
    }

    public void setRideDate ( String rideDate ) {
        RideDate = rideDate;
    }
}
