package androidclient.api.popsi.co.followassistant.view.fragment;

import android.os.Build;
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
import androidclient.api.popsi.co.followassistant.adapter.RecyclerViewFollowerOrdersListAdapter;
import androidclient.api.popsi.co.followassistant.bean.OrdersListInfo;
import androidclient.api.popsi.co.followassistant.presenter.FollowersFragmentPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.IFollowersFragmentView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/24.
 */

public class FollowersFragment extends BaseFragment<IFollowersFragmentView, FollowersFragmentPresenter> implements IFollowersFragmentView {

    @BindView(R.id.rv_followers_orders_list)
    RecyclerView rv_followers_orders_list;

    RecyclerViewFollowerOrdersListAdapter recyclerViewFollowerOrdersListAdapter;
    List<OrdersListInfo> ordersListInfoList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, mRootView);
        presenter.getFollowersOrdersList();
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

    @Override
    public void getFollowersOrdersList() {
        OrdersListInfo ordersListInfo;
        for (int i = 0; i < 10; i++) {
            ordersListInfo = new OrdersListInfo("x " + i * 5 + "", i * 10 + "");
            ordersListInfoList.add(ordersListInfo);
        }
        recyclerViewFollowerOrdersListAdapter = new RecyclerViewFollowerOrdersListAdapter(ordersListInfoList);
        rv_followers_orders_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_followers_orders_list.setAdapter(recyclerViewFollowerOrdersListAdapter);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            rv_followers_orders_list.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }
    }
}
