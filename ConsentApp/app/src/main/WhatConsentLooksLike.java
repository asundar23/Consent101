package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by asundar on 11/25/14.
 */

//what consent looks like class, from home class

public class WhatConsentLooksLike extends Activity{

    Button critera;
    Button definitions;
    Button why;
    Context ctx;

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.what_is_consent);

        ctx = getApplicationContext();

        //three flat buttons, each going to a different class

        critera = (Button) findViewById(R.id.criteriaofconsent);
        critera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,CriteriaOfConsent.class);
                startActivity(intent);
            }
        });

        definitions = (Button) findViewById(R.id.definitions);
        definitions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,Definitions.class);
                startActivity(intent);
            }
        });

        why = (Button) findViewById(R.id.whyisconsentimportant);
        why.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,WhyIsConsentImportant.class);
                startActivity(intent);
            }
        });
    }
}
