package androidclient.api.popsi.co.followassistant.presenter;

import androidclient.api.popsi.co.followassistant.view.iview.ILikesFragmentView;

/**
 * Created by Kiven on 2017/2/26.
 */

public class LikesFragmentPresenter extends BasePresenter<ILikesFragmentView> {
    public void getAllNeedLikedPhotsAndVideos(){
        getView().getAllNeedLikedPhotsAndVideos();
    }
}
