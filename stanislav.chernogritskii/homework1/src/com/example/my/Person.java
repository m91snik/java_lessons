package com.example.my;

/**
 * Created by stanislav on 16.07.15.
 */
public class Person {
    
    public String name = "Stas";
    public int age = 25;

    public static String showGeoInfo() {
        Place place = new Place();
        return "City: " + place.city + ", region: " + place.region;
    }
}
