package com.happy.high.news.ui.news.technology;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Module
public abstract class TechnologyFragmentProvider {

    @ContributesAndroidInjector(modules = TechnologyFragmentModule.class)
    abstract TechnologyFragment provideBlogFragmentFactory();
}
