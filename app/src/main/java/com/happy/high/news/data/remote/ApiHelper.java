package com.happy.high.news.data.remote;

import com.happy.high.news.data.model.api.BlogResponse;

import io.reactivex.Single;

/**
 * Created by Jagadish on 19/05/2020.
 */

public interface ApiHelper {



    Single<BlogResponse> getBlogApiCall(String countryCode);

    Single<BlogResponse> getTechnologyApiCall(String countryCode);

}
