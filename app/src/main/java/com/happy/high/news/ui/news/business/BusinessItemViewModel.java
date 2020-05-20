package com.happy.high.news.ui.news.business;

import androidx.databinding.ObservableField;

import com.happy.high.news.data.model.api.BlogResponse;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class BusinessItemViewModel {

    public final ObservableField<String> author;

    public final ObservableField<String> content;

    public final ObservableField<String> date;

    public final ObservableField<String> imageUrl;

    public final BlogItemViewModelListener mListener;

    public final ObservableField<String> title;

    private final BlogResponse.Blog mBlog;

    public BusinessItemViewModel(BlogResponse.Blog blog, BlogItemViewModelListener listener) {
        this.mBlog = blog;
        this.mListener = listener;
        imageUrl = new ObservableField<>(mBlog.getCoverImgUrl());
        title = new ObservableField<>(mBlog.getTitle());
        author = new ObservableField<>(mBlog.getAuthor());
        date = new ObservableField<>(mBlog.getDate());
        content = new ObservableField<>(mBlog.getDescription());
    }

    public void onItemClick() {
        mListener.onItemClick(mBlog.getBlogUrl());
    }

    public interface BlogItemViewModelListener {

        void onItemClick(String blogUrl);
    }
}
