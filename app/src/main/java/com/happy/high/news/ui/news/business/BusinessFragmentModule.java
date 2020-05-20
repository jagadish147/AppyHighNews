package com.happy.high.news.ui.news.business;

import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Module
public class BusinessFragmentModule {

    @Provides
    BusinessAdapter provideBlogAdapter() {
        return new BusinessAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(BusinessFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
