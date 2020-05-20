package com.happy.high.news.di.component;

import android.app.Application;
import com.happy.high.news.NewsApp;
import com.happy.high.news.di.builder.ActivityBuilder;
import com.happy.high.news.di.module.AppModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(NewsApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
