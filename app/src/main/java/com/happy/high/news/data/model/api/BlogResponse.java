package com.happy.high.news.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Jagadish on 19/05/2020.
 */

public class BlogResponse {

    @Expose
    @SerializedName("articles")
    private List<Blog> articles;

    @Expose
    @SerializedName("totalResults")
    private int totalResults;

    @Expose
    @SerializedName("status")
    private String statusCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BlogResponse)) {
            return false;
        }

        BlogResponse that = (BlogResponse) o;

        if (!statusCode.equals(that.statusCode)) {
            return false;
        }

        return articles.equals(that.articles);

    }

    @Override
    public int hashCode() {
        int result = statusCode.hashCode();
        result = 31 * result + articles.hashCode();
        return result;
    }

    public List<Blog> getData() {
        return articles;
    }



    public String getStatusCode() {
        return statusCode;
    }

    public static class Blog {

        @Expose
        @SerializedName("author")
        private String author;

        @Expose
        @SerializedName("url")
        private String blogUrl;

        @Expose
        @SerializedName("urlToImage")
        private String coverImgUrl;

        @Expose
        @SerializedName("publishedAt")
        private String date;

        @Expose
        @SerializedName("description")
        private String description;

        @Expose
        @SerializedName("title")
        private String title;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Blog)) {
                return false;
            }

            Blog blog = (Blog) o;

            if (!blogUrl.equals(blog.blogUrl)) {
                return false;
            }
            if (!coverImgUrl.equals(blog.coverImgUrl)) {
                return false;
            }
            if (!title.equals(blog.title)) {
                return false;
            }
            if (!description.equals(blog.description)) {
                return false;
            }
            if (!author.equals(blog.author)) {
                return false;
            }
            return date.equals(blog.date);

        }

        @Override
        public int hashCode() {
            int result = blogUrl.hashCode();
            result = 31 * result + coverImgUrl.hashCode();
            result = 31 * result + title.hashCode();
            result = 31 * result + description.hashCode();
            result = 31 * result + author.hashCode();
            result = 31 * result + date.hashCode();
            return result;
        }

        public String getAuthor() {
            return author;
        }

        public String getBlogUrl() {
            return blogUrl;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public String getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }

        public String getTitle() {
            return title;
        }
    }
}