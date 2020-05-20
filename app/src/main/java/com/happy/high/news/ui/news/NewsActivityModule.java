package com.happy.high.news.ui.news;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Module
public class NewsActivityModule {

    @Provides
    NewsPagerAdapter provideFeedPagerAdapter(NewsActivity activity) {
        return new NewsPagerAdapter(activity.getSupportFragmentManager());
    }

}
