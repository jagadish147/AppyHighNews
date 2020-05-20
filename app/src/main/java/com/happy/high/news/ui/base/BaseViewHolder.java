package com.happy.high.news.ui.base;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * Created by Jagadish on 19/05/2020.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
