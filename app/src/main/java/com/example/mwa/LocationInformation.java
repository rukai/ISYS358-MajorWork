package com.example.mwa;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int location_index = getIntent().getIntExtra("location_index", -1);
        Location location = Location.locations[location_index];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_information);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(location.title);
        setSupportActionBar(toolbar);

        TextView text = findViewById(R.id.information_text);
        text.setText(location.information);

        ImageView image = findViewById(R.id.image);
        image.setImageResource(location.image);
    }
}
