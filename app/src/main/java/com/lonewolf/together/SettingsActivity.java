package com.lonewolf.together;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    SharedPrefs sharedPrefs;
    private Switch darkSwitch;
    Button signOutButton;

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

        signOutButton = findViewById(R.id.sign_out_button);

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void restartApp() {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
        finish();
    }
}