package com.hadlink.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hadlink.annotation.anno.ContentView;
import com.hadlink.annotation.anno.OnClick;
import com.hadlink.annotation.anno.OnLongClick;
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

        showToast("init");
    }

    @OnClick(R.id.tv)
    public void click(View v) {
        switch (v.getId()) {
            case R.id.tv:
                showToast("click");
                break;
        }
    }

    @OnLongClick(R.id.tv)
    public boolean longClick(View v) {
        switch (v.getId()) {
            case R.id.tv:
                showToast("long click");
                break;
        }
        return true;
    }

    private void showToast(String s) {
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }
}
