package com.happy.high.news;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.happy.high.news.data.DataManager;
import com.happy.high.news.ui.news.NewsViewModel;
import com.happy.high.news.ui.news.business.BusinessViewModel;
import com.happy.high.news.ui.news.technology.TechnologyViewModel;
import com.happy.high.news.ui.splash.SplashViewModel;
import com.happy.high.news.ui.web.WebViewModel;
import com.happy.high.news.utils.rx.SchedulerProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

  private final DataManager dataManager;
  private final SchedulerProvider schedulerProvider;

  @Inject
  public ViewModelProviderFactory(DataManager dataManager,
      SchedulerProvider schedulerProvider) {
    this.dataManager = dataManager;
    this.schedulerProvider = schedulerProvider;
  }


  @Override
  public <T extends ViewModel> T create(Class<T> modelClass) {
     if (modelClass.isAssignableFrom(NewsViewModel.class)) {
      //noinspection unchecked
      return (T) new NewsViewModel(dataManager,schedulerProvider);
    }
    else if (modelClass.isAssignableFrom(BusinessViewModel.class)) {
      //noinspection unchecked
      return (T) new BusinessViewModel(dataManager,schedulerProvider);
    }else if (modelClass.isAssignableFrom(TechnologyViewModel.class)) {
      //noinspection unchecked
      return (T) new TechnologyViewModel(dataManager,schedulerProvider);
    } else if (modelClass.isAssignableFrom(WebViewModel.class)) {
      //noinspection unchecked
      return (T) new WebViewModel(dataManager,schedulerProvider);
    }else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
      //noinspection unchecked
      return (T) new SplashViewModel(dataManager,schedulerProvider);
    }
    throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
  }
}