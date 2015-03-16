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

//harassment class, from defintions

public class Harasment extends Activity {

    TextView text;
    ImageButton image;

    public void onCreate(Bundle bundle){

        super.onCreate(bundle);
        setContentView(R.layout.definition);

        //image button is a youtube link

        text = (TextView) findViewById(R.id.the_defintion);
        image = (ImageButton) findViewById(R.id.video);

        image.setImageDrawable(getResources().getDrawable(R.drawable.harassment));

        text.setText("Repeated words or actions directed at a person that annoy, alarm, or cause distress for that person.");

        setOnItemClick();
    }

    private void setOnItemClick() {

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" +
                        "0G-5Rq1ZbNI"));
                startActivity(intent);

            }
        });
    }
}
