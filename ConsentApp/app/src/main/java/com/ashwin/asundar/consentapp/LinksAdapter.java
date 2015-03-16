package com.ashwin.asundar.consentapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by asundar on 12/9/14.
 */

//adapter for links

public class LinksAdapter extends BaseAdapter {

    String[] array;
    Context ctx;
    Drawable[] drawables;
    TextView tv;
    ImageView image;

    public LinksAdapter(String[] a, Context c, Drawable[] d)
    {
        array = a;
        ctx = c;
        drawables = d;
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public Object getItem(int position) {
        return array[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li;
        RelativeLayout rl;

        rl = (RelativeLayout) convertView;

        if (rl == null) {
            li  =  (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rl  =  new RelativeLayout(ctx);
            li.inflate(R.layout.link_text_view, rl, true);
        }

        tv = (TextView) rl.findViewById(R.id.title_of_video);
        image = (ImageView) rl.findViewById(R.id.thumbnail);

        tv.setText(array[position]);
        tv.setTextColor(Color.BLACK);
        image.setImageDrawable(drawables[position]);

        return rl;
    }
}
