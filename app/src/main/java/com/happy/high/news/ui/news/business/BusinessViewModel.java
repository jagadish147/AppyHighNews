package com.happy.high.news.ui.news.business;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.happy.high.news.data.DataManager;
import com.happy.high.news.data.model.api.BlogResponse;
import com.happy.high.news.ui.base.BaseViewModel;
import com.happy.high.news.utils.rx.SchedulerProvider;
import java.util.List;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class BusinessViewModel extends BaseViewModel<BusinessNavigator> {

    private final MutableLiveData<List<BlogResponse.Blog>> blogListLiveData;

    public BusinessViewModel(DataManager dataManager,
                             SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        blogListLiveData = new MutableLiveData<>();

    }

    public void fetchBlogs() {
        String countryCode = getNavigator().getBaseAcitivity().getResources().getConfiguration().locale.getCountry();
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getBlogApiCall(countryCode)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(blogResponse -> {
                    if (blogResponse != null && blogResponse.getData() != null) {
                        blogListLiveData.setValue(blogResponse.getData());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public LiveData<List<BlogResponse.Blog>> getBlogListLiveData() {
        return blogListLiveData;
    }
}
