package androidclient.api.popsi.co.followassistant.presenter;

import java.lang.ref.WeakReference;

import androidclient.api.popsi.co.followassistant.view.iview.BaseIView;

/**
 * Created by Kiven on 2016/11/19.
 */

public class BasePresenter<V extends BaseIView> {
    private WeakReference<V> weakReference;

    public void attach(V v) {
        weakReference = new WeakReference<V>(v);
    }

    public void deAttch() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    //获取保持关系的view
    public V getView() {
        return weakReference.get();
    }

}
