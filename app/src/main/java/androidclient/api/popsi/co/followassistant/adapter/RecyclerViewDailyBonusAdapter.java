package androidclient.api.popsi.co.followassistant.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.bean.DailyBonusInfo;
import androidclient.api.popsi.co.followassistant.listener.RecyclerViewOnClikcListener;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/3/5.
 */

public class RecyclerViewDailyBonusAdapter extends RecyclerView.Adapter<RecyclerViewDailyBonusAdapter.DailyBonusItem> {

    private List<DailyBonusInfo> dailyBonusInfoList;

    private RecyclerViewOnClikcListener recyclerViewOnClikcListener;

    public RecyclerViewDailyBonusAdapter(List<DailyBonusInfo> dailyBonusInfoList) {
        this.dailyBonusInfoList = dailyBonusInfoList;
    }

    public void setRecyclerViewOnClikcListener(RecyclerViewOnClikcListener recyclerViewOnClikcListener) {
        this.recyclerViewOnClikcListener = recyclerViewOnClikcListener;
    }

    @Override
    public DailyBonusItem onCreateViewHolder(ViewGroup parent, int viewType) {
        DailyBonusItem bonusItem = new DailyBonusItem(LayoutInflater.from(parent.getContext()).inflate(R.layout.more_fragment_daily_bonus_item, parent, false));
        return bonusItem;
    }

    @Override
    public void onBindViewHolder(final DailyBonusItem holder, int position) {
        holder.tv_get_coins_num.setText(dailyBonusInfoList.get(position).getCoinsNum());
        if (recyclerViewOnClikcListener != null) {
            holder.arl_daily_bonus_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    recyclerViewOnClikcListener.onItemClick(pos, holder.arl_daily_bonus_item);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dailyBonusInfoList.size();
    }

    class DailyBonusItem extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_get_coins_num)
        TextView tv_get_coins_num;
        @BindView(R.id.arl_daily_bonus_item)
        AutoRelativeLayout arl_daily_bonus_item;

        public DailyBonusItem(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
