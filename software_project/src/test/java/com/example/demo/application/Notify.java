package com.example.demo.application;

import com.example.demo.DataBase.SystemData;
import com.example.demo.core.Ride;

import java.util.ArrayList;

public class Notify implements NotifyInterface {

    @Override
    public ArrayList<Ride> notify ( ArrayList<String>area,String driverId) {
        ArrayList<Ride>ans=new ArrayList <> (  );
        String Ap="";
        if(SystemData.getInstence ().getDriverById ( driverId ).inTrip==false)
        {
            Ap=SystemData.getInstence ().getDriverById ( driverId ).getCurrArea ();
        }
        for (Ride x: SystemData.getInstence ().getRides () )
        {
            for ( String d:area )
            {
                if(x.getSource ().equals ( d )||Ap.equals ( x.getSource () ))
                {
                    ans.add ( x );
                    break;
                }
            }
        }
        return ans;
    }
}
