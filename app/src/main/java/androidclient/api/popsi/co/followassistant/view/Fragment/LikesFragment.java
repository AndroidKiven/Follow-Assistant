package androidclient.api.popsi.co.followassistant.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.adapter.RecyclerViewNeedLikedAdapter;
import androidclient.api.popsi.co.followassistant.autoview.SpaceItemDecoration;
import androidclient.api.popsi.co.followassistant.bean.NeedLikedInfo;
import androidclient.api.popsi.co.followassistant.presenter.LikesFragmentPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.ILikesFragmentView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/24.
 */

public class LikesFragment extends BaseFragment<ILikesFragmentView, LikesFragmentPresenter> implements ILikesFragmentView {

    @BindView(R.id.rv_all_photos_videos)
    RecyclerView rv_all_photos_videos;

    RecyclerViewNeedLikedAdapter recyclerViewNeedLikedAdapter;
    List<NeedLikedInfo> needLikedInfoList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, mRootView);
        presenter.getAllNeedLikedPhotsAndVideos();
        return mRootView;
    }

    @Override
    public int setLayoutResouceId() {
        return R.layout.fragment_likes;
    }

    @Override
    public LikesFragmentPresenter createPresenter() {
        return new LikesFragmentPresenter();
    }

    @Override
    public void getAllNeedLikedPhotsAndVideos() {
        NeedLikedInfo needLikedInfo;
        for (int i = 0; i < 20; i++) {
            needLikedInfo = new NeedLikedInfo("url", i + "");
            needLikedInfoList.add(needLikedInfo);
        }
        recyclerViewNeedLikedAdapter = new RecyclerViewNeedLikedAdapter(needLikedInfoList);
        rv_all_photos_videos.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_all_photos_videos.addItemDecoration(new SpaceItemDecoration(5));
        rv_all_photos_videos.setAdapter(recyclerViewNeedLikedAdapter);
    }
}
