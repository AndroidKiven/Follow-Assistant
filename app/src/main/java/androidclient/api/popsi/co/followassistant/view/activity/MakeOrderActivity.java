package androidclient.api.popsi.co.followassistant.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.adapter.RecyclerViewOrdersListAdapter;
import androidclient.api.popsi.co.followassistant.autoview.AutoToolbar;
import androidclient.api.popsi.co.followassistant.bean.OrdersListInfo;
import androidclient.api.popsi.co.followassistant.presenter.MakeOrderAcitvityPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.IMakejOrderActivityView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/28.
 */

public class MakeOrderActivity extends BaseTranslucentActivity<IMakejOrderActivityView, MakeOrderAcitvityPresenter> implements IMakejOrderActivityView {

    @BindView(R.id.rv_orders_list)
    RecyclerView rv_orders_list;
    @BindView(R.id.tb_make_orders)
    AutoToolbar tb_make_orders;


    RecyclerViewOrdersListAdapter recyclerViewOrdersListAdapter;
    List<OrdersListInfo> ordersListInfoList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_order_activity);
        ButterKnife.bind(this);
        setOrChangeTranslucentColor(tb_make_orders, getResources().getColor(R.color.main_activity_toolbar));
        tb_make_orders.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        presenter.getOrdersListToSelect();
    }

    @Override
    public MakeOrderAcitvityPresenter createPresenter() {
        return new MakeOrderAcitvityPresenter();
    }


    @Override
    public void getOrdersListToSelect() {
        OrdersListInfo ordersListInfo;
        for (int i = 0; i < 10; i++) {
            ordersListInfo = new OrdersListInfo("x " + i * 5 + "", i * 10 + "");
            ordersListInfoList.add(ordersListInfo);
        }
        recyclerViewOrdersListAdapter = new RecyclerViewOrdersListAdapter(ordersListInfoList);
        rv_orders_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv_orders_list.setAdapter(recyclerViewOrdersListAdapter);
    }
}
