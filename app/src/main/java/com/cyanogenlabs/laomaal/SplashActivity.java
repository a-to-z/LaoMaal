package com.cyanogenlabs.laomaal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ammar on 7/13/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Start home activity

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        },2000);
        //startActivity(new Intent(SplashActivity.this, MainActivity.class));
        // close splash activity
        //finish();
    }

}
