package com.example.mwa;

import com.google.android.gms.maps.model.LatLng;

public class Location {
    public LatLng latlng;
    public String title;

    Location(float lat, float lng, String title /*, String information, List<Image> images*/)
    {
        latlng = new LatLng(lat, lng);
        this.title = title;
    }

    public String toString() {
        return title;
    }

    public static Location[] locations = {
            new Location(-33.81527f, 151.28569f, "QStation Wharf"),
            new Location(-33.82322f, 151.29819f, "Fairfax Lookout"),
            new Location(-33.8086f,  151.30299f, "North Head Wastewater Treatment Plant"),
            new Location(-33.80054f, 151.29792f, "Shelly Beach"),
            new Location(-33.81075f, 151.29755f, "The Baracks Precinct"),
    };
}