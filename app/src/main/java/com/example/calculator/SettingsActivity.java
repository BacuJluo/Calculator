package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String PREF_NAME = "key_preference";
    private static final String PREF_THEME_KEY = "key_preference_theme";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme());
        setContentView(R.layout.activity_settings);

        ((RadioButton) findViewById(R.id.GreenTheme)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.DarkTheme)).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.GreenTheme: {
                setAppTheme(R.style.myTheme);
                break;
            }
            case R.id.DarkTheme: {
                setAppTheme(R.style.myDarkTheme);
                break;
            }
        }
        //передача из этой активити в основную
        Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
        intent.putExtra(MainActivity.KEY_INTENT_THEME_FROM_SECOND_TO_MAIN, getAppTheme());
        SettingsActivity.this.setResult(RESULT_OK,intent);
        finish();
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(PREF_THEME_KEY, codeStyle);
        editor.apply();
    }

    private int getAppTheme() {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPref.getInt(PREF_THEME_KEY, R.style.Theme_Calculator);
    }
}
