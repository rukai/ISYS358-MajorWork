package com.example.mwa;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PlantInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_information);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Native Plants");
        setSupportActionBar(toolbar);
    }
}
