package com.sid.birthdaycard;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable cardAnimation;
    Animation rotation;
    ImageButton play,stop;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView card = (ImageView)findViewById(R.id.ImageView);
        play=(ImageButton)findViewById(R.id.play);
        stop=(ImageButton)findViewById(R.id.stop);
        card.setBackgroundResource(R.drawable.mycard);
        cardAnimation=(AnimationDrawable) card.getBackground();

    }
    public void play(View view){
        rotation = AnimationUtils.loadAnimation(this,R.anim.rotation);
        play.startAnimation(rotation);
        cardAnimation.start();
        player=MediaPlayer.create(this,R.raw.happybirthday);
        player.start();
        player.setLooping(true);

    }
    public void stop(View view){
        rotation = AnimationUtils.loadAnimation(this,R.anim.rotation);
        stop.startAnimation(rotation);
        cardAnimation.stop();
        player.setLooping(false);
        player.stop();
    }
}
