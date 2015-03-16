package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by asundar on 12/10/14.
 */

//definitions class, which comes from the what is consent class

public class Definitions extends Activity{

    Button empowered_bystander;
    Button sexual_assault;
    Button rape;
    Button harassment;
    Button stalking;
    Context ctx;

    public void onCreate(Bundle bundle){



        super.onCreate(bundle);
        setContentView(R.layout.definition_home);

        ctx = getApplicationContext();

        empowered_bystander = (Button) findViewById(R.id.empoweredbystander);
        sexual_assault = (Button) findViewById(R.id.sexualassault);
        rape = (Button) findViewById(R.id.rape);
        stalking = (Button) findViewById(R.id.stalking);
        harassment = (Button) findViewById(R.id.harrassment);

        //each button will go to a new class

        empowered_bystander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ctx,EmpoweredBystander2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_down, R.anim.bottom_up);
            }
        });

        sexual_assault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ctx,SexualAssault2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_down, R.anim.bottom_up);
            }
        });

        rape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ctx,Rape2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_down, R.anim.bottom_up);
            }
        });

        harassment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ctx,Harasment.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_down, R.anim.bottom_up);
            }
        });

        stalking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ctx,Stalking2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.bottom_down, R.anim.bottom_up);
            }
        });

    }
}
