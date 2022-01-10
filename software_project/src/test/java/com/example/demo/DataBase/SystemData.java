package com.example.demo.DataBase;

import com.example.demo.application.*;
import com.example.demo.core.Ride;
import com.example.demo.core.UserInfo;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemData {
    private ArrayList< UserInfo >Passengers=new ArrayList <> (  );
    private ArrayList< Ride >Rides=new ArrayList <> (  );
    private ArrayList< DriverService >Drivers=new ArrayList <> (  );
    private Notify notifyDriver=new Notify ();
    private static SystemData instence;
    private ArrayList<CaptinSetPriceEvent>CaptinSetEvent=new ArrayList <> (  );
    private ArrayList<UserAcceptEvent >userAcceptEvents=new ArrayList <> (  );
    private ArrayList<LocationEvent>locationEvents=new ArrayList <> (  );
    private ArrayList<String>discountArea=new ArrayList <> (  );
    private HashMap<String,ArrayList<Ride>>RideGroup=new HashMap <> (  );
    private Discount discountOpption;

    public void setPassengers ( ArrayList < UserInfo > passengers ) {
        Passengers = passengers;
    }

    public void setDrivers ( ArrayList < DriverService > drivers ) {
        Drivers = drivers;
    }
    public ArrayList<Ride>getRidesWithName(String source)
    {
        ArrayList<Ride>ans=new ArrayList <> (  );
        for ( Ride rid:Rides )
        {
            if(rid.getSource ().equals ( source ))
            {
                ans.add ( rid );
            }
        }
        return ans;
    }
    public Notify getNotifyDriver ( ) {
        return notifyDriver;
    }

    public void setNotifyDriver ( Notify notifyDriver ) {
        this.notifyDriver = notifyDriver;
    }

    private SystemData()
    {

    }
    public  static SystemData getInstence()
    {
        if(instence==null)
        {
            instence=new SystemData ();
        }
         return  instence;
    }

    public ArrayList < UserInfo > getPassengers ( ) {
        return Passengers;
    }
    public ArrayList < DriverService > getDrivers ( ) {
        return Drivers;
    }
    public UserInfo getPassenger(String name){

        for ( int i=0;i<Passengers.size ();i++ )
        {
            if(Passengers.get ( i ).getUserName ().equals ( name ))
            {
                return Passengers.get ( i );
            }
        }
        return null;
    }
    public DriverService getDriver( String name){

        for ( int i=0;i<Drivers.size ();i++ )
        {
            if(Drivers.get ( i ).getUserName ().equals ( name ))
            {
                return Drivers.get ( i );
            }
        }
        return null;
    }

    public void setPassengers ( UserInfo  passenger ) {
        Passengers.add ( passenger );
    }

    public void setDrivers ( DriverService passenger ) {
        Drivers.add ( passenger );
    }
    public ArrayList < Ride > getRides ( ) {
        return Rides;
    }

    public void setRides ( ArrayList < Ride > rides ) {
        Rides = rides;
    }
    public  void DeletePassenger(String name)
    {
        for ( int i=0;i<Passengers.size ();i++ )
        {
            if(Passengers.get ( i ).getUserName ().equals ( name ))
            {
               Passengers.remove ( i );
            }
        }
    }
    public  void DeleteDriver(String name)
    {
        for ( int i=0;i<Drivers.size ();i++ )
        {
            if(Drivers.get ( i ).getUserName ().equals ( name ))
            {
                Drivers.remove ( i );
            }
        }
    }
    public void AddRide( Ride ride )
    {
        Rides.add (ride );
    }
    public UserInfo getUserById(String userId)
    {
        for ( int i=0;i<Passengers.size ();i++ )
        {
            if(Passengers.get ( i ).getUserId ().equals ( userId ))return Passengers.get ( i );
        }
        return null;
    }
    public DriverService getDriverById( String userId)
    {
        for ( int i=0;i<Drivers.size ();i++ )
        {
            if(Drivers.get ( i ).getUserId ().equals ( userId ))return Drivers.get ( i );
        }
        return null;
    }
    public Ride getRideById(String RideId)
    {
        for ( int i=0;i<Rides.size ();i++ )
        {
            if(Rides.get ( i ).getRideId ().equals ( RideId ))return Rides.get ( i );
        }
        return null;
    }
    public ArrayList< DriverService >WaitingDrivers()
    {
        ArrayList< DriverService >waitedDriver=new ArrayList <> ();
        for ( DriverService x:Drivers )
        {
            if(x.getAccountState ()==false)waitedDriver.add ( x );
        }
        return waitedDriver;
    }
    public ArrayList< DriverService >DriversActive()
    {
        ArrayList< DriverService >DriverActive=new ArrayList <> ();
        for ( DriverService x:Drivers )
        {
            if(x.getAccountState ()==true)DriverActive.add ( x );
        }
        return DriverActive;
    }

    public ArrayList < CaptinSetPriceEvent > getCaptinSetEvent ( ) {
        return CaptinSetEvent;
    }

    public void setCaptinSetEvent ( ArrayList < CaptinSetPriceEvent > captinSetEvent ) {
        CaptinSetEvent = captinSetEvent;
    }

    public ArrayList < UserAcceptEvent > getUserAcceptEvents ( ) {
        return userAcceptEvents;
    }

    public void setUserAcceptEvents ( ArrayList < UserAcceptEvent > userAcceptEvents ) {
        this.userAcceptEvents = userAcceptEvents;
    }

    public ArrayList < LocationEvent > getLocationEvents ( ) {
        return locationEvents;
    }

    public void setLocationEvents ( ArrayList < LocationEvent > locationEvents ) {
        this.locationEvents = locationEvents;
    }
    public ArrayList<LocationEvent>SourceEvent()
    {
        ArrayList<LocationEvent>locEvent=new ArrayList <> (  ) ;
        for(LocationEvent e: locationEvents)
        {
            if(e.isState ()==false){
                locEvent.add ( e );
            }
        }
        return  locEvent;
    }
    public ArrayList<LocationEvent>DistEvent()
    {
        ArrayList<LocationEvent>locEvent=new ArrayList <> (  ) ;
        for(LocationEvent e: locationEvents)
        {
            if(e.isState ()==true){
                locEvent.add ( e );
            }
        }
        return  locEvent;
    }

    public ArrayList < String > getDiscountArea ( ) {
        return discountArea;
    }

    public void setDiscountArea ( ArrayList < String > discountArea ) {
        this.discountArea = discountArea;
    }
    public void addDiscountArea(String area)
    {
        discountArea.add ( area );
    }
    public boolean checkDiscount(String area)
    {
        for(String x:discountArea)
        {
            if(x.equals ( area ))return true;
        }
        return false;
    }
    public  void Grouping(Ride r)
    {
        ArrayList<Ride>d=RideGroup.get ( r.getSource ());
        if(d==null)return;
        int target=r.getNumOfPassengers ();
        ArrayList<Ride>temp=new ArrayList <> (  );
        for(Ride x:d )
        {
            if(x.getNumOfPassengers ()==target)
            {
                temp.add ( x );
            }
        }
        if(temp.size ()<target)
        {
            d.add ( r );
        }
        else
        {
            Rides.add ( r );
            for(int i=0;i<target;i++)
            {
                d.remove ( temp.get ( i ) );
            }
        }
    }
    public boolean isHoliday(String date)
    {
        if(date.contains ( "07-01" ) ||date.contains ( "25-01" )||date.contains ( "25-04" )
         ||date.contains ( "06-10" ) ||date.contains ( "21-11" ) ||date.contains ( "08-03" ))
            return true;
        return false;
    }
    public void Discount(Ride ride)
    {
        discountOpption =new AdminDiscount ();
        discountOpption.discount ( ride );
        discountOpption =new BirthDayDiscount ();
        discountOpption.discount ( ride );
        discountOpption =new puplicHolidayDiscount ();
        discountOpption.discount ( ride );
        discountOpption=new rideNumberDiscount ();
        discountOpption.discount ( ride );
        discountOpption=new firstTimeDiscount();
        discountOpption.discount ( ride );
    }
    public boolean checkDataPassengers ( String userName, String Password)
    {
        for ( int i=0;i<Passengers.size ();i++ )
        {
            if(Passengers.get ( i ).getUserName ().equals ( userName )
            &&Passengers.get ( i ).getUserPassword ().equals ( Password ))
            {return  true;}
        }
        return  false;
    }
    public boolean checkDataDrivers ( String userName, String Password)
    {
        //System.out.println (userName+" "+Password);
        for ( int i=0;i<Drivers.size ();i++ )
        {
            System.out.println ( Drivers.get ( i ).getAccountState () );
            if(Drivers.get ( i ).getUserName ().equals ( userName )
                    &&Drivers.get ( i ).getUserPassword ().equals ( Password )&&
                    Drivers.get ( i ).getAccountState ()==true)
            {return  true;}
        }
        return  false;
    }
}
