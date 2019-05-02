package com.example.mwa;

import com.google.android.gms.maps.model.LatLng;

public class Location {
    public LatLng latlng;
    public String title;
    public String information;
    public int image;

    Location(float lat, float lng, String title, int image, String information)
    {
        latlng = new LatLng(lat, lng);
        this.title = title;
        this.information = information;
        this.image = image;
    }

    public String toString() {
        return title;
    }

    public static Location[] locations = {
            new Location(-33.81527f, 151.28569f, "QStation Wharf", R.drawable.qstation_wharf, "Put some text on QStation wharf here:" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod nisi porta lorem mollis aliquam ut. Sed tempus urna et pharetra pharetra massa. Consectetur adipiscing elit pellentesque habitant morbi tristique. In hac habitasse platea dictumst quisque. Rhoncus dolor purus non enim praesent elementum facilisis. Sapien eget mi proin sed libero. Commodo viverra maecenas accumsan lacus. Malesuada nunc vel risus commodo viverra. Cursus mattis molestie a iaculis at. Sodales neque sodales ut etiam sit. Velit laoreet id donec ultrices tincidunt arcu non. Facilisi morbi tempus iaculis urna id volutpat lacus laoreet. Imperdiet proin fermentum leo vel orci porta non pulvinar. Sit amet consectetur adipiscing elit duis tristique sollicitudin nibh. Tellus cras adipiscing enim eu turpis egestas pretium aenean pharetra. Aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque. Semper viverra nam libero justo laoreet." +
                "\n\n" +
                "Urna porttitor rhoncus dolor purus non enim praesent elementum. Quam vulputate dignissim suspendisse in est ante in nibh mauris. Arcu non sodales neque sodales ut. Feugiat nisl pretium fusce id velit. Sit amet commodo nulla facilisi nullam vehicula ipsum. Egestas quis ipsum suspendisse ultrices gravida dictum fusce. Ipsum suspendisse ultrices gravida dictum fusce ut. Donec massa sapien faucibus et molestie. Tristique senectus et netus et malesuada fames. Nunc sed augue lacus viverra vitae congue eu consequat ac. Phasellus vestibulum lorem sed risus ultricies. Et egestas quis ipsum suspendisse ultrices gravida dictum fusce. Cursus mattis molestie a iaculis." +
                "\n\n" +
                "At risus viverra adipiscing at in tellus. Duis at tellus at urna condimentum mattis pellentesque id. Pharetra convallis posuere morbi leo urna. Suspendisse in est ante in nibh mauris cursus. Lorem ipsum dolor sit amet consectetur adipiscing elit. Tellus mauris a diam maecenas sed. Ipsum suspendisse ultrices gravida dictum fusce ut. Aliquam purus sit amet luctus venenatis lectus magna fringilla urna. Integer feugiat scelerisque varius morbi enim nunc faucibus a pellentesque. Viverra accumsan in nisl nisi scelerisque. Volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend."),
            new Location(-33.82322f, 151.29819f, "Fairfax Lookout", R.drawable.qstation_wharf, "Put some text on Fairfax Lookout here!"),
            new Location(-33.8086f, 151.30299f, "North Head Wastewater Treatment Plant", R.drawable.qstation_wharf, ""),
            new Location(-33.80054f, 151.29792f, "Shelly Beach", R.drawable.qstation_wharf, ""),
            new Location(-33.81075f, 151.29755f, "The Baracks Precinct", R.drawable.qstation_wharf, ""),
    };
}