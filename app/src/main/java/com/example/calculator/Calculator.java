package com.example.calculator;

import androidx.annotation.IntRange;

public class Calculator {

    private int firstArg;
    private int secondArg;
    private int countNumbers = 9;

    private StringBuilder inputStr = new StringBuilder();

    private int actionSelected;

    private State state;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public Calculator(){
        state = State.firstArgInput;
    }

    public void onNumberPressed (int buttonId){

        if (state == State.resultShow){
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if(inputStr.length() < countNumbers){
            switch (buttonId){
                case R.id.materialButtonZero:{
                    if(inputStr.length() != 0){
                        inputStr.append("0");
                    }break;
                }
                case R.id.materialButtonOne:{
                    inputStr.append("1");
                    break;
                }
                case R.id.materialButtonTwo:{
                    inputStr.append("2");
                    break;
                }
                case R.id.materialButtonThree:{
                    inputStr.append("3");
                    break;
                }
                case R.id.materialButtonFour:{
                    inputStr.append("4");
                    break;
                }
                case R.id.materialButtonFive:{
                    inputStr.append("5");
                    break;
                }
                case R.id.materialButtonSix:{
                    inputStr.append("6");
                    break;
                }
                case R.id.materialButtonSeven:{
                    inputStr.append("7");
                    break;
                }
                case R.id.materialButtonEight:{
                    inputStr.append("8");
                    break;
                }
                case R.id.materialButtonNine:{
                    inputStr.append("9");
                    break;
                }
            }
        }

    }

    public void onActionPressed (int actionId){
        if (actionId == R.id.materialButtonResult && state == State.secondArgInput){
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected){
                case R.id.materialButtonPlus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.materialButtonMinus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.materialButtonMultiplication:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.materialButtonDivision:
                    inputStr.append(firstArg / secondArg);
                    break;
            }

        } else if (actionId == R.id.materialButtonReset && inputStr.length() > 0) {
            state = State.firstArgInput;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.materialButtonReset:
                    actionSelected = R.id.materialButtonReset;
                    break;
            }
        } else if(inputStr.length() > 0 && state == State.firstArgInput){
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            switch (actionId){
                case R.id.materialButtonPlus:
                    actionSelected = R.id.materialButtonPlus;
                    break;
                case R.id.materialButtonMinus:
                    actionSelected = R.id.materialButtonMinus;
                    break;
                case R.id.materialButtonMultiplication:
                    actionSelected = R.id.materialButtonMultiplication;
                    break;
                case R.id.materialButtonDivision:
                    actionSelected = R.id.materialButtonDivision;
                    break;
                case R.id.materialButtonResult:
                    actionSelected = R.id.materialButtonResult;
                    break;
            }
        }
    }

    public String getText (){
        return inputStr.toString();
    }

}
