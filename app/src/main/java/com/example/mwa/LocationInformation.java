package com.example.mwa;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        LinearLayout linearLayout = findViewById(R.id.information_layout);
        int length = Math.max(location.information.length, location.image.length);
        for (int i = 0; i < length; i++) {
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams.setMargins(30, 30, 30, 30);

            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            if (i < location.information.length) {
                TextView text = new TextView(this);
                text.setLayoutParams(textParams);
                text.setText(location.information[i]);
                linearLayout.addView(text);
            }

            if (i < location.image.length) {
                ImageView image = new ImageView(this);
                image.setLayoutParams(imageParams);
                image.setAdjustViewBounds(true);
                image.setImageResource(location.image[i]);
                linearLayout.addView(image);
            }
        }
    }
}
