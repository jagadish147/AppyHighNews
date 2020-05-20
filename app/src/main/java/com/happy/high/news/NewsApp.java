package com.happy.high.news;

import android.app.Activity;
import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.google.android.gms.ads.MobileAds;
import com.happy.high.news.di.component.DaggerAppComponent;
import com.happy.high.news.utils.AppLogger;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class NewsApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;



    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // initialize the AdMob app
        MobileAds.initialize(getApplicationContext(), getString(R.string.admob_app_id));
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }




    }
}
