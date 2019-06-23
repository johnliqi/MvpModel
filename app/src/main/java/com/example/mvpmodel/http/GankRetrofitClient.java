package com.example.mvpmodel.http;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GankRetrofitClient {
    private static GankRetrofit mGankRetrofit;
    protected static final Object monitor = new Object();
    private static Retrofit retrofit;
    private  GankRetrofitClient (){

    }
    static {
        Gson date_gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        retrofit = new Retrofit.Builder()
                .baseUrl(GankConfig.HOST)
                .addConverterFactory(GsonConverterFactory.create(date_gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static GankRetrofit getGankRetrofitInstance() {
        synchronized (monitor) {
            if (mGankRetrofit == null) {
                mGankRetrofit = retrofit.create(GankRetrofit.class);
            }
            return mGankRetrofit;
        }
    }
}
