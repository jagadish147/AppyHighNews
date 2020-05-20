package com.happy.high.news.ui.news.technology;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.happy.high.news.BR;
import com.happy.high.news.R;
import com.happy.high.news.data.model.api.BlogResponse;
import com.happy.high.news.databinding.FragmentTechnologyBinding;
import com.happy.high.news.ui.news.business.BusinessAdapter;
import com.happy.high.news.ViewModelProviderFactory;
import com.happy.high.news.ui.base.BaseActivity;
import com.happy.high.news.ui.base.BaseFragment;
import com.happy.high.news.ui.news.business.BusinessNavigator;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class TechnologyFragment extends BaseFragment<FragmentTechnologyBinding, TechnologyViewModel>
        implements BusinessNavigator, BusinessAdapter.BlogAdapterListener {

    @Inject
    BusinessAdapter mBusinessAdapter;
    FragmentTechnologyBinding mFragmentBlogBinding;
    @Inject
    LinearLayoutManager mLayoutManager;
    @Inject
    ViewModelProviderFactory factory;
    private TechnologyViewModel mBlogViewModel;

    public static TechnologyFragment newInstance() {
        Bundle args = new Bundle();
        TechnologyFragment fragment = new TechnologyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_technology;
    }

    @Override
    public TechnologyViewModel getViewModel() {
        mBlogViewModel = ViewModelProviders.of(this, factory).get(TechnologyViewModel.class);
        return mBlogViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBlogViewModel.setNavigator(this);
        mBusinessAdapter.setListener(this);
    }

    @Override
    public void onRetryClick() {
        mBlogViewModel.fetchTechnology();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentBlogBinding = getViewDataBinding();
        setUp();
    }

    @Override
    public void updateBlog(List<BlogResponse.Blog> blogList) {
        mBusinessAdapter.addItems(blogList);
    }

    @Override
    public BaseActivity getBaseAcitivity() {
        return getBaseActivity();
    }

    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentBlogBinding.blogRecyclerView.setLayoutManager(mLayoutManager);
        mFragmentBlogBinding.blogRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFragmentBlogBinding.blogRecyclerView.setAdapter(mBusinessAdapter);

        mBlogViewModel.fetchTechnology();
    }
}
