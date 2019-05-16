package com.example.mwa;

import com.google.android.gms.maps.model.LatLng;

public class Location {
    public LatLng latlng;
    public String title;
    public int information;
    public int image;
    public int icon;

    Location(float lat, float lng, String title, int image, int icon, int information)
    {
        latlng = new LatLng(lat, lng);
        this.title = title;
        this.information = information;
        this.image = image;
        this.icon = icon;
    }

    public String toString() {
        return title;
    }

    public static Location[] locations = {
            new Location(-33.81527f, 151.28569f, "QStation Wharf", R.drawable.qstation_wharf, -1, R.string.qstation_wharf),
            new Location(-33.82322f, 151.29819f, "Fairfax Lookout", R.drawable.fairfax_lookout, -1, R.string.fairfax_lookout),
            new Location(-33.8086f, 151.30299f, "Wastewater Treatment Plant", R.drawable.wastewater_treatment, -1, R.string.wastewater_plant),
            new Location(-33.80054f, 151.29792f, "Shelly Beach", -1, -1, -1),
            new Location(-33.81075f, 151.29755f, "Barracks Precinct", R.drawable.barracks, -1, -1),
            new Location(-33.80035f, 151.28392f, "Manly Wharf", -1, R.drawable.marker_ferry, -1),
            new Location(-33.8017f, 151.29889f, "Penguins", -1, R.drawable.marker_penguin, -1),
            new Location(-33.81478f, 151.28826f, "QStation Retreat", R.drawable.qstation_retreat,-1,  -1),
    };
}