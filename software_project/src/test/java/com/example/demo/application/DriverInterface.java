package com.example.demo.application;

import java.util.List;

public interface DriverInterface {
    void add( DriverService person);
    DriverService get( String name);
    List < DriverService > getAll();
    boolean delete(String name);
}
