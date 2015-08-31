package org.timreynolds.tumblrapi.models;
import com.google.gson.annotations.SerializedName;

import android.text.Html;
import java.util.List;

public class Posts {
    @SerializedName("post_url")
    String post_url;

    @SerializedName("caption")
    String caption;

    @SerializedName("format")
    String format;

    @SerializedName("image_permalink")
    String image_permalink;

    @SerializedName("photos")
    List<Photos> photos;

    public String getCaption(){
        return Html.fromHtml(caption).toString();
    }

    public List<Photos> getPhotos(){
        return photos;
    }

    public String getImage_permalink(){
        return image_permalink;
    }

    public String getFormat(){
        return format;
    }

    public String getPost_url(){
        return post_url;
    }

}