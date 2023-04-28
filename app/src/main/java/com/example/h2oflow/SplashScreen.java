package com.example.h2oflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),
                            android.R.anim.fade_in, android.R.anim.fade_out).toBundle();

                    Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    finish();
                }
                catch (Exception err){
                    err.printStackTrace();
                }
            }
        };    thread.start();
    }
}