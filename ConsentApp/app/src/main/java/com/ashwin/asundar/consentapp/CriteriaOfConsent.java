package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

/**
 * Created by asundar on 12/6/14.
 */

//This class is the Criteria of Consent, which is from the What Is Consent tab from the Home page.

public class CriteriaOfConsent extends Activity {

    VideoView video;

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.criteria_of_consent);

        //in the res/raw folder, I have a video uploaded. This is that video
        //to be played in the VideoView.

        video = (VideoView) findViewById(R.id.videoView);
        String url = "android.resource://" + getPackageName() +
                "/" + R.raw.video;
        video.setVideoURI(Uri.parse(url));
        video.start();


    }
}
