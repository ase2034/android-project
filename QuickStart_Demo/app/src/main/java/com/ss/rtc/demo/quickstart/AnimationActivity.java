package com.ss.rtc.demo.quickstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.airbnb.lottie.LottieAnimationView;

public class AnimationActivity extends AppCompatActivity {
private TextView textView;
private LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        textView=findViewById(R.id.kaiping);
        lottieAnimationView=findViewById(R.id.mylottie);
        textView.animate().translationY(-1600).setDuration(2700).setStartDelay(0);
        lottieAnimationView.animate().translationX(2000).setDuration(2000).setStartDelay(2900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                      Intent i=new Intent(getApplicationContext(), viewpagerActivity.class);
                      startActivity(i);
            }
        },5000);
        Intent intent = new Intent(getApplicationContext(), viewpagerActivity.class);
        startActivity(intent);




    }
}