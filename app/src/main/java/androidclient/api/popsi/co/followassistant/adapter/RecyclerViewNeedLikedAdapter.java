package androidclient.api.popsi.co.followassistant.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.bean.NeedLikedInfo;
import androidclient.api.popsi.co.followassistant.listener.RecyclerViewOnClikcListener;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/27.
 */

public class RecyclerViewNeedLikedAdapter extends RecyclerView.Adapter<RecyclerViewNeedLikedAdapter.NeedLikedInfoHolder> {

    private List<NeedLikedInfo> needLikedInfoList;

    RecyclerViewOnClikcListener recyclerViewOnClikcListener;

    public RecyclerViewNeedLikedAdapter(List<NeedLikedInfo> needLikedInfoList) {
        this.needLikedInfoList = needLikedInfoList;
    }

    public void setRecyclerViewOnClikcListener(RecyclerViewOnClikcListener OnClikcListener) {
        this.recyclerViewOnClikcListener = OnClikcListener;
    }


    @Override
    public NeedLikedInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NeedLikedInfoHolder itemHolder = new NeedLikedInfoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_likes_item, parent, false));
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(final NeedLikedInfoHolder holder, int position) {
        holder.iv_liked_fragment.setImageResource(R.mipmap.default_likes_fragment);
        holder.tv_likes_num.setText(needLikedInfoList.get(position).getLikes_num());

        if (recyclerViewOnClikcListener != null) {
            holder.arl_need_liked_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    recyclerViewOnClikcListener.onItemClick(pos, holder.iv_liked_fragment, holder.iv_liked_fragment);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return needLikedInfoList.size();
    }

    class NeedLikedInfoHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_liked_fragment)
        ImageView iv_liked_fragment;
        @BindView(R.id.tv_likes_num)
        TextView tv_likes_num;
        @BindView(R.id.arl_need_liked_item)
        AutoRelativeLayout arl_need_liked_item;

        public NeedLikedInfoHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
