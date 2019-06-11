package team19.apps.mwa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        AdapterView.OnItemClickListener messageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                parent.getItemAtPosition(position);
                Intent intent = new Intent();
                intent.putExtra("location_index", position);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        };
        list.setOnItemClickListener(messageClickedHandler);

        ListAdapter adapter = new ArrayAdapter(this, R.layout.feature, Location.locations);
        list.setAdapter(adapter);
    }

}
