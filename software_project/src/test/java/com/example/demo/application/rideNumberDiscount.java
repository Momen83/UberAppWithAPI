package com.example.demo.application;

import com.example.demo.core.Ride;

public class rideNumberDiscount extends DiscountDecorator{
    Discount dis;
    @Override
    public double getPrice ( ) {
        return price;
    }

    @Override
    public void discount ( Ride r ) {
       if(r.getNumOfPassengers ()==2)
       {
           r.getOffers ().get (r.getOffers ().size ()-1  ).setPrice (

                   r.getOffers ().get (r.getOffers ().size ()-1  ).getPrice ()*0.95
           );
       }
    }
}
