package com.example.calculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView tv;
    private Button btn;
    public static int REQUEST_CODE = 999;
    public static String KEY_INTENT_THEME_FROM_SECOND_TO_MAIN = "key1";

    private static final String PREF_NAME1 = "key_preference";
    private static final String PREF_THEME_KEY1 = "key_preference_theme";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme());
        setContentView(R.layout.activity_main);
        initCalculator();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("calculator",calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = savedInstanceState.getParcelable("calculator");
        tv.setText(calculator.getText());
    }

    private void initCalculator(){
        calculator = new Calculator();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onNumberPressed(v.getId());
                tv.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onActionPressed(v.getId());
                tv.setText(calculator.getText());
            }
        };

        tv = findViewById(R.id.materialTextView);
        btn = findViewById(R.id.materialButtonSettings);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });


        int[] numberIds = new int[]{
                R.id.materialButtonZero,
                R.id.materialButtonOne,
                R.id.materialButtonTwo,
                R.id.materialButtonThree,
                R.id.materialButtonFour,
                R.id.materialButtonFive,
                R.id.materialButtonSix,
                R.id.materialButtonSeven,
                R.id.materialButtonEight,
                R.id.materialButtonNine
        };

        int[] actionsIds = new int[]{
                R.id.materialButtonPlus,
                R.id.materialButtonMinus,
                R.id.materialButtonDivision,
                R.id.materialButtonMultiplication,
                R.id.materialButtonResult,
                R.id.materialButtonReset
        };

        for(int i = 0; i < numberIds.length; i++){
            findViewById(numberIds[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i <actionsIds.length; i++){
            findViewById(actionsIds[i]).setOnClickListener(actionButtonClickListener);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE&&resultCode==RESULT_OK){
            if(data.getExtras()!=null){
                data.getIntExtra(KEY_INTENT_THEME_FROM_SECOND_TO_MAIN, R.style.Theme_Calculator);
            }
            recreate();
        }
    }

    private int getAppTheme(){
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME1, MODE_PRIVATE);
        return sharedPref.getInt(PREF_THEME_KEY1, R.style.Theme_Calculator);
    }



}