package androidclient.api.popsi.co.followassistant.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.adapter.ViewPagerEarnCoinsFragmentAdapter;
import androidclient.api.popsi.co.followassistant.presenter.EarnCoinsFragmentPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.IEarnCoinsFragmentView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/24.
 */

public class EarnCoinsFragment extends BaseFragment<IEarnCoinsFragmentView, EarnCoinsFragmentPresenter> implements IEarnCoinsFragmentView {

    @BindView(R.id.tbl_earn_coins_fragment)
    TabLayout tbl_earn_coins_fragment;
    @BindView(R.id.vp_earn_coins_fragment)
    ViewPager vp_earn_coins_fragment;

    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private ViewPagerEarnCoinsFragmentAdapter viewPagerEarnCoinsFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, mRootView);
        presenter.initEarnCoinsLikeFragmentView();
        return mRootView;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public int setLayoutResouceId() {
        return R.layout.fragment_earn_coins;
    }

    @Override
    public EarnCoinsFragmentPresenter createPresenter() {
        return new EarnCoinsFragmentPresenter();
    }

    @Override
    public void initEarnCoinsLikeFragmentView() {
        mTitleList.add("Like");
        mTitleList.add("Follow");

        viewPagerEarnCoinsFragmentAdapter = new ViewPagerEarnCoinsFragmentAdapter(getChildFragmentManager());
        viewPagerEarnCoinsFragmentAdapter.addFragment(new EarnCoinsLikeFragment());
        viewPagerEarnCoinsFragmentAdapter.addFragment(new EarnCoinsFollowFragment());

        vp_earn_coins_fragment.setAdapter(viewPagerEarnCoinsFragmentAdapter);//给ViewPager设置适配器
        tbl_earn_coins_fragment.setupWithViewPager(vp_earn_coins_fragment);//将TabLayout和ViewPager关联起来。

        tbl_earn_coins_fragment.getTabAt(0).setText(mTitleList.get(0));
        tbl_earn_coins_fragment.getTabAt(1).setText(mTitleList.get(1));

    }
}
