package com.example.mvpmodel.Presenter;

import com.example.mvpmodel.View.IBaseView;

public interface Ipresenter<T extends IBaseView> {
    //  @description 关联P与V（绑定，VIEW销毁适合解绑）
    void attachView(T view);

    void detachView();

    void subscribe();

    void unsubscribe();
}
