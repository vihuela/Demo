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
import com.hadlink.annotation.anno.ViewInjectUtils;
import com.hadlink.annotation.dagger.scene1.Car;
import com.hadlink.annotation.dagger.scene2.Parent;
import com.hadlink.annotation.dagger.scene3.Company;
import com.hadlink.annotation.dagger.scene4.Country;

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
            case R.id.tv: {
                //dagger 依赖对象，无参，汽车依赖引擎
                new Car().getEngine().run();
                //dagger 依赖对象，有参，父母依赖（义务照顾）孩子
                new Parent().child.eat();
                //dagger 依赖对象，多参，公司依赖员工
                Company c = new Company();
                c.printJuniorStaff();
                c.printSeniorStaff();
                //dagger 依赖对象，唯一参，国家依赖人民，people1与people2是同一对象
                Country co = new Country();
                System.out.println(co.people1);
                System.out.println(co.people2);
            }
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
