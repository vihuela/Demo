package com.hadlink.design_patterns.observer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hadlink.design_patterns.observer.impl.GoodNotifier;
import com.hadlink.design_patterns.observer.impl.Listener1;
import com.hadlink.design_patterns.observer.impl.Listener2;
import com.hadlink.design_patterns.proxy.NotifyProxy;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Created by lyao on 2016/3/22.
 * @description
 */
public class ObserMainAty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegateObserver();
    }

    /**
     * 代理的观察者模式
     * 自己制定动作，只是触发事件和目标有关
     */
    private void delegateObserver() {
        Listener1 listener1 = new Listener1();
        Listener2 listener2 = new Listener2();
        GoodNotifier goodNotifier = new GoodNotifier();
        goodNotifier.addListener(listener1, "action");
        goodNotifier.addListener(listener1, "bb", "铃声响了");
        goodNotifier.addListener(listener2, "fuck", "老师来了");
        goodNotifier.setChange(true);
        goodNotifier.notifyX();
    }


    /**
     * 常规观察者模式
     * 问题：每个观察者不能随意制定自己的动作
     */
    private void normalObserver() {
        target target = new target();
        target.addObserver(new observer1());
        target.addObserver(new observer2());
        target.setChanged();
        target.notifyObservers("Fucking!!!");
    }

    private class target extends Observable {
        @Override
        public void setChanged() {
            super.setChanged();
        }
    }

    private class observer1 implements Observer {

        @Override
        public void update(Observable observable, Object data) {
            System.out.println(data);
        }
    }

    private class observer2 implements Observer {

        @Override
        public void update(Observable observable, Object data) {
            System.out.println(data);
        }
    }
}
