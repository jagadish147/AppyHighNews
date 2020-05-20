package com.happy.high.news.data.remote;

import com.happy.high.news.BuildConfig;
import com.happy.high.news.data.model.api.BlogResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;
/**
 * Created by Jagadish on 19/05/2020.
 */

@Singleton
public class AppApiHelper implements ApiHelper {


    @Inject
    public AppApiHelper() {

    }


    @Override
    public Single<BlogResponse> getBlogApiCall(String countryCode) {
        return Rx2AndroidNetworking.get(BuildConfig.BASE_URL +"top-headlines?country="+countryCode+"&category=business&apiKey="+BuildConfig.API_KEY)
                .build()
                .getObjectSingle(BlogResponse.class);
    }

    @Override
    public Single<BlogResponse> getTechnologyApiCall(String countryCode) {
        return Rx2AndroidNetworking.get(BuildConfig.BASE_URL +"top-headlines?country="+countryCode+"&category=technology&apiKey="+BuildConfig.API_KEY)
                .build()
                .getObjectSingle(BlogResponse.class);
    }


}
