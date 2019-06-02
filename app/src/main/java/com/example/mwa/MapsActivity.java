package com.example.mwa;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnPolylineClickListener {

    private GoogleMap mMap;
    private List<Marker> markers = new ArrayList();
    private List<Polyline> lines = new ArrayList();
    private int current_location_index = -1;

    private static final int FINE_LOCATION_PERMISSION_REQUEST_CODE = 1;
    private static final int LOCATION_LIST_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Very important this is run first, or all the indexes will get messed up!
        Arrays.sort(Location.locations, new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                return o1.title.compareToIgnoreCase(o2.title);
            }
        });

        setContentView(R.layout.activity_maps);

        LinearLayout locationBar = this.findViewById(R.id.location_bar);
        locationBar.setVisibility(LinearLayout.GONE);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION_PERMISSION_REQUEST_CODE);

        for(int i = 0; i < Location.locations.length; i++)
        {
            Location location = Location.locations[i];

            if (location.latlng.latitude == 0.0) {
                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.add(new LatLng(-33.8122488, 151.2972987));
                polylineOptions.add(new LatLng(-33.8133943, 151.2975348));
                polylineOptions.add(new LatLng(-33.8136394, 151.2975455));
                polylineOptions.add(new LatLng(-33.8141698, 151.2974865));
                polylineOptions.add(new LatLng(-33.8155916, 151.2971485));
                polylineOptions.add(new LatLng(-33.8155871, 151.2967677));
                polylineOptions.add(new LatLng(-33.8156228, 151.2966818));
                polylineOptions.add(new LatLng(-33.8156361, 151.2964136));
                polylineOptions.add(new LatLng(-33.8157877, 151.2959469));
                polylineOptions.add(new LatLng(-33.8157743, 151.2955553));
                polylineOptions.add(new LatLng(-33.8159303, 151.2949277));
                polylineOptions.add(new LatLng(-33.8159347, 151.2948579));
                polylineOptions.add(new LatLng(-33.8160997, 151.2946702));
                polylineOptions.add(new LatLng(-33.8160907, 151.2945843));
                polylineOptions.add(new LatLng(-33.8161264, 151.2945361));
                polylineOptions.add(new LatLng(-33.8162735, 151.2945039));
                polylineOptions.add(new LatLng(-33.8165275, 151.2945629));
                polylineOptions.add(new LatLng(-33.8167771, 151.294579));
                polylineOptions.add(new LatLng(-33.8169732, 151.2946165));
                polylineOptions.add(new LatLng(-33.8172584, 151.2947775));
                polylineOptions.add(new LatLng(-33.8173119, 151.2950725));
                polylineOptions.add(new LatLng(-33.8173966, 151.2951959));
                polylineOptions.add(new LatLng(-33.8174679, 151.2953461));
                polylineOptions.add(new LatLng(-33.8175437, 151.2955875));
                polylineOptions.add(new LatLng(-33.8174278, 151.2959362));
                polylineOptions.add(new LatLng(-33.8163671, 151.2972129));
                polylineOptions.add(new LatLng(-33.8161353, 151.297052));
                polylineOptions.add(new LatLng(-33.8159659, 151.2970412));
                polylineOptions.add(new LatLng(-33.8156762, 151.2971217));
                polylineOptions.color(0xFFd42828);
                polylineOptions.clickable(true);
                Polyline line = mMap.addPolyline(polylineOptions);
                line.setTag(i);

                lines.add(line);
            }
            else {
                MarkerOptions markerOptions = new MarkerOptions()
                        .position(location.latlng)
                        .title(location.title);

                if (location.icon >= 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromResource(location.icon));
                }

                Marker marker = mMap.addMarker(markerOptions);
                marker.setTag(i);

                markers.add(marker);
            }
        }


        mMap.setOnMarkerClickListener(this);
        mMap.setOnPolylineClickListener(this);
    }

    public void openLocationList(View v) {
        startActivityForResult(new Intent(this, LocationList.class), LOCATION_LIST_RESULT);
    }

    public void openPathManager(View v) {
        Intent intent = new Intent(this, LocationInformation.class);
        intent.putExtra("location_index", 0);
        startActivity(intent);

        // TODO: Opens a GUI that lists locations in the path.
        // TODO: Each location has a button to delete it and a button to rearrange its order.
    }

    public void openPlantInformation(View v) {
        startActivity(new Intent(this, PlantInformation.class));
    }

    public void openInformation(View v) {
        Intent intent = new Intent(this, LocationInformation.class);
        intent.putExtra("location_index", current_location_index);
        startActivity(intent);
    }

    public void openDirections(View v) {
        Location location = Location.locations[current_location_index];
        Uri uri = Uri.parse("google.navigation:q=" + location.latlng.latitude + "," + location.latlng.longitude + "&mode=w");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOCATION_LIST_RESULT) {
            if (resultCode == RESULT_OK) {
                int location_index = data.getIntExtra("location_index", -1);

                // open the marker window
                markers.get(location_index).showInfoWindow();

                // center map on the marker
                Location location = Location.locations[location_index];
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location.latlng, 14));

                onMarkerClick(markers.get(location_index));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == FINE_LOCATION_PERMISSION_REQUEST_CODE) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.ACCESS_FINE_LOCATION }, FINE_LOCATION_PERMISSION_REQUEST_CODE);
            }
        }
    }

    public void onLocationClick() {
        // rename the location bar
        Location location = Location.locations[current_location_index];
        TextView text = findViewById(R.id.location_name);
        text.setText(location.title);

        // ensure the location bar is visible
        LinearLayout locationBar = this.findViewById(R.id.location_bar);
        locationBar.setVisibility(LinearLayout.VISIBLE);

        // update the location bar image
        ImageView image = findViewById(R.id.image);
        if (location.image.length > 0) {
            image.setImageResource(location.image[0]);
        } else {
            image.setImageResource(android.R.color.transparent);
        }
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        current_location_index = (int) marker.getTag();
        onLocationClick();

        // returning false says that we want the default marker click behaviour to still occur.
        return false;
    }

    @Override
    public void onPolylineClick(final Polyline line) {
        current_location_index = (int) line.getTag();
        onLocationClick();
    }
}
