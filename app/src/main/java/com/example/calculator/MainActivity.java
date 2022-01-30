package com.example.calculator;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.example.calculator.Calculator;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    final String LOG_TAG = "myLogs";

    private Calculator calculator;
    private TextView tv;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCalculator();
        Log.d(LOG_TAG, "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
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
//        textView = findViewById(R.id.resultView);

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

}