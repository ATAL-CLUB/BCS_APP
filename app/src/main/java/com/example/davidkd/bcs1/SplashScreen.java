package com.example.davidkd.bcs1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SplashScreen extends AppCompatActivity {

    Thread splashThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        StartAnimations();
    }

        /*Thread myThread = new Thread(){
            @Override
            public void run() {
                try{
                    //3000 milliseconds -> 3 seconds
                    sleep(1000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    //destroy
                    finish();

                } catch (InterruptedException e){
                    e.printStackTrace();

                }

            }
        };
        myThread.start(); //call run() method*/

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.alpha2);
        anim.reset();
        final LinearLayout l = (LinearLayout) findViewById(R.id.activity_splash_screen);

        //l.startAnimation(anim);


        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.home_logo);
        iv.clearAnimation();
        iv.startAnimation(anim);
        l.clearAnimation();
        l.startAnimation(anim2);


        //final Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.alpha2);

        splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 6000) {
                        sleep(110);
                        waited += 100;
                    }

                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashScreen.this.finish();

                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashScreen.this.finish();
                    
                }

            }
        };

        splashThread.start();

    }



}
