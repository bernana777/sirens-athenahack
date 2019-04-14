package com.example.sirens;

import java.util.ArrayList;
import java.util.List;

public class Net
{
    private List<Location> Course = new ArrayList<Location>();
    private int ID;
    private static int count = 0;

    public static int getCount()
    {
        return count;
    }

    public static void setCount(int count)
    {
        Net.count = count;
    }

    public List<Location> getCourse()
    {
        return Course;
    }

    public void setCourse(List<Location> course)
    {
        Course = course;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void addLocation(Location location)
    {
        this.Course.add(location);
    }

    public Location originalLocation()
    {
        return this.Course.get(0);
    }
    @Override
    public String toString()
    {
        return "Net{" +
                ", ID=" + ID +
                "Course=" + Course.toString() +'}';
    }
}
