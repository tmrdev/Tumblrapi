package org.timreynolds.tumblrapi.api;

import org.timreynolds.tumblrapi.ResponseData;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by sonic-ssd on 8/28/15.
 */
public class ApiManager {

    // http://api.tumblr.com/v2/blog/scipsy.tumblr.com/posts?limit=2&api_key=fuiKNFp9vQFvjLNvx4sUwti4Yb5yGutBN4Xh10LXZhhRKjWlV4

    //private static final String API_URL = "https://api.github.com";
    private static final String API_URL = "http://api.tumblr.com/v2/";

    public interface TumblrService {
        //@GET("/blog/{blog_name}/posts")
        @GET("/blog/{blog_host}/posts")
        // asynchronous execution with callback as last parameter
        void getData(@Query("type") String postType, @Query("limit") int limitValue, @Path("blog_host") String blogHost, Callback<ResponseData> callback);
    }

    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();

    private static final TumblrService TUMBLR_SERVICE = REST_ADAPTER.create(TumblrService.class);

    public static TumblrService getService() {
        return TUMBLR_SERVICE;
    }
}
