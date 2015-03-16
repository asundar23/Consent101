package com.ashwin.asundar.consentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by asundar on 12/8/14.
 */

//base adapter for hotlines list view. it takes the textview and imageview and puts them
    //as one cell in the listview

public class HotlinesBaseAdapter extends BaseAdapter {

    String[] array;
    Context ctx;
    TextView tv;

    public HotlinesBaseAdapter(Context c, String[] a)
    {
        array = a;
        ctx = c;
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
            li.inflate(R.layout.hotlines_textview, rl, true);
        }

        tv = (TextView) rl.findViewById(R.id.tv);

        tv.setText(array[position]);

        return rl;
    }
}
