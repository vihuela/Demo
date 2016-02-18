package com.hadlink.measure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hadlink.measure.widget.RadarView;

public class CommonActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() != null) {

            int resID = getIntent().getIntExtra("id", -1);
            setContentView(resID);

            if (resID == R.layout.radar_view) {
                ((RadarView) findViewById(R.id.rv)).scan();
            }
        }
    }
}
