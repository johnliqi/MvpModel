package com.example.mvpmodel.Presenter;

import android.content.Context;
import android.content.Intent;

import com.example.mvpmodel.View.IBaseView;

public class MainPresenter extends  BasePresenter<IBaseView> {
    public MainPresenter(Context context, IBaseView iView) {
        super(context, iView);
    }

    @Override
    public void release() {

    }


    //    public void toDailyActivity() {
//        Intent intent = new Intent(context, DailyActivity.class);
//        context.startActivity(intent);
//    }
//
//    public void toAboutActivity() {
//        Intent intent = new Intent(context, AboutActivity.class);
//        context.startActivity(intent);
//    }
//
//    public void toSettingActivity() {
//        Intent intent = new Intent(context, SettingActivity.class);
//        context.startActivity(intent);
//    }

}
