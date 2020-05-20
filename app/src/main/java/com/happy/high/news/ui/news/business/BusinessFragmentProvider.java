package com.happy.high.news.ui.news.business;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Module
public abstract class BusinessFragmentProvider {

    @ContributesAndroidInjector(modules = BusinessFragmentModule.class)
    abstract BusinessFragment provideBlogFragmentFactory();
}
