package org.timreynolds.tumblrapi.models;

import com.google.gson.annotations.SerializedName;


public class Meta {
    @SerializedName("msg")
    String msg;

    @SerializedName("status")
    String status;

    public String getStatus(){
        return status;
    }
}
