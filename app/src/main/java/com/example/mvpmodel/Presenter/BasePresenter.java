package com.example.mvpmodel.Presenter;

import android.content.Context;

import com.example.mvpmodel.View.IBaseView;

import io.reactivex.disposables.Disposable;
import rx.internal.util.SubscriptionList;

public abstract class BasePresenter<T extends IBaseView> {
    protected T iView;//所以的view
    protected Disposable disposable;
    protected Context context;


    public BasePresenter(Context context, T iView) {
        this.context = context;
        this.iView = iView;
    }

    public void init() {
        iView.init();
    }

    public abstract void release();

}
