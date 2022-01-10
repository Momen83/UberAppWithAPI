package com.example.demo.Controller;

import com.example.demo.Controller.data;
import com.example.demo.application.*;
import com.example.demo.core.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdminController  {
    Admin admin;
    @PostMapping("/admin/susbenduser")
    public void susbendUser( @RequestBody data userId)
    {
        admin.getinstence ().susbendUser ( userId.x );
    }
    @PostMapping("/admin/susbendDriver")
    public void susbendDriver( @RequestBody data DriverId)
    {
        admin.getinstence ().susbendDriver ( DriverId.x );
    }
    @PostMapping("/admin/verfiyDriver")
    public void verfiyDriver( @RequestBody data DriverId)
    {
        admin.getinstence ().verfiyDriver ( DriverId.x );
    }
    @GetMapping("/admin/waitedDriver")
    public ArrayList< DriverService > watiedDriver()
    {
        return admin.getinstence ().WaitedDrivers ();
    }
    @GetMapping("/admin/activeDriver")
    public ArrayList< DriverService > ActiceDrivers()
    {
        return admin.getinstence ().ActiveDrivers ();
    }
    @GetMapping("/admin/users")
    public ArrayList< UserInfo > getPassengers()
    {
        return admin.getinstence ().Passengers ();
    }
    @GetMapping("/admin/captinSetPrice")
    public ArrayList< CaptinSetPriceEvent >getCaptinSetPriceEvents(){
        return admin.getinstence ().CaptinSetPriceEvents ();
    }
    @GetMapping("/admin/userAccept")
    public ArrayList< UserAcceptEvent >getUserAcceptOfferEvents(){
        return admin.getinstence ().UserAcceptEvents ();
    }
    @GetMapping("/admin/arriveSource")
    public ArrayList< LocationEvent >getArriveSourceEvents(){
        return admin.getinstence ().SourceEvents();
    }
    @GetMapping("/admin/arriveDis")
    public ArrayList< LocationEvent >getArriveDisEvents(){
        return admin.getinstence ().DisEvents ();
    }
    @PostMapping("/admin/discountArea")
    public void discountArea( @RequestBody String area)
    {
        admin.getinstence ().AddDiscountArea(area);
    }
}
