package androidclient.api.popsi.co.followassistant.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.view.activity.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_activity);

        // 延迟2s进入主页面
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                enterMain();
            }

        }, 2000);
    }


    public boolean isEnterMained = false;

    public void enterMain() {
        if (isEnterMained) {
            return;
        }
        isEnterMained = true;
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        // 关闭当前页面
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        enterMain();
        return true;
    }
}
