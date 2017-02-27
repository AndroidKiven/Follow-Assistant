package androidclient.api.popsi.co.followassistant.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidclient.api.popsi.co.followassistant.presenter.BasePresenter;
import androidclient.api.popsi.co.followassistant.view.iview.BaseIView;

/**
 * Created by Kiven on 2017/2/26.
 */

public abstract class BaseFragment<V extends BaseIView, T extends BasePresenter<V>> extends Fragment {

    View mRootView;
    public T presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(setLayoutResouceId(), container, false);
            presenter = createPresenter();
            presenter.attach((V) this);
        }
        return mRootView;
    }

    public abstract int setLayoutResouceId();

    public abstract T createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.deAttch();
    }
}
