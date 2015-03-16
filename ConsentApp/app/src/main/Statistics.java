package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by asundar on 12/9/14.
 */
public class Statistics extends Activity {

    InputStream in;
    BufferedReader reader;
    String line;
    TextView text;
    TextView source;

    Animation fadeInAnimation;
    Animation fadeOutAnimation;

    //statistics class, from home

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.statistics);
        text = (TextView) findViewById(R.id.the_statistic);
        source = (TextView) findViewById(R.id.statistic_source);

        String sourceText = "Statistics taken from <a " +
                "href=\"https://www.rainn.org/statistics\">RAINN</a> and" +
                "<a href=\"http://www.gotconsent.ca/statistics.html\">AMS " +
                "Sexual Assault Support Centre at UBC</a>";

        source.setText(Html.fromHtml(sourceText));

        //defining fade in and fade out animations

        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        readStatsFile();
        clickText();

    }

    private void readStatsFile()
    {

        //buffer reader reading the .txt files i kept in res/raw

        in = getResources().openRawResource(R.raw.stats);
        reader = new BufferedReader(new InputStreamReader(in));

        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        text.setText(line);
    }

    private void clickText() {
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text.startAnimation(fadeOutAnimation);

                if (line != null){
                    try {
                        line = reader.readLine();
                        text.startAnimation(fadeInAnimation);
                        text.setText(line);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    readStatsFile();
                }
            }
        });
    }
}
