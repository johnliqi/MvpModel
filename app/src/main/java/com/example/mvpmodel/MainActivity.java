package com.example.mvpmodel;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpmodel.Activity.base.Base.ToolBarActivity;
import com.example.mvpmodel.Adapter.MainViewpagerAdapter;
import com.example.mvpmodel.Presenter.ChromeViewPresenter;
import com.example.mvpmodel.Presenter.MainPresenter;
import com.example.mvpmodel.View.IBaseView;
import com.example.mvpmodel.views.customView;

import butterknife.BindView;

//Dev/app 合并分支 0000
public class MainActivity extends ToolBarActivity<MainPresenter> implements IBaseView, Toolbar.OnMenuItemClickListener {
    private TextView mTextMessage;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.draw_layout)
    DrawerLayout drawer;
    @BindView(R.id.ng_view)
    NavigationView mNavigationView;
    @BindView(R.id.vPager)
    ViewPager mViewpager;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    //init fab&click
    public static FloatingActionButton fab;
    ViewGroup viewGroup;
    ChromeViewPresenter chromeViewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        fab = (FloatingActionButton) findViewById(R.id.fab_main);
        chromeViewPresenter = new ChromeViewPresenter(this, fab,this, this);
        presenter = new MainPresenter(this, this);
        presenter.init();

    }

    @Override
    public void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
//        android.support.v7.app.ActionBarDrawerToggle toggle = new android.support.v7.app.ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        android.support.v7.app.ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

//   Animation loadAnimation = AnimationUtils.loadAnimation(this,
//                R.anim.translate);
//        loadAnimation.setFillAfter(true);
//        loadAnimation.setDuration(100);
        //mcustomview.smoothScroll(-50,0);
//        mcustomview.setAnimation(loadAnimation);
        //ObjectAnimator.ofFloat(mcustomview,"translationX",0,300).setDuration(100).start();
        //   mToolBar.setNavigationIcon(R.drawable.ic_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.nav_about:
                        drawer.closeDrawer(GravityCompat.START);
                    default:
                        drawer.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });
        toolbar.setOnMenuItemClickListener(this);
        MainViewpagerAdapter mainViewpagerAdapter = new MainViewpagerAdapter(getSupportFragmentManager(), chromeViewPresenter);
        mViewpager.setAdapter(mainViewpagerAdapter);
        mViewpager.setOffscreenPageLimit(5);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
//            case R.id.action_search:
//                Toast.makeText(MainActivity.this, "Search !", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.action_notifications:
//                Toast.makeText(MainActivity.this, "Notificationa !", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.action_settings:
//                Toast.makeText(MainActivity.this, "Settings !", Toast.LENGTH_SHORT).show();
//                break;
        }

        return true;
    }
}
