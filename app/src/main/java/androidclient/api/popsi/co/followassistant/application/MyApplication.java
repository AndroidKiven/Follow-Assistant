package androidclient.api.popsi.co.followassistant.application;

import android.app.Application;
import android.content.Context;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by Intellilink-Kiven on 2017/2/24.
 */

public class MyApplication extends Application {

    private static Context instance;

    public static Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        instance = this;
    }
}
