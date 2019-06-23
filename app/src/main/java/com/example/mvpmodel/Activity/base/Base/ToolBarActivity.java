package com.example.mvpmodel.Activity.base.Base;

;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.animation.DecelerateInterpolator;

import com.example.mvpmodel.BaseActivity;
import com.example.mvpmodel.Presenter.BasePresenter;
import com.example.mvpmodel.R;

public abstract class ToolBarActivity<T extends BasePresenter> extends BaseActivity {
    protected ActionBar actionBar;
    protected T presenter;
    protected boolean isToolBarHiding = false;
    public static Toolbar toolbar;
    protected AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        initToolBar();
        initPresenter();
    }
    protected boolean canBack() {
        return true;
    }

    protected void initToolBar() {
        setSupportActionBar(toolbar);
        //TODO 需要在子类实现
    }

    protected void hideOrShowToolBar() {
        appBarLayout.animate()
                .translationY(isToolBarHiding?0:-appBarLayout.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        isToolBarHiding = !isToolBarHiding;
    }

}
