package com.example.mwa;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Location {
    public Object options;
    public String title;
    public int[] information;
    public int[] image;
    public int icon;
    public LatLng center;

    Location(LatLng[] latlngs, int color, String title, int[] image, int[] information)
    {
        PolylineOptions options = new PolylineOptions()
            .color(color)
            .clickable(true);

        for(LatLng latlng: latlngs) {
            options.add(latlng);
        }

        this.options = options;
        this.title = title;
        this.information = information;
        this.image = image;

        double min_lat =  1000000.0;
        double min_lng =  1000000.0;
        double max_lat = -1000000.0;
        double max_lng = -1000000.0;
        for(LatLng latlng: latlngs) {
            if (latlng.latitude > max_lat) {
                max_lat = latlng.latitude;
            }
            if (latlng.latitude < min_lat) {
                min_lat = latlng.latitude;
            }
            if (latlng.latitude > max_lng) {
                max_lng = latlng.longitude;
            }
            if (latlng.latitude < min_lng) {
                min_lng = latlng.longitude;
            }
        }
        this.center = new LatLng((min_lat + max_lat)/2, (min_lng + max_lng)/2);
    }

    Location(float lat, float lng, String title, int[] image, int icon, int[] information)
    {
        MarkerOptions options = new MarkerOptions()
            .position(new LatLng(lat, lng))
            .title(title);
        this.options = options;
        this.title = title;
        this.information = information;
        this.image = image;
        this.icon = icon;
        this.center = new LatLng(lat, lng);
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
        new Location(
            new LatLng[]{
                new LatLng(-33.8122488, 151.2972987),
                new LatLng(-33.8133943, 151.2975348),
                new LatLng(-33.8136394, 151.2975455),
                new LatLng(-33.8141698, 151.2974865),
                new LatLng(-33.8155916, 151.2971485),
                new LatLng(-33.8155871, 151.2967677),
                new LatLng(-33.8156228, 151.2966818),
                new LatLng(-33.8156361, 151.2964136),
                new LatLng(-33.8157877, 151.2959469),
                new LatLng(-33.8157743, 151.2955553),
                new LatLng(-33.8159303, 151.2949277),
                new LatLng(-33.8159347, 151.2948579),
                new LatLng(-33.8160997, 151.2946702),
                new LatLng(-33.8160907, 151.2945843),
                new LatLng(-33.8161264, 151.2945361),
                new LatLng(-33.8162735, 151.2945039),
                new LatLng(-33.8165275, 151.2945629),
                new LatLng(-33.8167771, 151.294579),
                new LatLng(-33.8169732, 151.2946165),
                new LatLng(-33.8172584, 151.2947775),
                new LatLng(-33.8173119, 151.2950725),
                new LatLng(-33.8173966, 151.2951959),
                new LatLng(-33.8174679, 151.2953461),
                new LatLng(-33.8175437, 151.2955875),
                new LatLng(-33.8174278, 151.2959362),
                new LatLng(-33.8163671, 151.2972129),
                new LatLng(-33.8161353, 151.297052),
                new LatLng(-33.8159659, 151.2970412),
                new LatLng(-33.8156762, 151.2971217),
            },
            0xFFd42828,
            "Walk #1",
            new int[] {R.drawable.esbs_1_01, R.drawable.esbs_1_02, R.drawable.esbs_1_03, R.drawable.esbs_1_04, R.drawable.esbs_1_05, R.drawable.esbs_1_06, R.drawable.esbs_1_07, R.drawable.esbs_1_08, R.drawable.esbs_1_09, R.drawable.esbs_1_10},
            new int[] {R.string.esbs_1_01, R.string.esbs_1_02, R.string.esbs_1_03, R.string.esbs_1_04, R.string.esbs_1_05, R.string.esbs_1_06, R.string.esbs_1_07, R.string.esbs_1_08, R.string.esbs_1_09, R.string.esbs_1_10}
        ),
    };
}