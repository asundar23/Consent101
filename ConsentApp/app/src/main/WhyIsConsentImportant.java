package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by asundar on 12/12/14.
 */

//why is consent important class, from what is consent

public class WhyIsConsentImportant extends Activity {

    TextView text;
    String n;
    Animation fadeInAnimation;
    Animation fadeOutAnimation;
    int i;
    ArrayList<String> paragraphs;
    ImageButton next;
    ImageButton previous;

    public void onCreate(Bundle bundle){

        super.onCreate(bundle);
        setContentView(R.layout.whyisconsentimportant);

        text = (TextView) findViewById(R.id.text);

        //defining animations

        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        next = (ImageButton) findViewById(R.id.next);
        previous = (ImageButton) findViewById(R.id.previous);

        paragraphs = new ArrayList<String>();

        i = 0;

        //creating the paragraphs, which the textview will be showing one at a time.

        setParagraphs();
        text.setText(Html.fromHtml(paragraphs.get(i)));
        setOnClickListener();
    }

    private void setOnClickListener() {

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //the button click gets to the new paragraph.
                //wraps around

                text.startAnimation(fadeOutAnimation);
                ++i;
                if(i > paragraphs.size()-1) i = 0;
                text.startAnimation(fadeInAnimation);
                text.setText(Html.fromHtml(paragraphs.get(i)));

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //the button click gets to the previous paragraph.
                //wraps around

                text.startAnimation(fadeOutAnimation);
                --i;
                if(i < 0) i = paragraphs.size()-1;
                text.startAnimation(fadeInAnimation);
                text.setText(Html.fromHtml(paragraphs.get(i)));
            }
        });

    }

    public void setParagraphs()
    {
        paragraphs.add("Asking for consent is very important for many reasons." +
                "<br />" +
                "<br />" +
                "The first is that it takes out all the <i>ambiguity</i> of sex. What does this mean?" +
                "<br />" +
                "<br />" +
                "Many times when there are two or more partners involved, there is a miscommunication as to what" +
                " the other person wanted. Sometimes, a \"no\" can be perceived different, or a \"yes\" isn't " +
                "exactly definitive. Asking for consent means that there are <b>no questions about " +
                "what all partners involved were looking for</b>. It takes the guess work out of sex.");

        paragraphs.add("Speaking of ambiguity, getting consent from your partner will assure " +
                "you that sex is desired. Who doesn't want that? Sex is much better when both people " +
                "are into it. It's a far better feeling when the other person/people want to have sex " +
                "just as much as you do.");

        paragraphs.add("Often we hear the word \"safe space.\" Consent definitely applies in this context." +
                "<br />" +
                "<br />" +
                "It creates an environment of <i>trust, communication, and safety</i>. This lets your partner(s) " +
                "become much more <b>comfortable and secure</b> with not only sexual activity, but your presence overall");

        paragraphs.add("It shows that you respect your partner(s) wish(es). Respect is a two way street, " +
                "and getting consent is certainly a factor in that.");

        paragraphs.add("Consent offers the opportunity to express personal values. In addition, it allows you to " +
                "<b>acknowledge, respect, and accept the values of your partner(s)</b>." +
                "<br />" +
                "<br />" +
                "Different people have different desires when it comes to sexual activity. This can be " +
                "cultural, religious, or simply personal. No matter your partner(s)'s story is, if you " +
                "are aware that their expectations could be different, it goes a long way to establish " +
                "<i>healthy communication</i>.");

        paragraphs.add("STI (Sexually Transmitted Infections) are often brought about because of " +
                "this aforementioned lack of communication. You also could be preventing an unwanted " +
                "pregnancy due to not being aware of the other person(s)'s body and frame of mind.");
    }
}
