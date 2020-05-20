package com.happy.high.news.ui.news.business;

import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.happy.high.news.data.model.api.BlogResponse;
import com.happy.high.news.databinding.ItemNewsEmptyViewBinding;
import com.happy.high.news.databinding.ItemNewsViewBinding;
import com.happy.high.news.ui.web.WebActivity;
import com.happy.high.news.utils.AppLogger;
import com.happy.high.news.ui.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class BusinessAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<BlogResponse.Blog> mBlogResponseList;

    private BlogAdapterListener mListener;

    public BusinessAdapter(List<BlogResponse.Blog> blogResponseList) {
        this.mBlogResponseList = blogResponseList;
    }

    @Override
    public int getItemCount() {
        if (mBlogResponseList != null && mBlogResponseList.size() > 0) {
            return mBlogResponseList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mBlogResponseList != null && !mBlogResponseList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemNewsViewBinding blogViewBinding = ItemNewsViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new BlogViewHolder(blogViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemNewsEmptyViewBinding emptyViewBinding = ItemNewsEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    public void addItems(List<BlogResponse.Blog> blogList) {
        mBlogResponseList.addAll(blogList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mBlogResponseList.clear();
    }

    public void setListener(BlogAdapterListener listener) {
        this.mListener = listener;
    }

    public interface BlogAdapterListener {

        void onRetryClick();
    }

    public class BlogViewHolder extends BaseViewHolder implements BusinessItemViewModel.BlogItemViewModelListener {

        private ItemNewsViewBinding mBinding;

        private BusinessItemViewModel mBusinessItemViewModel;

        public BlogViewHolder(ItemNewsViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final BlogResponse.Blog blog = mBlogResponseList.get(position);
            mBusinessItemViewModel = new BusinessItemViewModel(blog, this);
            mBinding.setViewModel(mBusinessItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(String blogUrl) {
            if (blogUrl != null) {
                try {
                    Intent intent = new Intent(itemView.getContext(), WebActivity.class);
                    intent.putExtra("url",blogUrl);
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("url error");
                }
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements BusinessEmptyItemViewModel.BlogEmptyItemViewModelListener {

        private ItemNewsEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemNewsEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            BusinessEmptyItemViewModel emptyItemViewModel = new BusinessEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }
}