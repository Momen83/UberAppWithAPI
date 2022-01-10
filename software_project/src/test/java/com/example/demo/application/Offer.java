package com.example.demo.application;

public class Offer {
    private String driverId;
    private double price;

    public String getDriverId ( ) {
        return driverId;
    }

    public void setDriverId ( String driverId ) {
        this.driverId = driverId;
    }

    public double getPrice ( ) {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    public Offer ( String driverId , double price ) {
        this.driverId = driverId;
        this.price = price;
    }
    public Offer(){};
}
