package com.happy.high.news.ui.web;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.happy.high.news.BR;
import com.happy.high.news.R;
import com.happy.high.news.ViewModelProviderFactory;
import com.happy.high.news.databinding.ActivityWebBinding;
import com.happy.high.news.ui.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class WebActivity extends BaseActivity<ActivityWebBinding, WebViewModel> {

    @Inject
    ViewModelProviderFactory factory;
    
    private WebViewModel mSplashViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public WebViewModel getViewModel() {
        mSplashViewModel = ViewModelProviders.of(this,factory).get(WebViewModel.class);
        return mSplashViewModel;
    }

    WebView webView;
    SwipeRefreshLayout refreshLayout;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup();

    }

    private void setup(){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        url = getIntent().getStringExtra("url");

        refreshLayout = findViewById(R.id.swipe_refresh);

        refreshLayout.setRefreshing(true);

        refreshLayout.setColorSchemeResources(
                R.color.colorAccent,
                R.color.colorGreen,
                R.color.colorBlue,
                R.color.colorOrange);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.loadUrl(url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    refreshLayout.setRefreshing(false);
                } else {
                    refreshLayout.setRefreshing(true);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getCacheDir().deleteOnExit();
        webView.clearCache(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                upIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
