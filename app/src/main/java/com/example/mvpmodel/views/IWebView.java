package com.example.mvpmodel.views;

import com.example.mvpmodel.View.IBaseView;

/**
 * Created by bob on 17-5-1.
 */

public interface IWebView extends IBaseView {
        void showProgress(int progress);

        void setWebTitle(String title);

        void openFailed();
}
