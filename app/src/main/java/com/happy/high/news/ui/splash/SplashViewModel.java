package com.happy.high.news.ui.splash;

import com.happy.high.news.data.DataManager;
import com.happy.high.news.ui.base.BaseViewModel;
import com.happy.high.news.utils.rx.SchedulerProvider;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


}
