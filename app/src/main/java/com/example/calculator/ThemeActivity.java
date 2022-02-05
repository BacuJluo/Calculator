package com.example.calculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class ThemeActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.myTheme);
        setContentView(R.layout.activity_settings);
    }


}
