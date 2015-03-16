package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.HashMap;

/**
 * Created by asundar on 12/9/14.
 */

//links tab, from home page

public class Links extends Activity {

    ListView list;
    String array[];
    Drawable[] drawables;
    LinksAdapter linksAdapter;
    Context ctx;
    HashMap<Integer,String> map;

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.list_view);
        ctx = getApplicationContext();

        drawables = new Drawable[19];

        list = (ListView) findViewById(R.id.linkslist);

        array = getResources().getStringArray(R.array.video_names);

        drawables[0] = getResources().getDrawable(R.drawable.vid_1);
        drawables[1] = getResources().getDrawable(R.drawable.vid_2);
        drawables[2] = getResources().getDrawable(R.drawable.vid_3);
        drawables[3] = getResources().getDrawable(R.drawable.vid_4);
        drawables[4] = getResources().getDrawable(R.drawable.vid_5);
        drawables[5] = getResources().getDrawable(R.drawable.vid_6);
        drawables[6] = getResources().getDrawable(R.drawable.vid_7);
        drawables[7] = getResources().getDrawable(R.drawable.vid_8);
        drawables[8] = getResources().getDrawable(R.drawable.vid_9);
        drawables[9] = getResources().getDrawable(R.drawable.vid_10);

        //setting the imageview

        map = new HashMap<Integer, String>();

        map.put(0,"GubGFNPb86o");
        map.put(1,"vTxlB_RFrB0");
        map.put(2,"TD2EooMhqRI");
        map.put(3,"JEAgXMtcJ0w");
        map.put(4,"Q5H6QvNmfjY");
        map.put(5,"TBFCeGDVAdQ");
        map.put(6,"wFIH7yGoRW8");
        map.put(7,"zGGIf_4wqSQ");
        map.put(8,"_XiMtPFJigc");
        map.put(9,"dRuPFmo15Tk");

        //mapping a number to a string, which will be used for a youtube link.



        linksAdapter = new LinksAdapter(array,ctx,drawables);
        list.setAdapter(linksAdapter);

        setOnItemClick();

    }

    private void setOnItemClick() {

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://"
                        + map.get(position)));
                startActivity(intent);
            }
        });
    }
}
