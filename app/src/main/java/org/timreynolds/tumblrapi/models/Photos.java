package org.timreynolds.tumblrapi.models;

import com.google.gson.annotations.SerializedName;
import org.timreynolds.tumblrapi.models.Posts;
import java.util.List;

public class Photos{

    @SerializedName("alt_sizes")
    List<Altsizes> altsizes;


    public List<Altsizes> getAltsizes(){
        return altsizes;
    }

}