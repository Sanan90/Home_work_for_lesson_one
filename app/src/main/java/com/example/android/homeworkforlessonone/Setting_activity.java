package com.example.android.homeworkforlessonone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Setting_activity extends AppCompatActivity {

    private int checkread;


    private static final String NameSharedPreference = "LOGIN";

    // Имя параметра в настройках
    private static final String AppTheme = "APP_THEME";
    private static final int buttonStyls = 1;
    private static final int buttomStyls2 = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.buttonStyls));
        setContentView(R.layout.activity_setting_activity);
        initThemeChooser();
    }


    protected void initThemeChooser() {
        initRadioButton(findViewById(R.id.theme2),
                buttomStyls2);
        initRadioButton(findViewById(R.id.theme1),
                buttonStyls);
    }

    protected void initRadioButton(View button, final int codeStyle) {

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

    protected int getAppTheme(int codeStyle) {

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


    protected void asd(int a) {
        CheckBox checkBox1 = findViewById(R.id.theme1);
        CheckBox checkBox2 = findViewById(R.id.theme2);

        if (a == 2) {
            checkBox2.setChecked(true);
        } else {
            checkBox1.setChecked(true);
        }
    }

}