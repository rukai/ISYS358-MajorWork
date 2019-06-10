package com.example.mwa;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Arrays;
import java.util.Comparator;

public class Location {
    public Object options;
    public String title;
    public int information;
    public int[] image_title;
    public int[] image;
    public int icon;
    public LatLng center;

    Location(LatLng[] latlngs, int color, String title, int information, int[] image, int[] image_title)
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
        this.image_title = image_title;
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
            if (latlng.longitude > max_lng) {
                max_lng = latlng.longitude;
            }
            if (latlng.longitude < min_lng) {
                min_lng = latlng.longitude;
            }
        }
        this.center = new LatLng((min_lat + max_lat)/2, (min_lng + max_lng)/2);
    }

    Location(float lat, float lng, String title, int information, int[] image, int icon, int[] image_title)
    {
        MarkerOptions options = new MarkerOptions()
            .position(new LatLng(lat, lng))
            .title(title);
        this.options = options;
        this.title = title;
        this.information = information;
        this.image_title = image_title;
        this.image = image;
        this.icon = icon;
        this.center = new LatLng(lat, lng);
    }

    public String toString() {
        return title;
    }

    public static Location[] locations;

    // Ensure this is called by the application before any other setup.
    public static void Init() {
        locations = new Location[] {
            // points of interest
            new Location(-33.81527f, 151.28569f, "QStation Wharf", R.string.qstation_wharf, new int[] {R.drawable.qstation_wharf}, -1, new int[] {}),
            new Location(-33.82322f, 151.29819f, "Fairfax Lookout", R.string.fairfax_lookout, new int[] {R.drawable.fairfax_lookout}, -1, new int[] {}),
            new Location(-33.8086f,  151.30299f, "Wastewater Treatment Plant", R.string.wastewater_plant, new int[] {R.drawable.wastewater_treatment}, -1, new int[] {}),
            new Location(-33.80054f, 151.29792f, "Shelly Beach", -1, new int[] {}, -1, new int[] {}),
            new Location(-33.81002f, 151.29739f, "Barracks Precinct Entrance", R.string.barracks_precinct_entrance, new int[] {R.drawable.barracks}, -1, new int[] {}),
            new Location(-33.81075f, 151.29755f, "Parade Ground", -1, new int[] {R.drawable.parade_ground}, -1, new int[] {}),
            new Location(-33.80035f, 151.28392f, "Manly Wharf", R.string.manly_wharf, new int[] {}, R.drawable.marker_ferry, new int[] {}),
            new Location(-33.80802f, 151.29091f, "Penguins", -1, new int[] {}, R.drawable.marker_penguin, new int[] {}),
            //new Location(-33.80846f, 151.29134f, "Penguins", -1, new int[] {}, R.drawable.marker_penguin, new int[] {}), // causes penguins to show up twice on the location list.
            new Location(-33.8276f,  151.29586f, "Whales", R.string.whales, new int[] {R.drawable.whale}, R.drawable.marker_whale, new int[] {}),
            new Location(-33.81478f, 151.28826f, "QStation Retreat", R.string.qstation_retreat, new int[] {R.drawable.qstation_retreat},-1,  new int[] {}),
            new Location(-33.81224f, 151.29744f, "Bandicoot Heaven", R.string.north_head_sanctuary_foundation, new int[] {R.drawable.north_head_sanctuary_foundation}, -1, new int[] {}),
            new Location(-33.80822f, 151.28888f, "Jump Rock", -1, new int[] {R.drawable.jump_rock}, -1, new int[] {}),
            new Location(-33.81752f, 151.29597f, "Visitor Centre", -1, new int[] {}, -1, new int[] {}),

            // Walks
            new Location(
                new LatLng[] {
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
                0xffd42828,
                "Central Walk",
                -1,
                new int[] { R.drawable.esbs_1_01, R.drawable.esbs_1_02, R.drawable.esbs_1_03, R.drawable.esbs_1_04, R.drawable.esbs_1_05, R.drawable.esbs_1_06, R.drawable.esbs_1_07, R.drawable.esbs_1_08, R.drawable.esbs_1_09, R.drawable.esbs_1_10 },
                new int[] { R.string.esbs_1_01, R.string.esbs_1_02, R.string.esbs_1_03, R.string.esbs_1_04, R.string.esbs_1_05, R.string.esbs_1_06, R.string.esbs_1_07, R.string.esbs_1_08, R.string.esbs_1_09, R.string.esbs_1_10 }
            ),
            new Location(
                new LatLng[] {
                    new LatLng(-33.8009447, 151.2984476),
                    new LatLng(-33.8007396, 151.2985656),
                    new LatLng(-33.8006861, 151.2988553),
                    new LatLng(-33.8005078, 151.2989948),
                    new LatLng(-33.8002938, 151.2990377),
                    new LatLng(-33.800383,  151.2992094),
                    new LatLng(-33.8008199, 151.2996278),
                    new LatLng(-33.801016,  151.2996922),
                    new LatLng(-33.8013369, 151.2996278),
                    new LatLng(-33.8016668, 151.2999711),
                    new LatLng(-33.8016312, 151.3000784),
                    new LatLng(-33.801756,  151.3001964),
                    new LatLng(-33.8018897, 151.3002501),
                    new LatLng(-33.8020769, 151.3004968),
                    new LatLng(-33.8025138, 151.3006899),
                    new LatLng(-33.8025851, 151.3008401),
                    new LatLng(-33.8027812, 151.301044 ),
                    new LatLng(-33.8030665, 151.3011835),
                    new LatLng(-33.8031467, 151.3009796),
                    new LatLng(-33.8033384, 151.3010762),
                    new LatLng(-33.8034142, 151.3010225),
                    new LatLng(-33.8034989, 151.3010386),
                    new LatLng(-33.8035925, 151.301162 ),
                    new LatLng(-33.8037039, 151.3012425),
                    new LatLng(-33.8037976, 151.3012049),
                    new LatLng(-33.8038822, 151.3012586),
                    new LatLng(-33.8042611, 151.3010869),
                    new LatLng(-33.8043102, 151.3009904),
                    new LatLng(-33.8044394, 151.3009367),
                    new LatLng(-33.8047024, 151.3006846),
                    new LatLng(-33.804854,  151.3006792),
                    new LatLng(-33.8049298, 151.3007275),
                    new LatLng(-33.8050189, 151.3006738),
                    new LatLng(-33.8050367, 151.3005612),
                    new LatLng(-33.8051393, 151.3004915),
                    new LatLng(-33.8054335, 151.3005022),
                    new LatLng(-33.8055984, 151.300234 ),
                    new LatLng(-33.8055761, 151.3000891),
                    new LatLng(-33.8059461, 151.2996278),
                    new LatLng(-33.8062403, 151.2995902),
                    new LatLng(-33.8063784, 151.299499 ),
                    new LatLng(-33.8065032, 151.2994776),
                    new LatLng(-33.8066503, 151.2994829),
                    new LatLng(-33.8067841, 151.2994615),
                    new LatLng(-33.8068821, 151.2993757),
                    new LatLng(-33.8070069, 151.2991074),
                    new LatLng(-33.807691,  151.2991562),
                    new LatLng(-33.8081724, 151.2989416),
                    new LatLng(-33.8086003, 151.2988343),
                    new LatLng(-33.8085825, 151.2980404),
                    new LatLng(-33.8087964, 151.2976649),
                    new LatLng(-33.8088945, 151.2973537),
                    new LatLng(-33.8090416, 151.2972626),
                    new LatLng(-33.8095987, 151.2973108),
                    new LatLng(-33.8102316, 151.2974235),
                    new LatLng(-33.8101737, 151.2978741),
                    new LatLng(-33.8112702, 151.2980833),
                    new LatLng(-33.8113861, 151.2971982),
                },
                0xff2854d4,
                "Shelly Beach Walk",
                    -1,
                    new int[] { R.drawable.esbs_2_01, R.drawable.esbs_2_02, R.drawable.esbs_2_03, R.drawable.esbs_2_04, R.drawable.esbs_2_05, R.drawable.esbs_2_06, R.drawable.esbs_2_07, R.drawable.esbs_2_08, R.drawable.esbs_2_09 },
                    new int[] { R.string.esbs_2_01, R.string.esbs_2_02, R.string.esbs_2_03, R.string.esbs_2_04, R.string.esbs_2_05, R.string.esbs_2_06, R.string.esbs_2_07, R.string.esbs_2_08, R.string.esbs_2_09 }
            ),
                new Location(
                    new LatLng[] {
                        new LatLng(-33.8113861, 151.2971982),
                        new LatLng(-33.8129304, 151.2974961),
                        new LatLng(-33.8134831, 151.2976034),
                        new LatLng(-33.8136435, 151.2976141),
                        new LatLng(-33.8141694, 151.2975605),
                        new LatLng(-33.8156492, 151.2972064),
                        new LatLng(-33.8159879, 151.2971099),
                        new LatLng(-33.8161483, 151.2971635),
                        new LatLng(-33.8162196, 151.297303 ),
                        new LatLng(-33.8152748, 151.2985905),
                        new LatLng(-33.8148647, 151.2986978),
                        new LatLng(-33.8153372, 151.299481 ),
                        new LatLng(-33.8150965, 151.3006182),
                        new LatLng(-33.8149895, 151.3008113),
                        new LatLng(-33.814945 , 151.3014658),
                        new LatLng(-33.8143745, 151.3015194),
                        new LatLng(-33.8139198, 151.3012941),
                        new LatLng(-33.8135187, 151.3010045),
                        new LatLng(-33.8133048, 151.3010259),
                        new LatLng(-33.8131711, 151.301101 ),
                        new LatLng(-33.8126986, 151.3006182),
                        new LatLng(-33.8121459, 151.3009186),
                        new LatLng(-33.8117359, 151.300704 ),
                        new LatLng(-33.8114774, 151.2995131),
                        new LatLng(-33.8112723, 151.298805 ),
                        new LatLng(-33.8113526, 151.2981828),
                        new LatLng(-33.8112702, 151.2980833),
                        new LatLng(-33.8113861, 151.2971982),
                    },
                    0xfff471fa,
                    "Hanging Swamp Walk",
                    -1,
                    new int[] { R.drawable.esbs_3_01, R.drawable.esbs_3_02, R.drawable.esbs_3_03, R.drawable.esbs_3_04, R.drawable.esbs_3_05, R.drawable.esbs_3_06, R.drawable.esbs_3_07, R.drawable.esbs_3_08, R.drawable.esbs_3_09, R.drawable.esbs_3_10, R.drawable.esbs_3_11, R.drawable.esbs_3_12 },
                    new int[] { R.string.esbs_3_01, R.string.esbs_3_02, R.string.esbs_3_03, R.string.esbs_3_04, R.string.esbs_3_05, R.string.esbs_3_06, R.string.esbs_3_07, R.string.esbs_3_08, R.string.esbs_3_09, R.string.esbs_3_10, R.string.esbs_3_11, R.string.esbs_3_12 }
                ),
        };

        Arrays.sort(locations, new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                return o1.title.compareToIgnoreCase(o2.title);
            }
        });
    };
}