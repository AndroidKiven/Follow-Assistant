package androidclient.api.popsi.co.followassistant.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.bean.NeedFollowedInfo;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kiven on 2017/2/26.
 */

public class RecyclerViewNeedFollowedAdapter extends RecyclerView.Adapter<RecyclerViewNeedFollowedAdapter.NeedFollowedItemHolder> {

    private List<NeedFollowedInfo> needFollowedInfoList;

    public RecyclerViewNeedFollowedAdapter(List<NeedFollowedInfo> needFollowedInfoList) {
        this.needFollowedInfoList = needFollowedInfoList;
    }

    @Override
    public NeedFollowedItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NeedFollowedItemHolder itemHolder = new NeedFollowedItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_earn_coins_follow_item, parent, false));
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(NeedFollowedItemHolder holder, int position) {
        holder.cv_need_followed_head.setImageResource(R.mipmap.default_need_like);
        holder.tv_need_followed_username.setText(needFollowedInfoList.get(position).getUse_name());
    }

    @Override
    public int getItemCount() {
        return needFollowedInfoList.size();
    }

    class NeedFollowedItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cv_need_followed_head)
        CircleImageView cv_need_followed_head;
        @BindView(R.id.tv_need_followed_username)
        TextView tv_need_followed_username;

        public NeedFollowedItemHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
