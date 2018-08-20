package com.lonewolf.together;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    SharedPrefs sharedPrefs;
    private Switch darkSwitch;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        sharedPrefs = new SharedPrefs(this);

        if (sharedPrefs.loadNightModeState()) setTheme(R.style.darkTheme);
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        darkSwitch = findViewById(R.id.darkSwitch);

        if (sharedPrefs.loadNightModeState()) darkSwitch.setChecked(true);

        darkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sharedPrefs.setNightModeState(true);
                    restartApp();
                } else {
                    sharedPrefs.setNightModeState(false);
                    restartApp();
                }
            }
        });
    }

    private void restartApp() {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
        finish();
    }
}