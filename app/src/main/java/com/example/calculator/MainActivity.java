package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR{
        PLUS, MINUS, INMULTIT, IMPARTIT, EQUAL
    }

    private TextView display;

    private String currentNumber;
    private String numberLeft;
    private String numberRight;
    private OPERATOR currentOpperator;
    private int calculationsResult;
    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "" ;
        calculationsResult = 0;
        calculationsString = "";

        display = (TextView) findViewById(R.id.display);

        findViewById(R.id.equal).setOnClickListener(MainActivity.this);
        findViewById(R.id.minus).setOnClickListener(MainActivity.this);
        findViewById(R.id.plus).setOnClickListener(MainActivity.this);
        findViewById(R.id.inmultit).setOnClickListener(MainActivity.this);
        findViewById(R.id.impartit).setOnClickListener(MainActivity.this);
        findViewById(R.id.clear).setOnClickListener(MainActivity.this);
        findViewById(R.id.zero).setOnClickListener(MainActivity.this);
        findViewById(R.id.one).setOnClickListener(MainActivity.this);
        findViewById(R.id.two).setOnClickListener(MainActivity.this);
        findViewById(R.id.three).setOnClickListener(MainActivity.this);
        findViewById(R.id.four).setOnClickListener(MainActivity.this);
        findViewById(R.id.five).setOnClickListener(MainActivity.this);
        findViewById(R.id.six).setOnClickListener(MainActivity.this);
        findViewById(R.id.seven).setOnClickListener(MainActivity.this);
        findViewById(R.id.eight).setOnClickListener(MainActivity.this);
        findViewById(R.id.nine).setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.equal:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.seven:
                numberIsTapped(7);
                break;
            case R.id.eight:
                numberIsTapped(8);
                break;
            case R.id.nine:
                numberIsTapped(9);
                break;
            case R.id.four:
                numberIsTapped(4);
                break;
            case R.id.five:
                numberIsTapped(5);
                break;
            case R.id.six:
                numberIsTapped(6);
                break;
            case R.id.one:
                numberIsTapped(1);
                break;
            case R.id.two:
                numberIsTapped(2);
                break;
            case R.id.three:
                numberIsTapped(3);
                break;
            case R.id.zero:
                numberIsTapped(0);
                break;
            case R.id.plus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationsString = calculationsString + " + ";
                break;
            case R.id.minus:
                operatorIsTapped(OPERATOR.MINUS);
                calculationsString = calculationsString + " - ";
                break;
            case R.id.impartit:
                operatorIsTapped(OPERATOR.IMPARTIT);
                calculationsString = calculationsString + " / ";
                break;
            case R.id.inmultit:
                operatorIsTapped(OPERATOR.INMULTIT);
                calculationsString = calculationsString + " * ";
                break;
            case R.id.clear:
                clearDisplay();
                break;

        }

        display.setText(calculationsString);

    }

    private void clearDisplay() {
        numberLeft = "";
        numberRight = "";
        calculationsResult = 0;
        currentNumber = "";
        currentOpperator = null;
        display.setText("0");
        calculationsString = "0";
    }

    private void numberIsTapped(int tappedNumber){

        currentNumber = currentNumber + String.valueOf(tappedNumber);
        display.setText(currentNumber + calculationsString);
        calculationsString = currentNumber;

    }

    private void operatorIsTapped(OPERATOR tappedOperator){

        if(currentOpperator != null){
            if(currentNumber != "") {

                numberRight = currentNumber;
                currentNumber = "";

                switch (currentOpperator) {

                    case PLUS:
                        calculationsResult = Integer.parseInt(numberLeft) + Integer.parseInt(numberRight);
                        break;
                    case MINUS:
                        calculationsResult = Integer.parseInt(numberLeft) - Integer.parseInt(numberRight);
                        break;
                    case INMULTIT:
                        calculationsResult = Integer.parseInt(numberLeft) * Integer.parseInt(numberRight);
                        break;
                    case IMPARTIT:
                        calculationsResult = Integer.parseInt(numberLeft) / Integer.parseInt(numberRight);
                        break;


                }

                numberLeft = String.valueOf(calculationsResult);
                display.setText(numberLeft);
                calculationsString = numberLeft;
            }
        }
        else {

            numberLeft = currentNumber;
            currentNumber = "";

        }

        currentOpperator = tappedOperator;
    }
}