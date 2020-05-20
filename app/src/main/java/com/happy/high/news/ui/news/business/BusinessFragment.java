package com.happy.high.news.ui.news.business;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.View;

import com.happy.high.news.BR;
import com.happy.high.news.R;
import com.happy.high.news.data.model.api.BlogResponse;
import com.happy.high.news.ViewModelProviderFactory;
import com.happy.high.news.databinding.FragmentBusinessBinding;
import com.happy.high.news.ui.base.BaseActivity;
import com.happy.high.news.ui.base.BaseFragment;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class BusinessFragment extends BaseFragment<FragmentBusinessBinding, BusinessViewModel>
        implements BusinessNavigator, BusinessAdapter.BlogAdapterListener {

    @Inject
    BusinessAdapter mBusinessAdapter;
    FragmentBusinessBinding mFragmentBlogBinding;
    @Inject
    LinearLayoutManager mLayoutManager;
    @Inject
    ViewModelProviderFactory factory;
    private BusinessViewModel mBusinessViewModel;

    public static BusinessFragment newInstance() {
        Bundle args = new Bundle();
        BusinessFragment fragment = new BusinessFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_business;
    }

    @Override
    public BusinessViewModel getViewModel() {
        mBusinessViewModel = ViewModelProviders.of(this, factory).get(BusinessViewModel.class);
        return mBusinessViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBusinessViewModel.setNavigator(this);
        mBusinessAdapter.setListener(this);
    }

    @Override
    public void onRetryClick() {
        mBusinessViewModel.fetchBlogs();
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

        mBusinessViewModel.fetchBlogs();
    }
}
