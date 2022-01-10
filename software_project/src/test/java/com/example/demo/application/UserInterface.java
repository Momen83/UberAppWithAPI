package com.example.demo.application;

import com.example.demo.core.Ride;
import com.example.demo.core.UserInfo;

import java.util.ArrayList;
import java.util.List;

public interface UserInterface   {
   void add( UserInfo person);
    UserInfo get(String name);
    List <UserInfo> getAll();
    boolean delete(String name);
    void RequestRide( Ride ride);
    public ArrayList <Ride> showRequests() ;
}
/*
DemoApplicationTests
 */