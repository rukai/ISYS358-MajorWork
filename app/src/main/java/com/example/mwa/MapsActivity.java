package com.example.mwa;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final int FINE_LOCATION_PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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

        for(Location location: Location.locations)
        {
            mMap.addMarker(new MarkerOptions().position(location.latlng).title(location.title));
            // TODO: The pop up for each location should have a button to add it to the path and a button that opens photos + full information text.
        }

        // start the map showing all of north head
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.8107, 151.295), 14));
    }

    public void openLocationList(View v) {
        startActivity(new Intent(this, LocationList.class));
        // TODO: Lists every location, pressing the location will open it in the map view.
    }

    public void openPathManager(View v) {
        Intent intent = new Intent(this, LocationInformation.class);
        intent.putExtra("location_index", 0);
        startActivity(intent);
        // TODO: Opens a GUI that lists locations in the path.
        // TODO: Each location has a button to delete it and a button to rearrange its order.
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == FINE_LOCATION_PERMISSION_REQUEST_CODE) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION_PERMISSION_REQUEST_CODE);
            }
        }
    }
}
