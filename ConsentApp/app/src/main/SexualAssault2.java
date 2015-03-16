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
public class SexualAssault2 extends Activity {

    TextView text;
    ImageButton image;
    ImageButton image2;

    //sexual assault class, from definitions

    public void onCreate(Bundle bundle){

        super.onCreate(bundle);
        setContentView(R.layout.definition2);

        text = (TextView) findViewById(R.id.the_defintion);
        image = (ImageButton) findViewById(R.id.video);
        image2 = (ImageButton) findViewById(R.id.video2);

        image.setImageDrawable(getResources().getDrawable(R.drawable.sa_1));
        image2.setImageDrawable(getResources().getDrawable(R.drawable.sa2));

        text.setText("Any sexual contact without consent.");


        setOnItemClick();
    }

    private void setOnItemClick() {

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" +
                        "d0pbHOliQu0"));
                startActivity(intent);

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" +
                        "qsGOk2ZaDI4"));
                startActivity(intent);

            }
        });
    }

}
