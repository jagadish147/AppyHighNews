package com.happy.high.news.ui.web;

import com.happy.high.news.data.DataManager;
import com.happy.high.news.ui.base.BaseViewModel;
import com.happy.high.news.utils.rx.SchedulerProvider;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class WebViewModel extends BaseViewModel<WebNavigator> {

    public WebViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }




}
