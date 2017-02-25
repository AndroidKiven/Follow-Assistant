package androidclient.api.popsi.co.followassistant.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

import androidclient.api.popsi.co.followassistant.application.MyApplication;
import androidclient.api.popsi.co.followassistant.autoview.AutoToolbar;
import androidclient.api.popsi.co.followassistant.presenter.BasePresenter;
import androidclient.api.popsi.co.followassistant.view.iview.BaseIView;


/**
 * Created by Intellilink-Kiven on 2016/12/17.
 */

public abstract class BaseTranslucentActivity<V extends BaseIView, T extends BasePresenter<V>> extends AppCompatActivity {

    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断版本,如果[4.4,5.0)就设置状态栏和导航栏为透明
        presenter = createPresenter();
        presenter.attach((V) this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }

    @SuppressLint("NewApi")
    public void setOrChangeTranslucentColor(AutoToolbar toolbar, int translucentPrimaryColor) {

        //判断版本,如果[4.4,5.0)就设置状态栏和导航栏为透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (toolbar != null) {
                //1.先设置toolbar的高度
                LayoutParams params = toolbar.getLayoutParams();
                int statusBarHeight = getStatusBarHeight(MyApplication.getInstance());
                params.height += statusBarHeight;
                toolbar.setLayoutParams(params);
                //2.设置paddingTop，以达到状态栏不遮挡toolbar的内容。
                toolbar.setPadding(
                        toolbar.getPaddingLeft(),
                        toolbar.getPaddingTop() + getStatusBarHeight(MyApplication.getInstance()),
                        toolbar.getPaddingRight(),
                        toolbar.getPaddingBottom());
                //设置顶部的颜色
                toolbar.setBackgroundColor(translucentPrimaryColor);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(translucentPrimaryColor);
        } else {

        }
    }

    /**
     * 获取状态栏的高度
     */
    private int getStatusBarHeight(Context context) {
        // 反射手机运行的类：android.R.dimen.status_bar_height.
        return getSystemComponentDimen(this, "status_bar_height");
    }

    private static int getSystemComponentDimen(Context context, String dimenName) {
        // 反射手机运行的类：android.R.dimen.status_bar_height.
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            String heightStr = clazz.getField(dimenName).get(object).toString();
            int height = Integer.parseInt(heightStr);
            //dp--->px
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deAttch();
    }

    public abstract T createPresenter();
}
