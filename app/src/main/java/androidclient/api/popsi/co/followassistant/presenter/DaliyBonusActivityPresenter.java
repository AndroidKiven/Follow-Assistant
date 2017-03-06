package androidclient.api.popsi.co.followassistant.presenter;

import androidclient.api.popsi.co.followassistant.view.iview.IDaliyBonusActivityView;

/**
 * Created by Kiven on 2017/3/4.
 */

public class DaliyBonusActivityPresenter extends BasePresenter<IDaliyBonusActivityView> {
    public void showDailyBonusSignList(){
        getView().showDailyBonusSignList();
    }
}
