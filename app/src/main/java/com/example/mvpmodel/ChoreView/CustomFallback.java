/*
 * Copyright 2017 lizhaotailang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mvpmodel.ChoreView;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;


import com.example.mvpmodel.Model.entity.Gank;
import com.example.mvpmodel.R;
import com.example.mvpmodel.WebViewActivity;
import com.example.mvpmodel.http.GankConfig;

import Utils.SnackBarUtil;


/**
 * Created by Lizhaotailang on 2016/9/4.
 */

public class CustomFallback implements CustomTabActivityHelper.CustomTabFallback {

    @Override
    public void openUri(Activity activity, Gank gank) {
            activity.startActivity(new Intent(activity, WebViewActivity.class).putExtra(GankConfig.GANK, gank));
    }

        @Override
        public void openUri(final Activity activity, final View view, final Gank gank) {
                SnackBarUtil.showTipWithAction(view, activity.getString(R.string.no_chrome_info), activity.getString(R.string.comfirm), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                activity.startActivity(new Intent(activity, WebViewActivity.class).putExtra(GankConfig.GANK, gank));
                        }
                });
        }


    @Override
        public void openUri(Activity activity, String url) {
                activity.startActivity(new Intent(activity, WebViewActivity.class).putExtra(GankConfig.URL, url));
                Log.d("CustomFallback", "Can  resolve openUri");
        }


}
