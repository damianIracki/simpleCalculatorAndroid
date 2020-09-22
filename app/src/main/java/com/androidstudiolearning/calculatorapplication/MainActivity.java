package com.androidstudiolearning.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final char ADDITION = '+';
    private final char SUBTRACT = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private char ACTION;

    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonEqual;
    private Button buttonClear;

    private TextView tvResult;
    private TextView tvOperation;

    private double variable1 = Double.NaN;
    private double variable2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        tvResult.setText("");
        tvOperation.setText("");

        moveTextFromButtonToTextViewOperation(buttonZero);
        moveTextFromButtonToTextViewOperation(buttonOne);
        moveTextFromButtonToTextViewOperation(buttonTwo);
        moveTextFromButtonToTextViewOperation(buttonThree);
        moveTextFromButtonToTextViewOperation(buttonFour);
        moveTextFromButtonToTextViewOperation(buttonFive);
        moveTextFromButtonToTextViewOperation(buttonSix);
        moveTextFromButtonToTextViewOperation(buttonSeven);
        moveTextFromButtonToTextViewOperation(buttonEight);
        moveTextFromButtonToTextViewOperation(buttonNine);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText("");
                tvResult.setText("");
                variable1 = Double.NaN;
                variable2 = Double.NaN;
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                tvResult.setText(String.valueOf(variable1) + "+");
                tvOperation.setText("");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACT;
                tvResult.setText(String.valueOf(variable1) + "-");
                tvOperation.setText("");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                tvResult.setText(String.valueOf(variable1) + "*");
                tvOperation.setText("");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                tvResult.setText(String.valueOf(variable1) + "/");
                tvOperation.setText("");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Double.isNaN(variable2)){
                    tvResult.setText(String.valueOf(variable1));
                }
                compute();
                ACTION = EQU;
                tvResult.setText(String.valueOf(variable1));
                tvOperation.setText("");
                variable1 = Double.parseDouble(tvResult.getText().toString());
            }
        });

    }

    private void setupUIViews(){
        buttonZero = findViewById(R.id.button0);
        buttonOne = findViewById(R.id.button1);
        buttonTwo = findViewById(R.id.button2);
        buttonThree = findViewById(R.id.button3);
        buttonFour = findViewById(R.id.button4);
        buttonFive = findViewById(R.id.button5);
        buttonSix = findViewById(R.id.button6);
        buttonSeven = findViewById(R.id.button7);
        buttonEight = findViewById(R.id.button8);
        buttonNine = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMulti);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonClear = findViewById(R.id.buttonClear);
        buttonEqual = findViewById(R.id.buttonEqual);

        tvResult = findViewById(R.id.tvResult);
        tvOperation = findViewById(R.id.tvOperation);
    }

    private void compute(){
        if(!Double.isNaN(variable1)){
            variable2 = Double.parseDouble(tvOperation.getText().toString());

            switch (ACTION){
                case ADDITION:
                    variable1 = variable1 + variable2;
                    break;
                case SUBTRACT:
                    variable1 = variable1 - variable2;
                    break;
                case MULTIPLICATION:
                    variable1 = variable1 * variable2;
                    break;
                case DIVISION:
                    variable1 = variable1 / variable2;
                case EQU:
                    break;
            }
        } else {
            variable1 = Double.parseDouble(tvOperation.getText().toString());
        }
    }

    private void moveTextFromButtonToTextViewOperation(final Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText(tvOperation.getText() + "" + button.getText());
            }
        });
    }
}

