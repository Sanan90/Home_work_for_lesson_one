package com.example.android.homeworkforlessonone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {

    String name;
    String login;
    String password;
    String email;
    int height;
    int number;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = findViewById(R.id.button);
        CalendarView calendar = findViewById(R.id.birthday);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                int mYear = year;
                int mMonth = month;
                int mDay = dayOfMonth;
                date = mDay + "." + mMonth + "." + mYear;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (information()) {
                    display();
                }


            }
        });

    }

    public boolean information() {

        EditText nameText = findViewById(R.id.nameText);
        EditText loginText = findViewById(R.id.loginText);
        EditText passwordText = findViewById(R.id.passwordText);
        EditText heightText = findViewById(R.id.heightText);
        EditText emailText = findViewById(R.id.emailText);
        EditText numberText = findViewById(R.id.numberText);

        if (nameText.length() > 0 && loginText.length() > 0 && passwordText.length() > 0 && heightText.length() > 0
                && emailText.length() > 0 && numberText.length() > 0) {

            name = nameText.getText().toString();
            login = loginText.getText().toString();
            password = passwordText.getText().toString();
            email = emailText.getText().toString();
            number = Integer.parseInt(numberText.getText().toString());
            height = Integer.parseInt(heightText.getText().toString());
            return true;
        }   else {
            Toast toast = Toast.makeText(getApplicationContext(), "Введите все данные", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }


    public void display() {
        LinearLayout linearLayout = findViewById(R.id.main2linerLayout);
        TextView mainText = findViewById(R.id.final_result);

        mainText.setText("Проверьте ваши данные \n\n Ваше имя " + name + "\n\n Ваш логин " + login + "\n\n Ваш пароль "+
                password + "\n\n Дата рождения " + date + "\n\n Ваш электронный адрес " +
                email + "\n\n Ваш номер " + number + "\n\n Ваш рост " + height);

        linearLayout.setVisibility(View.GONE);
        mainText.setVisibility(View.VISIBLE);
    }
}