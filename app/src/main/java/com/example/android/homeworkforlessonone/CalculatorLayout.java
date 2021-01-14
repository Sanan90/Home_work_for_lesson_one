package com.example.android.homeworkforlessonone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class calculatorLayout extends AppCompatActivity {

    double mPlusMemory = 0;
    double num = 0;
    String number;
    String maths = null;
    String point = ".";
    int restart = 0;
    String lastButton;
    String start = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_layout);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonTimes = findViewById(R.id.buttonTimes);
        Button buttonDivided = findViewById(R.id.buttonDivided);
        Button buttonEqual = findViewById(R.id.equally);
        Button buttonPoint = findViewById(R.id.buttonPoint);
        Button buttonC = findViewById(R.id.c);
        Button buttonMplus = findViewById(R.id.mPlus);
        Button buttonDelete = findViewById(R.id.delete);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "1";
                display(number);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "2";
                display(number);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "3";
                display(number);
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "4";
                display(number);
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "5";
                display(number);
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "6";
                display(number);
            }
        });


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "7";
                display(number);
            }
        });


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "8";
                display(number);
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "9";
                display(number);
            }
        });


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "0";
                display(number);
            }
        });


        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                math("-");
            }
        });


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                math("+");
            }
        });


        buttonDivided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                math("/");
            }
        });


        buttonTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                math("*");
            }
        });


        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point(point);
            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equal();
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });


        buttonMplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlus();
            }
        });


        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ac();
            }
        });

    }

    public void display(String a) {

        TextView numbersText = findViewById(R.id.forNumbers);
        lastButton = a;
        if (restart != 1) {
            if (numbersText.getText().equals("0") && a.equals("0")) {
                return;
            } else if (numbersText.getText().length() < 10) {
                if (numbersText.getText().equals("0")) {
                    numbersText.setText(a);
                } else {
                    numbersText.setText(numbersText.getText() + a);
                }
            }
        } else {
            numbersText.setText(a);
            restart = 0;
            return;
        }
    }


    public void display(Double a) {
        TextView numbersText = findViewById(R.id.forNumbers);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String forDisplay = decimalFormat.format(a);
        numbersText.setText(forDisplay);
    }


    public void point(String point) {
        TextView numbersText = findViewById(R.id.forNumbers);
        if (numbersText.length() > 0 && numbersText.length() < 10) {
            for (int i = 0; i < numbersText.length(); i++) {
                String word = String.valueOf(numbersText.getText().charAt(i));
                if (word.equals(point)) {
                    return;
                }
            }
            numbersText.setText(numbersText.getText() + point);
            lastButton = point;
        }
    }


    public void math(String math) {
        TextView numbersText = findViewById(R.id.forNumbers);

        if (lastButton == "+" || lastButton == "-" || lastButton == "*" || lastButton == "/") {
            maths = math;
            return;
        }

        if (start == null) {
            num = (double) Double.valueOf((String) numbersText.getText());
            maths = math;
            display((double) num);
            restart = 1;
            start = "2";
            lastButton = math;
        } else {
            if (maths.equals("-")) {
                num -= (double) Double.valueOf((String) numbersText.getText());
                display((double) num);
                maths = math;
                restart = 1;
                lastButton = math;
            }   else if (maths.equals("+")) {
                num += Double.valueOf((String) numbersText.getText());
                display((double) num);
                maths = math;
                restart = 1;
                lastButton = math;
            }   else if (maths.equals("*")) {
                num *= Double.valueOf((String) numbersText.getText());
                display((double) num);
                maths = math;
                restart = 1;
                lastButton = math;
            }   else if (maths.equals("/")) {
                num /= Double.valueOf((String) numbersText.getText());
                display((double) num);
                maths = math;
                restart = 1;
                lastButton = math;
            }
        }
    }


    public void equal () {
        TextView numbersText = findViewById(R.id.forNumbers);

        if (lastButton == "=") {
            return;
        }

        lastButton = "=";
        if (maths == null) {
            return;

        }   else {
            if (maths == "-") {
                num -= Double.valueOf((String) numbersText.getText());
                display((double) num);
                restart = 1;
                start = null;

            }   else if ( maths == "+") {
                num += Double.valueOf((String) numbersText.getText());
                display((double) num);
                restart = 1;
                start = null;


            }   else if ( maths == "*") {
                num *= Double.valueOf((String) numbersText.getText());
                display((double) num);
                restart = 1;
                start = null;


            }   else if ( maths == "/") {
                num /= Double.valueOf((String) numbersText.getText());
                display((double) num);
                restart = 1;
                start = null;

            }
        }
    }

    public void ac() {
        double num = 0;
        String number;
        String maths = null;
        String point = ".";
        int restart = 0;
        String lastButton;
        String start = null;
        display((double) num);
    }


    public void delete() {
        TextView numbersText = findViewById(R.id.forNumbers);
        if (numbersText.getText().length() < 1) {
            return;
        }   else if (numbersText.getText().length() == 1) {
            numbersText.setText("0");
        }   else {
            String newText = "";
            for (int i = 0; i < numbersText.getText().length()-1; i++) {
                newText += String.valueOf(numbersText.getText().charAt(i));
            }
            numbersText.setText(newText);
        }
    }

    public void mPlus() {

    }

}