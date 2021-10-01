package com.example.proyecto2.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.proyecto2.R;

public class Splash extends AppCompatActivity {
    ImageView splashImage;
    LottieAnimationView lottieAnimationView1,lottieAnimationView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        lottieAnimationView1 = findViewById(R.id.lottie1);
        lottieAnimationView2 = findViewById(R.id.lottie2);

        //lottieAnimationView1.animate().translationY(1600).setDuration(4000).setStartDelay(1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }

}