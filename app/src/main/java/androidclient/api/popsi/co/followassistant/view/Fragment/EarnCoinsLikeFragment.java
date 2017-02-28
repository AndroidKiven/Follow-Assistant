package androidclient.api.popsi.co.followassistant.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.presenter.EarnCoinsLikeFragmentPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.IEarnCoinsLikeFragmentView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/26.
 */

public class EarnCoinsLikeFragment extends BaseFragment<IEarnCoinsLikeFragmentView, EarnCoinsLikeFragmentPresenter> implements IEarnCoinsLikeFragmentView {

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
        return R.layout.fragment_earn_coins_like;
    }

    @Override
    public EarnCoinsLikeFragmentPresenter createPresenter() {
        return new EarnCoinsLikeFragmentPresenter();
    }
}
