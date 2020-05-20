package com.happy.high.news.ui.news.business;

import com.happy.high.news.data.model.api.BlogResponse;
import com.happy.high.news.ui.base.BaseActivity;

import java.util.List;

/**
 * Created by Jagadish on 19/05/2020.
 */

public interface BusinessNavigator {

    void handleError(Throwable throwable);

    void updateBlog(List<BlogResponse.Blog> blogList);

    BaseActivity getBaseAcitivity();
}
