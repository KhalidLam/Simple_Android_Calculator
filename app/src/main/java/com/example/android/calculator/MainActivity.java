package com.example.android.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView previousOperandTextView;
    TextView currentOperandTextView;

    Button one, two, three, four, five, six, seven, eight, nine, zero, point;

    Button allClear, delete, equal;

    Button add, divide, multiply, subtract;

    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        previousOperandTextView = findViewById(R.id.previous_operand_text_view);
        currentOperandTextView = findViewById(R.id.current_operand_text_view);

        one = findViewById(R.id.one_button);
        two = findViewById(R.id.two_button);
        three = findViewById(R.id.three_button);
        four = findViewById(R.id.four_button);
        five = findViewById(R.id.five_button);
        six = findViewById(R.id.six_button);
        seven = findViewById(R.id.seven_button);
        eight = findViewById(R.id.eight_button);
        nine = findViewById(R.id.nine_button);
        zero = findViewById(R.id.zero_button);
        point = findViewById(R.id.point_button);

        add = findViewById(R.id.add_button);
        divide = findViewById(R.id.divide_button);
        multiply = findViewById(R.id.multiply_button);
        subtract = findViewById(R.id.subtract_button);

        allClear = findViewById(R.id.all_clear_button);
        delete = findViewById(R.id.delete_button);
        equal = findViewById(R.id.equal_button);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        point.setOnClickListener(this);

        add.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        subtract.setOnClickListener(this);

        allClear.setOnClickListener(this);
        delete.setOnClickListener(this);
        equal.setOnClickListener(this);

        calculator = new Calculator(previousOperandTextView, currentOperandTextView);

    }


    @Override
    public void onClick(View view) {

        Button b = (Button) view;

        switch (view.getId()) {
            case R.id.one_button:
            case R.id.two_button:
            case R.id.three_button:
            case R.id.four_button:
            case R.id.five_button:
            case R.id.six_button:
            case R.id.seven_button:
            case R.id.eight_button:
            case R.id.nine_button:
            case R.id.zero_button:
            case R.id.point_button:
                calculator.appendNumber(b.getText().toString());
                calculator.updateDisplay();
                break;

            case R.id.add_button:
            case R.id.divide_button:
            case R.id.multiply_button:
            case R.id.subtract_button:
                calculator.chooseOperation(b.getText().toString());
                calculator.updateDisplay();
                break;

            case R.id.equal_button:
                calculator.compute();
                calculator.updateDisplay();
                break;

            case R.id.delete_button:
                calculator.delete();
                calculator.updateDisplay();
                break;

            case R.id.all_clear_button:
                calculator.clear();
                calculator.updateDisplay();
                break;

            default:
                break;
        }
    }

}
