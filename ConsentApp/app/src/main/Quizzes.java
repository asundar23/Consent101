package com.ashwin.asundar.consentapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//quizzes tab, from home page

public class Quizzes extends Activity{

    ArrayList<String> questions;
    HashMap<Integer,String> map;

    boolean isAnswer;
    int i;
    TextView question_tv;
    Button button;
    ImageButton bottomrightarrow;
    Random rand;

    Animation fadeInAnimation;
    Animation fadeOutAnimation;

    int randomNum;
    ArrayList<Integer> array_num;

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.quiz);

        map = new HashMap<Integer, String>();
        questions = new ArrayList<String>();
        array_num = new ArrayList<Integer>();

        question_tv = (TextView) findViewById(R.id.question);

        populateQuestions();
        mapQuestions();

        isAnswer = false;

        button = (Button) findViewById(R.id.clickforanswer);
        bottomrightarrow = (ImageButton) findViewById(R.id.bottomrightarrow);

        rand = new Random();

        //sets random number to pick a random myth or fact from the array

        randomNum = rand.nextInt((10 - 0) + 1) + 0;
        Log.d("rand is ",randomNum+"");

        question_tv.setText(Html.fromHtml(questions.get(randomNum)));
        array_num.add(randomNum);

        //fade in/out animation being set

        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        setOnClickListener();
        setOnRightClickListener();
    }

    private void setOnRightClickListener() {

        bottomrightarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //goes to the next question which is still random

                question_tv.startAnimation(fadeOutAnimation);
                isAnswer = false;
                rand = new Random();
                i = rand.nextInt((10 - 0) + 1) + 0;;
                while(array_num.contains(i))
                {
                    if(array_num.size()==11)
                    {
                        array_num.clear();
                    }

                    i = rand.nextInt((10 - 0) + 1) + 0;
                }
                array_num.add(i);
                question_tv.startAnimation(fadeInAnimation);
                question_tv.setText(Html.fromHtml(questions.get(i)));
            }
        });

    }

    private void setOnClickListener() {

        question_tv.startAnimation(fadeOutAnimation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //the button will provide the answer to the question being asked.
                //you can press the button again to go back to the question. Kind of like a flashcard

                if(isAnswer == false)
                {

                    question_tv.setText(Html.fromHtml(map.get(i)));
                    question_tv.startAnimation(fadeInAnimation);
                    isAnswer = true;
                }
                else
                {
                    question_tv.startAnimation(fadeInAnimation);
                    question_tv.setText(Html.fromHtml(questions.get(i)));

                }
            }
        });

    }

    private void populateQuestions() {

        questions.add("<i>Myth or Fact: </i>Rape is a crime of uncontrollable sexual passion or urge.");
        questions.add("<i>Myth or Fact: </i>Rape is defined as a sexual crime committed by strangers.");
        questions.add("<i>Myth or Fact: </i>In order for a situation to be considered rape, the victim must fight back physically.");
        questions.add("<i>Myth or Fact: </i>Only women can be victims of sexual violence.");
        questions.add("<i>Myth or Fact: </i>If a person goes to another person’s room and “makes out,” it means that she/he wants to have sex.");
        questions.add("<i>Myth or Fact: </i>A person who has really been sexually assaulted will be hysterical.");
        questions.add("<i>Myth or Fact: </i>It’s not sexual assault if either party was under the influence of alcohol or other drugs.");
        questions.add("<i>Myth or Fact: </i>If a victim isn’t a virgin, it can’t be considered rape.");
        questions.add("<i>Myth or Fact: </i>Victims of sexual assault often ask to be assaulted by the way they are acting or the way that they dress.");
        questions.add("<i>Myth or Fact: </i>The only way a rapist can really force a person to have intercourse is by using a weapon.");
        questions.add("<i>Myth or Fact: </i>If a date pays for dinner or a movie, then sex is expected as “pay back.”");

    }

    private void mapQuestions() {

        map.put(0,"<i>Myth. </i>Rape is a crime motivated by a need to control, humiliate, and harm. Rapists use sex as a weapon to hurt and dominate others.");
        map.put(1,"<i>Myth. </i>Rape is defined as \"sexual intercourse without consent.\" In 90% of incidents of rapes of college" +
                " students, the person who commits the rape is someone who is known to the individuals they victimize." +
                "<br /><br />This is also true for 80% of rapes within the general public. Sexual assaults" +
                "often occur in the home of either the perpetrator or victim.");
        map.put(2,"<i>Myth. </i>Sexual assault is not defined by the gender of the perpetrator or the person who is victimized." +
                "<br />" +
                "<br />" +
                "<b>People of all gender identities and all sexual orientations are targeted by sexual violence.</b> Although" +
                " in a majority of cases of reported rape the victims are women, and in fact women are 10 times more likely to be victims of sexual assault than men, it is estimated that about 1 in 33 men have experienced, attempted, or completed rape in their lifetime." +
                "<br />" +
                "<br />" +
                "1 in 6 males are sexually abused by the age of 18. Transgender individuals are sometimes sexually assaulted as part of a hate crime.");
        map.put(3,"<i>Myth. </i>Rape is sexual intercourse without consent. A person might not fight back" +
                "<b> for any number of reasons, including feeling it is not safe to do so.</b> This does not mean that the victim is giving consent.");
        map.put(4,"<i>Myth. </i>If a person went voluntarily to someone's residence or room and consented to engage in some sexual activity, it does not serve as consent for all sexual activity. Consent is on-going, saying \"yes\" to one form of sexual activity doesn't mean the person is saying \"yes\" to all forms of sexual activity.");
        map.put(5,"<i>Myth. </i>Victims of sexual violence exhibit a <i>spectrum</i> of responses to the assault which inclufes the following: <b>calm, hysteria, withdrawal, anger, apathy, denial, and shock</i>. Being sexually assaulted is a very traumatic experience, and reactions are different. In addition, the length of time needed to process the experience vary with each person." +
                "<br />" +
                "<br />" +
                "There is no \"right way\" to react to having been sexually assaulted. Assumptions about a way a victim \"should act\" may be detrimental to the victim because each victim copes with the trauma of the assault in different ways which also vary over time.");
        map.put(6,"<i>Myth. </i>Many state laws hold that a person who is cognitively impaired due to the influence of drugs or alcohol is not able to consent to sexual activity. Individuals who commit sexual assault might deliberately use alcohol as a means to decrease the ability of a potential victim to evaluate and respond to what is occurring in order to facilitate non-consenual sexual activity." +
                "<br />" +
                "<br />" +
                "The person initiating sexual activity can be held responsible for a sexual assault, even if under the influence of alcohol or other drugs. Being intoxicated is not an excuse for engaging in sexual activity with someone without their consent." +
                "<br />" +
                "<br />" +
                "If the person who is not initiating the sexual contact is under the influence of alcohol or other drugs, the person is considered unable to give consent.");
        map.put(7,"<i>Myth. </i> A victim's sexual history has nothing to do with the crime of rape. A victim could have had consensual sex with the attacker at an earlier time and could still be raped by them. With each sexual encounter, there must be a \"yes\" in order to know that consent is given. Consent occurs when individuals decide together to engage in mutually agreed upon sexual activity.");
        map.put(8,"<i>Myth. </i>Nobody asks to be sexually assaulted no matter how they are dressed or how they present themselves. The way an individual presents themselves is their choice, and it is never justification ofr another individual to decide to sexually assault them." +
                "<br />" +
                "<br />" +
                "Rape and sexual assault are crimes of violence and control that stem from a person's determination to exercise power over another. Forcing someone to engage in non-consensual sexual activity is sexual assault regardless of the way that person dresses or acts. Victims of sexual assault range in age from infants to the elderly. Sexual attractiveness is not the issue.");
        map.put(9,"<i>Myth. </i>A very small percentage of rapists use a weapon, such as a knife or gun, to control their victims. More common than knives or guns is the use of verbal abuse, physical force, psychological pressure, coercion, intimidating and/or making sure the victim is drunk or drugged so that they don't know what is happening to them.");
        map.put(10,"<i>Myth. </i>Accepting a date for dinner or a movie does not obligate a person to do anything to return.");

    }
}