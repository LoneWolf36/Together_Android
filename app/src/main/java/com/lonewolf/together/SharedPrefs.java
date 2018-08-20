package com.lonewolf.together;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {

    SharedPreferences myPrefs;

    public SharedPrefs(Context context) {
        myPrefs = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putBoolean("NightMode", state);
        editor.commit();
    }

    public Boolean loadNightModeState() {
        Boolean state = myPrefs.getBoolean("NightMode", false);
        return state;
    }
}
