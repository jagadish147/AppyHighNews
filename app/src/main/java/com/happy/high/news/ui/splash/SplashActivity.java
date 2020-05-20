package com.happy.high.news.ui.splash;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;

import com.happy.high.news.BR;
import com.happy.high.news.R;
import com.happy.high.news.ViewModelProviderFactory;
import com.happy.high.news.databinding.ActivitySplashBinding;
import com.happy.high.news.ui.base.BaseActivity;
import com.happy.high.news.ui.news.NewsActivity;

import javax.inject.Inject;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    ViewModelProviderFactory factory;
    
    private SplashViewModel mSplashViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        mSplashViewModel = ViewModelProviders.of(this,factory).get(SplashViewModel.class);
        return mSplashViewModel;
    }

    @Override
    public void openLoginActivity() {
        Intent intent = NewsActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = NewsActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
    }
}
