package com.example.demo.Controller;

import com.example.demo.Controller.data;
import com.example.demo.DataBase.SystemData;
import com.example.demo.application.Offer;
import com.example.demo.application.UserService;
import com.example.demo.core.Ride;
import com.example.demo.core.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {
    UserService passengers=new UserService ();
@PostMapping("/user/register")
public void register( @RequestBody UserInfo person){
    passengers.add ( person );
}
    @PostMapping("/user/login")
    public boolean login( @RequestBody data info){
        return SystemData.getInstence ().checkDataPassengers ( info.x,info.y );
    }
    @PostMapping("/user/request")
    public  void addRequest(@RequestBody Ride req)
    {
        passengers.RequestRide(req);
    }
    @PostMapping("/user/rate")
    public void AddRate(@RequestBody data info)
    {
        passengers.RateDriver ( Integer.parseInt ( info.x  ),info.y);
    }
    @PostMapping("/user/check")
    public float checkRate(@RequestBody data driverId)
    {
        return passengers.checkAverage ( driverId.x);

    }
    @PostMapping("/user/showOffers")
    public ArrayList < Offer > showOffers(@RequestBody data Ride)
    {
        return passengers.getOffers ( Ride.x );
    }
    @PostMapping("/user/acceptOffer")
    public void acceptOffer(@RequestBody data info)
    {
        passengers.AcceptOffer ( info.x,info.y,info.l );
    }

}
