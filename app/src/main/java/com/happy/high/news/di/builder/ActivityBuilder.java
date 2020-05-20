package com.happy.high.news.di.builder;

import com.happy.high.news.ui.news.NewsActivity;
import com.happy.high.news.ui.news.NewsActivityModule;
import com.happy.high.news.ui.news.business.BusinessFragmentProvider;
import com.happy.high.news.ui.news.technology.TechnologyFragmentProvider;
import com.happy.high.news.ui.splash.SplashActivity;
import com.happy.high.news.ui.web.WebActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            NewsActivityModule.class,
            BusinessFragmentProvider.class,
            TechnologyFragmentProvider.class})
    abstract NewsActivity bindFeedActivity();


    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract WebActivity bindWebActivity();
}
