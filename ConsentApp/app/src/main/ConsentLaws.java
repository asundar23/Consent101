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

/**
 * Created by asundar on 12/12/14.
 */

//This class is the Consent Laws page, directed from the home screen.

public class ConsentLaws extends Activity {

    ListView list;
    Context ctx;

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.consent_laws);

        String[] array = {
                "Sex Laws: The Place to Find Answers",
                "Wikipedia: Age of Consent in the United States",
                "NPR: California's Yes Means Yes Law"
        };

        Drawable[] drawables = {
                getResources().getDrawable(R.drawable.sexlaws),
                getResources().getDrawable(R.drawable.wikipedia),
                getResources().getDrawable(R.drawable.npr)
        };

        //creates drawables and a string array, each of which is going to be in a ListView

        ctx = getApplicationContext();
        list = (ListView) findViewById(R.id.list);

        LinksAdapter linksAdapter = new LinksAdapter(array,ctx,drawables);
        list.setAdapter(linksAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String web = "";

                if(position==0) web = "http://www.sexlaws.org/";
                if(position==1) web = "http://simple.wikipedia.org/wiki/Age_of_sexual_consent_in_the_United_States";
                if (position==2) web = "http://www.npr.org/blogs/thetwo-way/2014/09/29/352482932/california-enacts-yes-means-yes-law-defining-sexual-consent";

                //setting the websites based on which position the user clicks.

                Uri uri = Uri.parse(web);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
