package com.example.earthquake;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Earthquake extends AppCompatActivity {

    private String mId;
    private Date mDate;
    private String mDetails;
    private Location mLocation;
    private double mMagnitude;
    private String mLink;

    public String getID() {return mId;
    }
    public Date getDate() {
        return mDate;
    }
    public String getDetails() {
        return mDetails;
    }
    public Location getLocation() {
        return mLocation;
    }
    public double getMagnitude() {
        return mMagnitude;
    }
    public String getLink(){
        return mLink;
    }

    public Earthquake(String id, Date date, String details, Location location, String link, double magnitude){
        mId = id;
        mDate = date;
        mMagnitude = magnitude;
        mDetails = details;
        mLocation = location;
        mLink = link;

    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH.mm", Locale.US);
        String dateString = sdf.format(mDate);
        return dateString + ":" + mMagnitude + " " + mDetails;
         }

    @Override
    public boolean equals (Object obj){
        if (obj instanceof Earthquake){
            return (((Earthquake) obj). getID().contentEquals(mId));
        }
        else
            return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_earthquake);
    }
}
