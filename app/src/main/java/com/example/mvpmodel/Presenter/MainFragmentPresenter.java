package com.example.mvpmodel.Presenter;

import android.content.Context;

import com.example.mvpmodel.Model.entity.MainData;
import com.example.mvpmodel.http.GankRetrofitClient;
import com.example.mvpmodel.views.IMainFragmentView;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.PUT;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class MainFragmentPresenter extends BasePresenter<IMainFragmentView> {
    public MainFragmentPresenter(Context context, IMainFragmentView iView) {
        super(context, iView);
    }

    @Override
    public void release() {
        if (disposable != null && disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public void loadGank(String type, int page) {
        iView.showProgress();
        disposable= GankRetrofitClient.getGankRetrofitInstance().getMainData(type,page).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<MainData>() {
            @Override
            public void accept(MainData mainData) throws Exception {
                iView.hideProgress();
                if (mainData.results == null) {
                    iView.showNoMoreData();
                } else {
                    iView.showListView(mainData.results);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                iView.hideProgress();
                iView.showErrorView();
            }
        });
    }
}
