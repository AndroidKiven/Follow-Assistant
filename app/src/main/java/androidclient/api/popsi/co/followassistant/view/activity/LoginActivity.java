package androidclient.api.popsi.co.followassistant.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.presenter.LoginActivityPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.ILoginActivityView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kiven on 2017/2/23.
 */

public class LoginActivity extends BaseTranslucentActivity<ILoginActivityView, LoginActivityPresenter> implements ILoginActivityView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
    }

    @Override
    public LoginActivityPresenter createPresenter() {
        return new LoginActivityPresenter();
    }

    @OnClick(R.id.btn_login)
    public void loginToInstagram() {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
