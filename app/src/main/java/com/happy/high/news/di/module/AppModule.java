package com.happy.high.news.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.happy.high.news.BuildConfig;
import com.happy.high.news.data.AppDataManager;
import com.happy.high.news.data.DataManager;
import com.happy.high.news.data.remote.ApiHelper;
import com.happy.high.news.data.remote.AppApiHelper;
import com.happy.high.news.di.ApiInfo;
import com.happy.high.news.utils.rx.AppSchedulerProvider;
import com.happy.high.news.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }




    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }



    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }





    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
