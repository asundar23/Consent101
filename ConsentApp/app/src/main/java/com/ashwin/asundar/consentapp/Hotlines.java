package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

//hotlines class, from home screen. this class will provide resources to the user.

public class Hotlines extends Activity
{

    String web;
    String callNumber;
    ListView list;
    String something;
    String[] array;
    HotlinesBaseAdapter listAdapter;
    Context ctx;

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.hotlines);

        ctx = getApplicationContext();
        list = (ListView) findViewById(R.id.list);

        array = getResources().getStringArray(R.array.hotline_list);
        listAdapter = new HotlinesBaseAdapter(ctx,array);
        list.setAdapter(listAdapter);

        //clicking goes to a website

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0)
                {
                    web = "http://saracville.org/";
                }

                if(position == 1)
                {
                    web = "https://www.rainn.org/";
                }

                if(position == 2)
                {
                    web = "http://www.aftersilence.org/";
                }

                if(position == 3)
                {
                    web = "http://www.reddit.com/r/rape";
                }

                Uri uri = Uri.parse(web);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        longHold();

    }

    public void longHold()
    {

        //holding the list will bring up a screen where you can either call
        //the hotline or go to their website.

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        Hotlines.this);


                LayoutInflater inflater = (LayoutInflater)   getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View theView = inflater.inflate(R.layout.popup, null);

                TextView name = (TextView) theView.findViewById(R.id.name);
                ImageButton number = (ImageButton) theView.findViewById(R.id.number);
                ImageButton website = (ImageButton) theView.findViewById(R.id.website);
                ImageView logo = (ImageView) theView.findViewById(R.id.logo);

                if(position == 0)
                {
                    logo.setImageDrawable(getImage("sara"));
                    something = "Sexual Assault Resource Agency";
                    name.setText(something);
                    website.setEnabled(true);
                    number.setEnabled(true);
                    web = "http://saracville.org/";
                    callNumber = "tel:4349777273";
                }

                if(position == 1)
                {
                    logo.setImageDrawable(getImage("rainn"));
                    something = "Rape, Abuse, and Incest National Network";
                    name.setText("National Sexual Assault Hotline");
                    website.setEnabled(true);
                    number.setEnabled(true);
                    web = "https://www.rainn.org/";
                    callNumber = "tel:18006564673";
                }

                if(position == 2)
                {
                    logo.setImageDrawable(getImage("aftersilence"));
                    something = "After Silence";
                    name.setText(something);
                    website.setEnabled(true);
                    web = "http://www.aftersilence.org/";
                    number.setEnabled(false);
                }

                if(position == 3)
                {
                    logo.setImageDrawable(getImage("reddit"));
                    something = "Reddit - Subreddit Rape";
                    name.setText(something);
                    website.setEnabled(true);
                    web = "http://www.reddit.com/r/rape";
                    number.setEnabled(false);
                }

                number.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse(callNumber));
                        startActivity(callIntent);
                    }
                });

                website.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse(web);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });


                alertDialogBuilder.setTitle(something);

                alertDialogBuilder
                        .setView(theView)
                        .setCancelable(true)
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();



                return true;
            }
        });

    }

    public Drawable getImage(String n) {

        return getResources().getDrawable(
                getResources().getIdentifier(n, "drawable",
                        ctx.getPackageName()));

    }
}