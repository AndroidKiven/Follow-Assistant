package androidclient.api.popsi.co.followassistant.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidclient.api.popsi.co.followassistant.R;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/24.
 */

public class EarnCoinsFragment extends Fragment {

    View mFragmentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == mFragmentView) {
            mFragmentView = inflater.inflate(R.layout.fragment_earn_coins, container, false);
            ButterKnife.bind(this, mFragmentView);
            // initView();
            //  initData();
        }
        return mFragmentView;
    }
}
