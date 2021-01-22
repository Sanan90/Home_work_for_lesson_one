package com.example.android.homeworkforlessonone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CalculatorLayout extends AppCompatActivity implements View.OnClickListener {

    private String number;
    private String point = ".";
    private TextView numbersText;
    private Operations operations;
    private final static String TAG = "[lifeActivity]";
    private final static String keyOperations = "Operations";
    private int checkread;
    Setting_activity cheking;


    private static final String NameSharedPreference = "LOGIN";

    // Имя параметра в настройках
    private static final String AppTheme = "APP_THEME";
    private static final int buttonStyls = 1;
    private static final int buttomStyls2 = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.buttonStyls));
        setContentView(R.layout.activity_calculator_layout);
        initThemeChooser();


        operations = new Operations();
        initViews();
        showDisplay();
    }


    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.theme2),
                buttomStyls2);
        initRadioButton(findViewById(R.id.theme1),
                buttonStyls);
    }

    private void initRadioButton(View button, final int codeStyle) {

        asd(checkread);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox1 = findViewById(R.id.theme1);
                CheckBox checkBox2 = findViewById(R.id.theme2);
                if (codeStyle == buttonStyls) {
                    checkBox1.setChecked(true);
                    checkBox2.setChecked(false);
                } else {
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(true);
                }
                // сохраним настройки
                setAppTheme(codeStyle);
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });
    }

    private int getAppTheme(int codeStyle) {

        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    // Чтение настроек, параметр «тема»
    private int getCodeStyle(int codeStyle) {
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    // Сохранение настроек
    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }


    private int codeStyleToStyleId(int codeStyle) {

        switch (codeStyle) {

            case buttomStyls2:
                checkread = 2;
                return R.style.buttonStyls2;
            default:
                checkread = 1;
                return R.style.buttonStyls;
        }
    }


    private void asd(int a) {
        CheckBox checkBox1 = findViewById(R.id.theme1);
        CheckBox checkBox2 = findViewById(R.id.theme2);

        if (a == 2) {
            checkBox2.setChecked(true);
        } else {
            checkBox1.setChecked(true);
        }
    }


    private void showDisplay() {
        if (operations.getOperationDisplay() != null) {
            numbersText.setText(operations.getOperationDisplay());
        }
    }

    public void initViews() {
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
        Button buttonSettings = findViewById(R.id.settingsButton);
        numbersText = findViewById(R.id.forNumbers);
        Typeface hw = Typeface.createFromAsset(getAssets(), "ttf/lcchalk_.ttf");
        numbersText.setTypeface(hw);



        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonTimes.setOnClickListener(this);
        buttonDivided.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonMplus.setOnClickListener(this);
        buttonSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                number = "1";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.button2:
                number = "2";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.button3:
                number = "3";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.button4:
                number = "4";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.button5:
                number = "5";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.button6:
                number = "6";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.button7:
                number = "7";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.button8:
                number = "8";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.button9:
                number = "9";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.button0:
                number = "0";
                operations.display(number, numbersText.getText().toString());
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.buttonPlus:
                operations.math("+");
                numbersText.setText(operations.getOperationDisplay());
                operations.setOperationDisplay(numbersText.getText().toString());
                break;

            case R.id.buttonMinus:
                operations.math("-");
                numbersText.setText(operations.getOperationDisplay());
                operations.setOperationDisplay(numbersText.getText().toString());
                break;

            case R.id.buttonTimes:
                operations.math("*");
                numbersText.setText(operations.getOperationDisplay());
                operations.setOperationDisplay(numbersText.getText().toString());
                break;

            case R.id.buttonDivided:
                operations.math("/");
                numbersText.setText(operations.getOperationDisplay());
                operations.setOperationDisplay(numbersText.getText().toString());
                break;

            case R.id.equally:
                operations.equal();
                numbersText.setText(operations.getOperationDisplay());
                operations.setOperationDisplay(numbersText.getText().toString());
                break;

            case R.id.delete:
                operations.delete();
                numbersText.setText(operations.getOperationDisplay());
                operations.setOperationDisplay(numbersText.getText().toString());
                break;

            case R.id.buttonPoint:
                operations.point(point);
                numbersText.setText(operations.getOperationDisplay());
                operations.setOperationDisplay(numbersText.getText().toString());
                break;

            case R.id.mPlus:
                operations.mPlus();
                numbersText.setText(operations.getOperationDisplay());
                break;

            case R.id.c:
                operations.ac();
                numbersText.setText(operations.getOperationDisplay());
                operations.setOperationDisplay(numbersText.getText().toString());
                break;

            case R.id.settingsButton:
                Intent settings = new Intent(this, Setting_activity.class);
                startActivity(settings);
                recreate();
                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        operations = (Operations) savedInstanceState.getSerializable(keyOperations);
        setOperations();
    }

    private void setOperations() {
        operations.setOperationDisplay(operations.getOperationDisplay());
        operations.setLastAtiphmeticSymbol(operations.getLastAtiphmeticSymbol());
        operations.setLastButton(operations.getLastButton());
        operations.setMaths(operations.getMaths());
        operations.setmPlusMemory(operations.getmPlusMemory());
        operations.setNum(operations.getNum());
        operations.setNum2(operations.getNum2());
        operations.setRestart(operations.getRestart());
        operations.setStart(operations.getStart());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(keyOperations, operations);
    }


}