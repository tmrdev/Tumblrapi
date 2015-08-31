package org.timreynolds.tumblrapi.models;

import com.google.gson.annotations.SerializedName;
import org.timreynolds.tumblrapi.models.Posts;

import java.util.List;

public class Response {
    @SerializedName("blog")
    Blog blog;

    @SerializedName("posts")
    public List<Posts> posts;

    public Blog getBlog(){
        return blog;
    }

    public List<Posts> getPosts() {
        return posts;
    }
}
