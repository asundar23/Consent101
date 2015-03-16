package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

//home screen

public class Home extends Activity {

    ImageButton wic;
    ImageButton hotlines;
    ImageButton myths_and_facts;
    ImageButton statistics;
    ImageButton consentlaws;
    Context ctx;
    ImageButton links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        ctx = getBaseContext();

        wic = (ImageButton) findViewById(R.id.what_is_consent);
        hotlines = (ImageButton) findViewById(R.id.hotlines);
        links = (ImageButton) findViewById(R.id.links);
        statistics = (ImageButton) findViewById(R.id.statistics);
        myths_and_facts = (ImageButton) findViewById(R.id.myths_and_facts);
        consentlaws = (ImageButton) findViewById(R.id.consent_laws);

        //The way it is set up, each part of the question mark on the home page
        //is a separate button. That is why I set them to different colors.

        wic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,WhatConsentLooksLike.class);
                startActivity(intent);
            }
        });

        hotlines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,Hotlines.class);
                startActivity(intent);
            }
        });

        links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,Links.class);
                startActivity(intent);
            }
        });

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,Statistics.class);
                startActivity(intent);
            }
        });

        myths_and_facts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, Quizzes.class);
                startActivity(intent);
            }
        });

        consentlaws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, ConsentLaws.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
