package com.example.demo.application;

import com.example.demo.core.Ride;

public  abstract class Discount {
   protected double price;

    public double getPrice ( ) {
        return price;
    }

    public void setPrice ( int price ) {
        this.price = price;
    }
    public abstract void discount( Ride r);

    public Discount ( ) {
    }
}
