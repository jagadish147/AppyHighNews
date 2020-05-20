package com.happy.high.news.ui.news.technology;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.happy.high.news.ui.news.business.BusinessAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jagadish on 19/05/2020.
 */
@Module
public class TechnologyFragmentModule {

    @Provides
    BusinessAdapter provideBlogAdapter() {
        return new BusinessAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(TechnologyFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
