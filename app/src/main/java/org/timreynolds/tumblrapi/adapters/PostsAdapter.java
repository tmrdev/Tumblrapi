package org.timreynolds.tumblrapi.adapters;

import com.squareup.picasso.Picasso;

import org.timreynolds.tumblrapi.R;
import org.timreynolds.tumblrapi.models.Posts;
import org.timreynolds.tumblrapi.models.Photos;
import org.timreynolds.tumblrapi.models.Altsizes;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sonic-ssd on 8/29/15.
 */
public class PostsAdapter extends ArrayAdapter<Posts> {


    //String url="http://services.hanselandpetal.com/photos/";

    private Context context;
    private List<Posts> mPostList;

    public PostsAdapter(Context context, int resource, List<Posts> objects) {
        super(context, resource, objects);
        this.context = context;
        this.mPostList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_file, parent, false);
        Posts posts = mPostList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.name);
        tv.setText(mPostList.get(position).getCaption());

        String thumbPicURL = getThumbPic(mPostList.get(position).getPhotos());
        Log.i("thumbpic", "thumbpic -> " + thumbPicURL);

        /*
        List<Photos> photos = posts.getPhotos();
        for(Photos photo : photos ) {
            //Log.i("photos", "dump photo -> " + photo.getAltsizes().toString());
            List<Altsizes> altsizes = photo.getAltsizes();

            for(Altsizes altsize : altsizes){
                Log.i("altsizes", " altsizes -> url : " + altsize.getUrl());
            }
            //Log.i("altsizes", " altsizes -> " + altsizes.)
        }
        */

        ImageView img = (ImageView) view.findViewById(R.id.img);
        //Log.i("imagelink", " image url -> " + posts.getImage_permalink());
        //Picasso.with(getContext()).load(posts.getImage_permalink()).resize(100, 100).into(img);
        String imageURL = "http://40.media.tumblr.com/tumblr_mad1e2exFt1qb3iw0o1_1280.jpg";
        Picasso.with(getContext()).load(thumbPicURL).resize(250, 150).into(img);
        // http://40.media.tumblr.com/tumblr_mad1e2exFt1qb3iw0o1_1280.jpg
        return view;
    }

    private String getThumbPic(List<Photos> photosList){
        String thumbPicURL = null;
        for(Photos photo : photosList){
            List<Altsizes> altsizes = photo.getAltsizes();

            for(Altsizes altsize : altsizes){
                //Log.i("altsizes", " altsizes -> url : " + altsize.getUrl());
                if(altsize.getWidth() == 250 ){
                    thumbPicURL = altsize.getUrl();
                    return thumbPicURL;
                }
            }
        }

        return thumbPicURL;
    }
}
