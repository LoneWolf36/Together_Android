package com.lonewolf.together;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton setting = findViewById(R.id.settings);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationBar bottomNavigationBar = findViewById(R.id.navigation);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_poll_white_24dp, "View and create polls").setActiveColor("#e64a19"))
                .addItem(new BottomNavigationItem(R.drawable.ic_add_white_24dp, "Create poll").setActiveColor("#283593"))
                .addItem(new BottomNavigationItem(R.drawable.ic_video_call_white_24dp, "Video call").setActiveColor("#6a1b9a"))
                .addItem(new BottomNavigationItem(R.drawable.ic_settings_white_24dp, "Voice call").setActiveColor("#546e7a"))
                .initialise();

        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PollsFragment()).commit();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {

            @Override
            public void onTabSelected(int position) {
                Fragment selectedFragment = null;

                switch (position) {
                    case 0:
                        selectedFragment = new PollsFragment();
                        break;
                    case 1:
                        selectedFragment = new PollsFragment();
                        break;
                    case 2:
                        selectedFragment = new VideoCallFragment();
                        break;
                    case 3:
                        selectedFragment = new VideoCallFragment();
                        break;
                }
                if (selectedFragment != null)
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

}
