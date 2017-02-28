package androidclient.api.popsi.co.followassistant.presenter;

import androidclient.api.popsi.co.followassistant.view.iview.IMakejOrderActivityView;

/**
 * Created by Kiven on 2017/2/28.
 */

public class MakeOrderAcitvityPresenter extends BasePresenter<IMakejOrderActivityView> {
    public void getOrdersListToSelect(){
        getView().getOrdersListToSelect();
    }
}
