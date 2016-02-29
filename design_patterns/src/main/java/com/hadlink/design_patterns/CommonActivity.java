package com.hadlink.design_patterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CommonActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() != null) {

            int resID = getIntent().getIntExtra("id", -1);
            setContentView(resID);

        }
    }
}
