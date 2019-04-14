package com.example.sirens;

import java.sql.Time;

public class Location
{
    private double longitude;
    private double latitude;
    private Time time;

    public Location(double longitude, double latitude, Time time)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public Time getTime()
    {
        return time;
    }

    public void setTime(Time time)
    {
        this.time = time;
    }

    @Override
    public String toString()
    {
        return "Location{" +
                "longitude= " + longitude +
                ", latitude= " + latitude +
                ", time= " + time +
                "}\n";
    }
}
