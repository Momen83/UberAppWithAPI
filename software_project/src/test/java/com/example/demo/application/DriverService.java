package com.example.demo.application;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.Person;
import com.example.demo.core.Ride;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DriverService extends Person {
   private String licenceId;
   private String nationalId;
   private ArrayList<String>Fav=new ArrayList <> (  );
   private ArrayList<Integer>Rating=new ArrayList <> (  );
   private String currArea;
   boolean inTrip;
    public DriverService ( String licenceId , String nationalId , ArrayList < String > fav , ArrayList < Integer > rating ) {
        this.licenceId = licenceId;
        this.nationalId = nationalId;
        Fav = fav;
        Rating = rating;
        inTrip=false;
        currArea="";
    }
    public DriverService (){
     inTrip=false;
     currArea="";
    };
    public String getLicenceId ( ) {
        return licenceId;
    }

    public void setLicenceId ( String licenceId ) {
        this.licenceId = licenceId;
    }

    public String getNationalId ( ) {
        return nationalId;
    }

    public void setNationalId ( String nationalId ) {
        this.nationalId = nationalId;
    }

    public ArrayList < String > getFav ( ) {
        return Fav;
    }

    public void setFav ( ArrayList < String > fav ) {
        Fav = fav;
    }

    public ArrayList < Integer > getRating ( ) {
        return Rating;
    }

    public void setRating ( ArrayList < Integer > rating ) {
        Rating = rating;
    }
    public void setFav ( String area ) {
        Fav.add ( area );
    }
    void addRate(int rate)
    {
       Rating.add ( rate );
    }
    float calculate_Rate()
    {
        float sum=0;
        for ( int i=0;i<Rating.size ();i++ )
        {
            sum+=Rating.get ( i );
        }
        return sum/Rating.size ();
    }
    public ArrayList< Ride >getNotifcation()
    {
        if(this.inTrip==true)return null;
       return SystemData.getInstence ().getNotifyDriver ().notify ( getFav (),this.getUserId () );
    }
    public void setPrice(String RideId,String driverId,double price)
    {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time=dtf.format(now);
        CaptinSetPriceEvent c=new CaptinSetPriceEvent ("captinSetprice", time,driverId,price);
        SystemData.getInstence ().getRideById ( RideId ).AddOffer ( price,this.getUserId () );
        SystemData.getInstence ().Discount ( SystemData.getInstence ().getRideById ( RideId ) );
        c.AddEvent ();
    }
    public void arrivedToSource(String RideId,String driverId)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        currArea=SystemData.getInstence ().getRideById ( RideId ).getSource ();
        inTrip=true;
        LocalDateTime now = LocalDateTime.now();
        String time=dtf.format(now);
        LocationEvent c=new LocationEvent ("catpinArriveToSource", time,
                SystemData.getInstence ().getRideById ( RideId ).getUserId (),driverId,false);
        c.AddEvent ();
        SystemData.getInstence ().getRideById ( RideId ).setAriveToSource ( true );
    }
    public void arrivedToDis(String RideId,String driverId)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        currArea=SystemData.getInstence ().getRideById ( RideId ).getDistination ();
        inTrip=false;
        LocalDateTime now = LocalDateTime.now();
        String time=dtf.format(now);
        LocationEvent c=new LocationEvent ("catpinArriveToDis", time,
                SystemData.getInstence ().getRideById ( RideId ).getUserId (),driverId,true);
        c.AddEvent ();
        SystemData.getInstence ().getRideById ( RideId ).setAriveToSource ( true );
    }

    public String getCurrArea ( ) {
        return currArea;
    }

    public void setCurrArea ( String currArea ) {
        this.currArea = currArea;
    }
}
