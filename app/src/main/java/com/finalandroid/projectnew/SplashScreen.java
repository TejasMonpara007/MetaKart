package com.finalandroid.projectnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.finalandroid.projectnew.Activities.HomePageActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        startAnimations();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {

                    startActivity(new Intent(SplashScreen.this, HomePageActivity.class));
                } else {

                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                }

            }
        }, SPLASH_TIME_OUT);
    }

    private void startAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_aplha);
        anim.reset();
        ConstraintLayout constraintLayout= findViewById(R.id.myconstrinat);
        constraintLayout.clearAnimation();
        constraintLayout.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.splash_animations);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.logo_img);
        iv.clearAnimation();
        iv.startAnimation(anim);

    }
}