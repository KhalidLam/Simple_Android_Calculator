package com.example.android.calculator;

import android.widget.TextView;

public class Calculator {

    private TextView mPreviousOperandTextView;
    private TextView mCurrentOperandTextView;

    private String mCurrentOperand;
    private String mPreviousOperand;

    private String mOperation;

    private boolean isComputed;

    Calculator(TextView previousOperandTV, TextView currentOperandTV) {
        mPreviousOperandTextView = previousOperandTV;
        mCurrentOperandTextView = currentOperandTV;
        clear();
    }

    public void clear() {
        mCurrentOperand = "";
        mPreviousOperand = "";
        mOperation = null;
        isComputed = false;
    }

    public void delete() {
        if (mCurrentOperand.equals("")) return;
        mCurrentOperand = mCurrentOperand.substring(0, mCurrentOperand.length() - 1);
    }

    public void appendNumber(String number) {
        if (number.equals(".") && mCurrentOperand.contains(".")) return;
        if (!mCurrentOperand.equals("") && isComputed) clear();
        mCurrentOperand += number;
    }

    public void updateDisplay() {
        String operand = "";
        mCurrentOperandTextView.setText(mCurrentOperand);
        if (mOperation != null){
            operand = mPreviousOperand + mOperation;
            mPreviousOperandTextView.setText(operand);
        }else {
            mPreviousOperandTextView.setText(operand);
        }
    }

    public void chooseOperation(String operation) {
        if (mCurrentOperand.equals("")) return;
        if (!mPreviousOperand.equals("")) {
            compute();
        }
        mOperation = operation;
        mPreviousOperand = mCurrentOperand;
        mCurrentOperand = "";
    }

    public void compute() {

        isComputed = true;

        if (mPreviousOperand.equals("") || mCurrentOperand.equals("")) return;

        float computation ;
        float prev = Float.parseFloat(mPreviousOperand);
        float current = Float.parseFloat(mCurrentOperand);

        switch (mOperation) {
            case "+":
                computation = prev + current;
                break;
            case "-":
                computation = prev - current;
                break;
            case "*":
                computation = prev * current;
                break;
            case "/":
                computation = prev / current;
                break;
            default:
                computation = 0;
                break;
        }

        mCurrentOperand = Float.toString(computation) ;
        mOperation = null;
        mPreviousOperand = "";

    }


}
