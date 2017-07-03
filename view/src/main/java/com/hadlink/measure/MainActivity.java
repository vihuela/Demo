package com.hadlink.measure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void RadarView(View view) {
        go(R.layout.radar_view);
    }

    public void ClockView(View view) {
        go(R.layout.clock_view);
    }

    public void ViewDragHelper(View view) {
        go(R.layout.vdh_view);
    }

    public void Scroller(View view) {
        go(R.layout.scroller_view);
    }

    public void NestedScrolling(View view) {
        go(R.layout.nest_view);
    }

    public void go(@LayoutRes int res) {
        Intent intent = new Intent(this, CommonActivity.class);
        intent.putExtra("id", res);
        startActivity(intent);
    }

    public void LabelView(View view) {
        go(R.layout.label_view);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //基础类型
        UserInfo info = new UserInfo("ricky", "man", "app developer", "beach");
        //复杂类型1
        info.more = new ArrayList<>();
        Collections.addAll(info.more, new UserInfo.UserDes("moreDes1", "moreDes2"));
        //复杂类型2
        info.userDes = new UserInfo.UserDes("userDes1", "userDes2");
        outState.putParcelable("person", info);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            UserInfo person = savedInstanceState.getParcelable("person");
            System.out.println();
        }
    }
}
