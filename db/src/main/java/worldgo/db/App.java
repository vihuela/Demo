package worldgo.db;

import android.app.Application;

import org.xutils.x;

/**
 * @author ricky.yao on 2016/7/13.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
