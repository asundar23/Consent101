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
public class Rape2 extends Activity {

    TextView text;
    ImageButton image;

    //rape class, from definitions

    public void onCreate(Bundle bundle){

        super.onCreate(bundle);
        setContentView(R.layout.definition);

        text = (TextView) findViewById(R.id.the_defintion);
        image = (ImageButton) findViewById(R.id.video);

        image.setImageDrawable(getResources().getDrawable(R.drawable.rape));

        text.setText("Sexual intercourse without consent.");


        setOnItemClick();
    }

    private void setOnItemClick() {

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" +
                        "8HiO4uupBPw"));
                startActivity(intent);

            }
        });
    }

}
