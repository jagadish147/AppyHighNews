package com.happy.high.news.ui.news;

import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import android.view.MenuItem;

import com.happy.high.news.BR;
import com.happy.high.news.R;
import com.happy.high.news.ViewModelProviderFactory;
import com.happy.high.news.databinding.ActivityNewsBinding;
import com.happy.high.news.ui.base.BaseActivity;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class NewsActivity extends BaseActivity<ActivityNewsBinding, NewsViewModel> implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    NewsPagerAdapter mPagerAdapter;
    @Inject
    ViewModelProviderFactory factory;
    private ActivityNewsBinding mActivityFeedBinding;
    private NewsViewModel mNewsViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, NewsActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    public NewsViewModel getViewModel() {
        mNewsViewModel = ViewModelProviders.of(this,factory).get(NewsViewModel.class);
        return mNewsViewModel;
    }



    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityFeedBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        setSupportActionBar(mActivityFeedBinding.toolbar);

        MobileAds.initialize(this, initializationStatus -> {
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mActivityFeedBinding.adView.loadAd(adRequest);
        mPagerAdapter.setCount(2);

        mActivityFeedBinding.feedViewPager.setAdapter(mPagerAdapter);

        mActivityFeedBinding.tabLayout.addTab(mActivityFeedBinding.tabLayout.newTab().setText(getString(R.string.blog)));
        mActivityFeedBinding.tabLayout.addTab(mActivityFeedBinding.tabLayout.newTab().setText(getString(R.string.open_source)));

        mActivityFeedBinding.feedViewPager.setOffscreenPageLimit(mActivityFeedBinding.tabLayout.getTabCount());

        mActivityFeedBinding.feedViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mActivityFeedBinding.tabLayout));

        mActivityFeedBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mActivityFeedBinding.feedViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
        });
    }
}
