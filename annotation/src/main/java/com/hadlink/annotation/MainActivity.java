package com.hadlink.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hadlink.annotation.anno.ContentView;
import com.hadlink.annotation.anno.OnClick;
import com.hadlink.annotation.anno.ViewInject;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.tv)
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjectUtils.injectContentView(this);
        ViewInjectUtils.injectView(this);
        ViewInjectUtils.injectOnClick(this);

        showToast();

        /*tv.setOnClickListener(this);*/


    }

    @OnClick(R.id.tv)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv:
                showToast();
                break;
        }
    }

    private void showToast() {
        Toast.makeText(this, "" + tv.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
