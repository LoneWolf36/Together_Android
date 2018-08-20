package com.lonewolf.together;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPrefs = new SharedPrefs(this);

        if (sharedPrefs.loadNightModeState()) setTheme(R.style.darkTheme);
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }
}
