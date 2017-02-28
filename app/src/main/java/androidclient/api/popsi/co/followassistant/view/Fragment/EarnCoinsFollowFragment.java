package androidclient.api.popsi.co.followassistant.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.adapter.RecyclerViewNeedFollowedAdapter;
import androidclient.api.popsi.co.followassistant.bean.NeedFollowedInfo;
import androidclient.api.popsi.co.followassistant.presenter.EarnCoinsFollowFragmentPresenter;
import androidclient.api.popsi.co.followassistant.presenter.EarnCoinsLikeFragmentPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.IEarnCoinsFollowFragmentView;
import androidclient.api.popsi.co.followassistant.view.iview.IEarnCoinsLikeFragmentView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/26.
 */

public class EarnCoinsFollowFragment extends BaseFragment<IEarnCoinsFollowFragmentView, EarnCoinsFollowFragmentPresenter> implements IEarnCoinsFollowFragmentView {


    @BindView(R.id.rv_need_followed)
    RecyclerView rv_need_followed;

    private List<NeedFollowedInfo> needFollowedInfoList;
    private RecyclerViewNeedFollowedAdapter needFollowedAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, mRootView);
        presenter.getNeedFollowedUserList();
        return mRootView;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public int setLayoutResouceId() {
        return R.layout.fragment_earn_coins_follow;
    }

    @Override
    public EarnCoinsFollowFragmentPresenter createPresenter() {
        return new EarnCoinsFollowFragmentPresenter();
    }

    @Override
    public void getNeedFollowedUserList() {
        needFollowedInfoList = new ArrayList<>();
        NeedFollowedInfo needFollowedInfo;
        for (int i = 0; i < 9; i++) {
            needFollowedInfo = new NeedFollowedInfo("image_url", "Robert Tucker");
            needFollowedInfoList.add(needFollowedInfo);
        }
        needFollowedAdapter = new RecyclerViewNeedFollowedAdapter(needFollowedInfoList);
        rv_need_followed.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_need_followed.setAdapter(needFollowedAdapter);
    }
}
