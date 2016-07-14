package com.hadlink.design_patterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hadlink.design_patterns.observer.ObserMainAty;
import com.hadlink.design_patterns.prototype.PrototypeMainAty;
import com.hadlink.design_patterns.proxy.ProxyMainAty;
import com.hadlink.design_patterns.status.StateMainAty;
import com.hadlink.design_patterns.visitor.VisitorMainAty;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void statusMode(View view) {
        Intent intent = new Intent(this, StateMainAty.class);
        startActivity(intent);
    }

    private void go(int layoutId) {
        Intent intent = new Intent(this, CommonActivity.class);
        intent.putExtra("id", layoutId);
        startActivity(intent);
    }

    public void PrototypeMode(View view) {
        Intent intent = new Intent(this, PrototypeMainAty.class);
        startActivity(intent);
    }

    public void VisitorMode(View view) {
        Intent intent = new Intent(this, VisitorMainAty.class);
        startActivity(intent);
    }

    public void ProxyMode(View view) {
        Intent intent = new Intent(this, ProxyMainAty.class);
        startActivity(intent);
    }

    public void observerMode(View view) {
        Intent intent = new Intent(this, ObserMainAty.class);
        startActivity(intent);
    }
}
