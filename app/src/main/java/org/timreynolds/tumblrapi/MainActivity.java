package org.timreynolds.tumblrapi;

import org.timreynolds.tumblrapi.adapters.PostsAdapter;
import org.timreynolds.tumblrapi.api.ApiManager;
import org.timreynolds.tumblrapi.models.Posts;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ListActivity {
    ListView listView;
    List<Posts> postList;
    PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);
        getTumblrData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.s
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getTumblrData() {

        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                ResponseData responseData = (ResponseData) o;
                // posts
                postList = responseData.getResponse().getPosts();
                postsAdapter = new PostsAdapter(getApplicationContext(),R.layout.item_file, postList);
                // use setListAdapter when extending ListActivity
                setListAdapter(postsAdapter);

            }

            public void failure(RetrofitError erro) {
                Log.e("retrofiterror", "retrofit error -> " + erro);
            }
        };
        // make call to tumblr retrofit service
        ApiManager.getService().getData("photo", 25, "astronomypictureoftheday.tumblr.com", callback);

    }
}
