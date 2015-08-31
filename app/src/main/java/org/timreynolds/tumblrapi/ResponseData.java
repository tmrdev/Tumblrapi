package org.timreynolds.tumblrapi;

import com.google.gson.annotations.SerializedName;
import org.timreynolds.tumblrapi.models.Meta;
import org.timreynolds.tumblrapi.models.Response;
import org.timreynolds.tumblrapi.models.Blog;

public class ResponseData {
    @SerializedName("meta")
    Meta meta;

    @SerializedName("response")
    Response response;

    public Response getResponse() {
        return response;
    }

    public Meta getMeta() {
        return meta;
    }

}
