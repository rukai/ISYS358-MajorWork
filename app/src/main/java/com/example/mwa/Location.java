package com.example.mwa;

import com.google.android.gms.maps.model.LatLng;

public class Location {
    public LatLng latlng;
    public String title;

    Location(float lat, float lng, String title)
    {
        latlng = new LatLng(lat, lng);
        this.title = title;
    }
}