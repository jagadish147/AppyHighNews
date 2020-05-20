package com.happy.high.news.utils;

import android.content.Context;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.happy.high.news.data.model.api.BlogResponse;
import com.happy.high.news.ui.news.business.BusinessAdapter;

import java.util.List;

/**
 * Created by Jagadish on 19/05/2020.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addBlogItems(RecyclerView recyclerView, List<BlogResponse.Blog> blogs) {
        BusinessAdapter adapter = (BusinessAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(blogs);
        }
    }





    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }
}
