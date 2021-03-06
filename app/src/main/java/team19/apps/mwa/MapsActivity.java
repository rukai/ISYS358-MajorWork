package team19.apps.mwa;

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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnPolylineClickListener, GoogleMap.OnPolygonClickListener {

    private GoogleMap mMap;
    private List<Object> mapItems = new ArrayList();
    private List<Marker> markers = new ArrayList();
    private List<Polyline> lines = new ArrayList();
    private List<Polygon> polygons = new ArrayList();
    private int current_location_index = -1;

    private static final int FINE_LOCATION_PERMISSION_REQUEST_CODE = 1;
    private static final int LOCATION_LIST_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Location.Init();

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

            if (location.options instanceof PolylineOptions) {
                Polyline line = mMap.addPolyline((PolylineOptions) location.options);
                line.setTag(i);

                lines.add(line);
                mapItems.add(line);
            }
            else if (location.options instanceof PolygonOptions) {
                Polygon polygon = mMap.addPolygon((PolygonOptions) location.options);
                polygon.setTag(i);

                polygons.add(polygon);
                mapItems.add(polygon);
            }
            else if (location.options instanceof MarkerOptions) {
                MarkerOptions markerOptions = (MarkerOptions) location.options;

                if (location.icon >= 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromResource(location.icon));
                }

                Marker marker = mMap.addMarker(markerOptions);
                marker.setTag(i);

                markers.add(marker);
                mapItems.add(marker);
            }
        }

        mMap.setOnMarkerClickListener(this);
        mMap.setOnPolylineClickListener(this);
        mMap.setOnPolygonClickListener(this);
    }

    public void openLocationList(View v) {
        startActivityForResult(new Intent(this, LocationList.class), LOCATION_LIST_RESULT);
    }

    public void openInformation(View v) {
        Intent intent = new Intent(this, LocationInformation.class);
        intent.putExtra("location_index", current_location_index);
        startActivity(intent);
    }

    public void openDirections(View v) {
        Location location = Location.locations[current_location_index];
        Uri uri = Uri.parse("google.navigation:q=" + location.center.latitude + "," + location.center.longitude + "&mode=w");
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
                Object mapItem = mapItems.get(location_index);
                if (mapItem instanceof Marker) {
                    Marker marker = (Marker) mapItem;
                    marker.showInfoWindow();
                    onMarkerClick(marker);
                }

                // center map on the marker
                Location location = Location.locations[location_index];
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location.center, 14));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == FINE_LOCATION_PERMISSION_REQUEST_CODE) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
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

    @Override
    public void onPolygonClick(final Polygon polygon) {
        current_location_index = (int) polygon.getTag();
        onLocationClick();
    }
}
