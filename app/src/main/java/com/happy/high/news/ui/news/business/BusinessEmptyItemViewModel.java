package com.happy.high.news.ui.news.business;
/**
 * Created by Jagadish on 19/05/2020.
 */

public class BusinessEmptyItemViewModel {

    private BlogEmptyItemViewModelListener mListener;

    public BusinessEmptyItemViewModel(BlogEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface BlogEmptyItemViewModelListener {

        void onRetryClick();
    }
}
