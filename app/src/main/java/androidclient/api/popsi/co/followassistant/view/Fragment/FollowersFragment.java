package androidclient.api.popsi.co.followassistant.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.presenter.FollowersFragmentPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.IFollowersFragmentView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/24.
 */

public class FollowersFragment extends BaseFragment<IFollowersFragmentView, FollowersFragmentPresenter> implements IFollowersFragmentView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public int setLayoutResouceId() {
        return R.layout.fragment_followers;
    }

    @Override
    public FollowersFragmentPresenter createPresenter() {
        return new FollowersFragmentPresenter();
    }
}
