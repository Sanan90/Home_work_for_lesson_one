package com.example.android.homeworkforlessonone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    int trusts = 0;
    int interests = 0;
    String trustText;
    String interestsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.compare);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name()) {
                    if (ready()) {
                        trust();
                        interest();
                        compare();
                    }
                }
            }
        });
    }





    public boolean name()  {

        EditText name1 = findViewById(R.id.name);
        EditText name2 = findViewById(R.id.name2);

        if (name1.length() > 0 && name2.length() > 0) {
            return true;
        }   else {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.forget_name, Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }

    public boolean ready()  {

        ToggleButton ready1 = findViewById(R.id.ready);
        ToggleButton ready2 = findViewById(R.id.ready2);

        if (ready1.isChecked() && ready2.isChecked()) {
            return true;
        }   else {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.notReady, Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }

    public void trust() {

        Switch trust1 = findViewById(R.id.trust);
        Switch trust2 = findViewById(R.id.trust2);

        if (trust1.isChecked()) {
            trusts += 1;
        }
        if (trust2.isChecked()) {
            trusts += 1;
        }
    }

    public void interest() {

        CheckBox cinema1 = findViewById(R.id.cinema);
        CheckBox cinema2 = findViewById(R.id.cinema2);
        CheckBox travel1 = findViewById(R.id.travel);
        CheckBox travel2 = findViewById(R.id.travel2);
        CheckBox creation1 = findViewById(R.id.creation);
        CheckBox creation2 = findViewById(R.id.creation2);
        CheckBox sport1 = findViewById(R.id.sport);
        CheckBox sport2 = findViewById(R.id.sport2);
        CheckBox extrim1 = findViewById(R.id.extrim);
        CheckBox extrim2 = findViewById(R.id.extrim2);
        CheckBox programming1 = findViewById(R.id.programming);
        CheckBox programming2 = findViewById(R.id.programming2);

        if (cinema1.isChecked() && cinema2.isChecked()) {
            interests += 1;
        }
        if (sport1.isChecked() && sport2.isChecked()) {
            interests += 1;
        }
        if (extrim1.isChecked() && extrim2.isChecked()) {
            interests += 1;
        }
        if (creation1.isChecked() && creation2.isChecked()) {
            interests += 1;
        }
        if (travel1.isChecked() && travel2.isChecked()) {
            interests += 1;
        }
        if (programming1.isChecked() && programming2.isChecked()) {
            interests += 1;
        }
    }

    public void compare() {

        TextView finalCompareText = findViewById(R.id.finalCompareText);
        LinearLayout ex = findViewById(R.id.noDisplay);

        if (trusts == 0) {
            finalCompareText.setText("\n" + getString(R.string.notTrust) + "\nУ вас " + interests + " общих интересов, из 6 возможных");
        }   else if (trusts == 1) {
            finalCompareText.setText("\n" + getString(R.string.littleTrust) + "\n У вас " + interests + " общих интересов, из 6 возможных");
        }   else {
            finalCompareText.setText("\n" + getString(R.string.absolutlyTrust) + "\n У вас " + interests + " общих интересов, из 6 возможных");
        }

        ex.setVisibility(View.GONE);
        finalCompareText.setVisibility(View.VISIBLE);
    }

}