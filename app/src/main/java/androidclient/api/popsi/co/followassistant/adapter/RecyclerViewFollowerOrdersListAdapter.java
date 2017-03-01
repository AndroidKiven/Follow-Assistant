package androidclient.api.popsi.co.followassistant.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.bean.OrdersListInfo;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/28.
 */

public class RecyclerViewFollowerOrdersListAdapter extends RecyclerView.Adapter<RecyclerViewFollowerOrdersListAdapter.OrdersListItemHolder> {

    List<OrdersListInfo> ordersListInfos;

    public RecyclerViewFollowerOrdersListAdapter(List<OrdersListInfo> ordersListInfos) {
        this.ordersListInfos = ordersListInfos;
    }

    @Override
    public OrdersListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        OrdersListItemHolder itemHolder = new OrdersListItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.make_followers_orders_item, parent, false));
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(OrdersListItemHolder holder, int position) {
        holder.tv_need_coins_num.setText(ordersListInfos.get(position).getNeedCoinsNum());
        holder.tv_need_followers_num.setText(ordersListInfos.get(position).getGetLikesNum());
    }

    @Override
    public int getItemCount() {
        return ordersListInfos.size();
    }

    class OrdersListItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_need_followers_num)
        TextView tv_need_followers_num;
        @BindView(R.id.tv_need_coins_num)
        TextView tv_need_coins_num;

        public OrdersListItemHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
