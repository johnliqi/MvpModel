package com.example.mvpmodel.Activity.base.Base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvpmodel.Presenter.BasePresenter;

import butterknife.ButterKnife;

public abstract class  BaseFragment<T extends BasePresenter> extends Fragment {
    protected T presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(provideViewLayout(), container, false);
        ButterKnife.bind(this, view);
        initPresenter();
        return view;
    }

    protected abstract int provideViewLayout();

    protected abstract void initPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //TODO 检查内存泄露
    }
}
