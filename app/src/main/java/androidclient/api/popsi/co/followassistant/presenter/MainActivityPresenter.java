package androidclient.api.popsi.co.followassistant.presenter;

import androidclient.api.popsi.co.followassistant.view.iview.IMainActivityView;

/**
 * Created by Kiven on 2017/2/24.
 */

public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

    public void addFragmentToViewPager(){
        getView().addFragmentToViewPager();
    }
}
