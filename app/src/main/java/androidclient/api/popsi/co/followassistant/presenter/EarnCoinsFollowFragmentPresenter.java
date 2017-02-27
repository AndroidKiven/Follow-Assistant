package androidclient.api.popsi.co.followassistant.presenter;

import androidclient.api.popsi.co.followassistant.view.iview.IEarnCoinsFollowFragmentView;

/**
 * Created by Kiven on 2017/2/26.
 */

public class EarnCoinsFollowFragmentPresenter extends BasePresenter<IEarnCoinsFollowFragmentView> {
    public void getNeedFollowedUserList(){
        getView().getNeedFollowedUserList();
    }
}
