package androidclient.api.popsi.co.followassistant.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.bean.NeedLikedInfo;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/27.
 */

public class RecyclerViewNeedLikedAdapter extends RecyclerView.Adapter<RecyclerViewNeedLikedAdapter.NeedLikedInfoHolder> {

    private List<NeedLikedInfo> needLikedInfoList;

    public RecyclerViewNeedLikedAdapter(List<NeedLikedInfo> needLikedInfoList) {
        this.needLikedInfoList = needLikedInfoList;
    }

    @Override
    public NeedLikedInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NeedLikedInfoHolder itemHolder = new NeedLikedInfoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_likes_item, parent, false));
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(NeedLikedInfoHolder holder, int position) {
        holder.iv_liked_fragment.setImageResource(R.mipmap.default_likes_fragment);
        holder.tv_likes_num.setText(needLikedInfoList.get(position).getLikes_num());
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

        public NeedLikedInfoHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
