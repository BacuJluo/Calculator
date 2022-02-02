package com.example.calculator;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private Calculator calculator;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCalculator();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("calculator", calculator);
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