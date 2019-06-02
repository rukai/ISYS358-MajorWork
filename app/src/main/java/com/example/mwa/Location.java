package com.example.mwa;

import com.google.android.gms.maps.model.LatLng;

public class Location {
    public LatLng latlng;
    public String title;
    public int[] information;
    public int[] image;
    public int icon;

    Location(float lat, float lng, String title, int[] image, int icon, int[] information)
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
            new Location(-33.81527f, 151.28569f, "QStation Wharf", new int[] {R.drawable.qstation_wharf}, -1, new int[] {R.string.qstation_wharf}),
            new Location(-33.82322f, 151.29819f, "Fairfax Lookout", new int[] {R.drawable.fairfax_lookout}, -1, new int[] {R.string.fairfax_lookout}),
            new Location(-33.8086f,  151.30299f, "Wastewater Treatment Plant", new int[] {R.drawable.wastewater_treatment}, -1, new int[] {R.string.wastewater_plant}),
            new Location(-33.80054f, 151.29792f, "Shelly Beach", new int[] {}, -1, new int[] {}),
            new Location(-33.81002f, 151.29739f, "Barracks Precinct Entrance", new int[] {R.drawable.barracks}, -1, new int[] {R.string.barracks_precinct_entrance}),
            new Location(-33.81075f, 151.29755f, "Parade Ground", new int[] {R.drawable.parade_ground}, -1, new int[] {}),
            new Location(-33.80035f, 151.28392f, "Manly Wharf", new int[] {}, R.drawable.marker_ferry, new int[] {}),
            new Location(-33.80802f, 151.29091f, "Penguins", new int[] {}, R.drawable.marker_penguin, new int[] {}),
            new Location(-33.8276f,  151.29586f, "Whales", new int[] {}, R.drawable.marker_whale, new int[] {R.string.whales}),
            new Location(-33.81478f, 151.28826f, "QStation Retreat", new int[] {R.drawable.qstation_retreat},-1,  new int[] {}),
            new Location(-33.81224f, 151.29744f, "Bandicoot Heaven", new int[] {R.drawable.north_head_sanctuary_foundation}, -1, new int[] {R.string.north_head_sanctuary_foundation}),
            new Location(-33.80822f, 151.28888f, "Jump Rock", new int[] {R.drawable.jump_rock}, -1, new int[] {}),
            new Location(-33.81752f, 151.29597f, "Visitor Centre", new int[] {}, -1, new int[] {}),

            // Walks
            new Location(0,0,"Walk #1",
                new int[] {R.drawable.esbs_1_01, R.drawable.esbs_1_02, R.drawable.esbs_1_03, R.drawable.esbs_1_04, R.drawable.esbs_1_05, R.drawable.esbs_1_06, R.drawable.esbs_1_07, R.drawable.esbs_1_08, R.drawable.esbs_1_09, R.drawable.esbs_1_10},
                -1,
                new int[] {R.string.esbs_1_01, R.string.esbs_1_02, R.string.esbs_1_03, R.string.esbs_1_04, R.string.esbs_1_05, R.string.esbs_1_06, R.string.esbs_1_07, R.string.esbs_1_08, R.string.esbs_1_09, R.string.esbs_1_10}
            ),
    };
}