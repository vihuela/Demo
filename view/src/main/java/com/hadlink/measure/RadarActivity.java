package com.hadlink.measure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hadlink.measure.widget.RadarView;

public class RadarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radar_view);
        ((RadarView) findViewById(R.id.rv)).scan();
    }

}
