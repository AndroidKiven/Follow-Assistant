package androidclient.api.popsi.co.followassistant.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import androidclient.api.popsi.co.followassistant.R;
import androidclient.api.popsi.co.followassistant.adapter.ViewPagerFragmentAdapter;
import androidclient.api.popsi.co.followassistant.autoview.AutoToolbar;
import androidclient.api.popsi.co.followassistant.autoview.MyBottomNavigationView;
import androidclient.api.popsi.co.followassistant.presenter.MainActivityPresenter;
import androidclient.api.popsi.co.followassistant.view.fragment.EarnCoinsFragment;
import androidclient.api.popsi.co.followassistant.view.fragment.FollowersFragment;
import androidclient.api.popsi.co.followassistant.view.fragment.LikesFragment;
import androidclient.api.popsi.co.followassistant.view.fragment.MoreFragment;
import androidclient.api.popsi.co.followassistant.view.iview.IMainActivityView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kiven on 2017/2/24.
 */

public class MainActivity extends BaseTranslucentActivity<IMainActivityView, MainActivityPresenter> implements IMainActivityView {

    @BindView(R.id.tb_title)
    AutoToolbar tb_title;
    @BindView(R.id.vp_main_content)
    ViewPager vp_main_content;
    @BindView(R.id.bnv_bottom_bar)
    MyBottomNavigationView bnv_bottom_bar;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        setOrChangeTranslucentColor(tb_title, getResources().getColor(R.color.main_activity_toolbar));
        bnv_bottom_bar.SetNormalBottomNavigation();
        bnv_bottom_bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_earn_coins:
                        vp_main_content.setCurrentItem(0);
                        break;
                    case R.id.menu_likes:
                        vp_main_content.setCurrentItem(1);
                        break;
                    case R.id.menu_followers:
                        vp_main_content.setCurrentItem(2);
                        break;
                    case R.id.menu_more:
                        vp_main_content.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
        vp_main_content.setOffscreenPageLimit(2);
        vp_main_content.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bnv_bottom_bar.getMenu().getItem(0).setChecked(false);
                }
                bnv_bottom_bar.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bnv_bottom_bar.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp_main_content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        presenter.addFragmentToViewPager();
    }

    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenter();
    }

    @Override
    public void addFragmentToViewPager() {
        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        viewPagerFragmentAdapter.addFragment(new EarnCoinsFragment());
        viewPagerFragmentAdapter.addFragment(new LikesFragment());
        viewPagerFragmentAdapter.addFragment(new FollowersFragment());
        viewPagerFragmentAdapter.addFragment(new MoreFragment());
        vp_main_content.setAdapter(viewPagerFragmentAdapter);
    }
}
