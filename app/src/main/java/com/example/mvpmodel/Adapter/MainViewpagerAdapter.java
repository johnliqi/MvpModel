package com.example.mvpmodel.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mvpmodel.MainFragment;
import com.example.mvpmodel.Presenter.ChromeViewPresenter;

public class MainViewpagerAdapter extends FragmentStatePagerAdapter {
    String[] title = {"Android", "iOS", "前端", "瞎推荐", "拓展资源", "App"};
    private ChromeViewPresenter presenter;

    public MainViewpagerAdapter(FragmentManager fm, ChromeViewPresenter presenter) {
        super(fm);
        this.presenter = presenter;
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(title[position], presenter);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
