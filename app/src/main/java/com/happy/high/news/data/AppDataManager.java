package com.happy.high.news.data;

import android.content.Context;

import com.google.gson.Gson;
import com.happy.high.news.data.model.api.BlogResponse;
import com.happy.high.news.data.remote.ApiHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final ApiHelper mApiHelper;

    private final Context mContext;


    private final Gson mGson;


    @Inject
    public AppDataManager(Context context,  ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mApiHelper = apiHelper;
        mGson = gson;
    }


    @Override
    public Single<BlogResponse> getBlogApiCall(String countryCode) {
        return mApiHelper.getBlogApiCall(countryCode);
    }

    @Override
    public Single<BlogResponse> getTechnologyApiCall(String countryCode) {
        return mApiHelper.getTechnologyApiCall(countryCode);
    }


}
