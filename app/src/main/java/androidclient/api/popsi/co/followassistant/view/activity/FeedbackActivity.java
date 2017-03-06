package androidclient.api.popsi.co.followassistant.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.autoview.AutoToolbar;
import androidclient.api.popsi.co.followassistant.presenter.FeedbackActivityPresenter;
import androidclient.api.popsi.co.followassistant.view.iview.IFeedbackActivityView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/3/4.
 */

public class FeedbackActivity extends BaseTranslucentActivity<IFeedbackActivityView, FeedbackActivityPresenter> implements IFeedbackActivityView {

    @BindView(R.id.tb_feedbcak)
    AutoToolbar tb_feedbcak;
    @BindView(R.id.bt_submit_feedback)
    Button bt_submit_feedback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_fragment_feedback);
        ButterKnife.bind(this);
        setOrChangeTranslucentColor(tb_feedbcak, getResources().getColor(R.color.main_activity_toolbar));
        tb_feedbcak.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public FeedbackActivityPresenter createPresenter() {
        return new FeedbackActivityPresenter();
    }


}
