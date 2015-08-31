package org.timreynolds.tumblrapi.models;
import com.google.gson.annotations.SerializedName;

import org.timreynolds.tumblrapi.models.Response;
import org.timreynolds.tumblrapi.ResponseData;


public class Blog {
    @SerializedName("name")
    String name;

    public String getName(){
        return name;
    }
}
