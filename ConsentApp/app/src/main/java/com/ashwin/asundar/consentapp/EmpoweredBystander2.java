package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by asundar on 12/10/14.
 */

//empowered bystander class, from definitions

public class EmpoweredBystander2 extends Activity {

    TextView text;
    ImageButton image;
    ImageButton image2;

    public void onCreate(Bundle bundle){

        super.onCreate(bundle);
        setContentView(R.layout.definition2);

        //two image buttons, which are youtube links

        text = (TextView) findViewById(R.id.the_defintion);
        image = (ImageButton) findViewById(R.id.video);
        image2 = (ImageButton) findViewById(R.id.video2);

        image.setImageDrawable(getResources().getDrawable(R.drawable.eb1));
        image2.setImageDrawable(getResources().getDrawable(R.drawable.eb2));

        text.setText("Someone who witnesses potentially harmful behavior and takes action that has the potential to lead to a positive outcome, such as speaking up about abusive behavior and supporting individuals who have been abused.");

        setOnItemClick();
    }

    private void setOnItemClick() {

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" +
                "euXzkLZQPRY"));
                startActivity(intent);

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" +
                        "FnTTIv22U9Q"));
                startActivity(intent);

            }
        });
    }
}
