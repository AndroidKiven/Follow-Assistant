package androidclient.api.popsi.co.followassistant.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.adapter.RecyclerViewDailyBonusAdapter;
import androidclient.api.popsi.co.followassistant.autoview.AutoToolbar;
import androidclient.api.popsi.co.followassistant.autoview.DailyBonusSpaceItemDecoration;
import androidclient.api.popsi.co.followassistant.bean.DailyBonusInfo;
import androidclient.api.popsi.co.followassistant.listener.RecyclerViewOnClikcListener;
import androidclient.api.popsi.co.followassistant.presenter.DaliyBonusActivityPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.IDaliyBonusActivityView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/3/4.
 */

public class DaliyBonusActivity extends BaseTranslucentActivity<IDaliyBonusActivityView, DaliyBonusActivityPresenter> implements IDaliyBonusActivityView, RecyclerViewOnClikcListener {

    @BindView(R.id.rv_daliy_bonus_sheet)
    RecyclerView rv_daliy_bonus_sheet;
    @BindView(R.id.tb_title)
    AutoToolbar tb_title;

    RecyclerViewDailyBonusAdapter recyclerViewDailyBonusAdapter;

    List<DailyBonusInfo> dailyBonusInfos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_fragement_daily_bonus);
        ButterKnife.bind(this);
        presenter.showDailyBonusSignList();
        setOrChangeTranslucentColor(tb_title, getResources().getColor(R.color.main_activity_toolbar));
    }

    @Override
    public DaliyBonusActivityPresenter createPresenter() {
        return new DaliyBonusActivityPresenter();
    }

    @Override
    public void showDailyBonusSignList() {
        dailyBonusInfos = new ArrayList<>();
        DailyBonusInfo dailyBonusInfo;
        for (int i = 0; i < 30; i++) {
            dailyBonusInfo = new DailyBonusInfo("" + i, false);
            dailyBonusInfos.add(dailyBonusInfo);
        }
        recyclerViewDailyBonusAdapter = new RecyclerViewDailyBonusAdapter(dailyBonusInfos);
        recyclerViewDailyBonusAdapter.setRecyclerViewOnClikcListener(this);
        rv_daliy_bonus_sheet.setLayoutManager(new GridLayoutManager(getApplicationContext(), 5));
        rv_daliy_bonus_sheet.addItemDecoration(new DailyBonusSpaceItemDecoration(2));
        rv_daliy_bonus_sheet.setAdapter(recyclerViewDailyBonusAdapter);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            rv_daliy_bonus_sheet.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }
    }

    @Override
    public void onItemClick(int position, View... view) {
        Toast.makeText(this, "签到成功" + position, Toast.LENGTH_SHORT).show();
        view[0].setBackgroundResource(R.drawable.drawable_daily_bonus_item_select);
    }
}
