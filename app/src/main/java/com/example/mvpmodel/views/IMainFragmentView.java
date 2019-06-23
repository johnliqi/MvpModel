package com.example.mvpmodel.views;
import com.example.mvpmodel.Model.entity.Gank;
import com.example.mvpmodel.View.IBaseView;

import java.util.List;

/**
 * Created by bob on 17-5-1.
 */

public interface IMainFragmentView extends IBaseView {
        void showProgress();

        void hideProgress();

        void showErrorView();

        void showNoMoreData();

        void showListView(List<Gank> gankList);
}
