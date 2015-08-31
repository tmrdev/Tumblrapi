package org.timreynolds.tumblrapi.models;

import com.google.gson.annotations.SerializedName;

public class Altsizes {

    @SerializedName("height")
    int height;

    @SerializedName("url")
    String url;

    @SerializedName("width")
    int width;

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public String getUrl(){
        return url;
    }
}
