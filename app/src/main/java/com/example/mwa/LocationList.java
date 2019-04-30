package com.example.mwa;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public final class LocationList extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);
        ListView list = findViewById(R.id.list);

        ListAdapter adapter = new ArrayAdapter(this, R.layout.feature, Location.locations);
        list.setAdapter(adapter);
    }
}
