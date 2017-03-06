package androidclient.api.popsi.co.followassistant.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.presenter.MoreFragmentPresenter;
import androidclient.api.popsi.co.followassistant.view.activity.DaliyBonusActivity;
import androidclient.api.popsi.co.followassistant.view.activity.FeedbackActivity;
import androidclient.api.popsi.co.followassistant.view.iview.IMoreFragmentView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kiven on 2017/2/24.
 */

public class MoreFragment extends BaseFragment<IMoreFragmentView, MoreFragmentPresenter> implements IMoreFragmentView {

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
        return R.layout.fragment_more;
    }

    @Override
    public MoreFragmentPresenter createPresenter() {
        return new MoreFragmentPresenter();
    }

    @OnClick(R.id.mif_feedback)
    public void jumpToFeedbackActivity() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), FeedbackActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.mif_daily_bonus)
    public void jumpToDaliyBonusActivity() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), DaliyBonusActivity.class);
        startActivity(intent);
    }
}
