package com.raghavi.attendancemanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText totalLectures;
    EditText bunkedLectures;
    Button attendancebutton;

    Float savedValue;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        totalLectures = findViewById(R.id.total_lectures);
        bunkedLectures = findViewById(R.id.bunked_lectures);
        attendancebutton = findViewById(R.id.attendance_button);

       /* sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        savedValue = Float.valueOf(sharedPreferences.getFloat("Percentage",  0));

        attendancebutton.setText(String.valueOf((Float) savedValue));

        attendancebutton.setText(String.valueOf((Float) LoadFloat("Percentage")));

          sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        savedValue = sharedPreferences.getFloat("Denominator", 0);
        totalLectures.setText(String.valueOf((Float) savedValue));

*/
        totalLectures.setText(String.valueOf((Float) loadFloat("Denominator")));
        bunkedLectures.setText(String.valueOf((Float) loadFloat("Numerator")));
    }


    public void setAttendanceTextView(View view) {
        Float per;
        //getting the number of bunked lectures
        String bunkedLecturesString = bunkedLectures.getText().toString();
        Float numerator = Float.parseFloat(bunkedLecturesString);
        saveFloat("Numerator", (float) numerator);


        //getting the number of lectures in total
        String totalLecturesString = totalLectures.getText().toString();
        Float denominator = Float.parseFloat(totalLecturesString);
        saveFloat("Denominator", (float) denominator);


        per = ((numerator * 100) / denominator);

        //SaveInt("Percentage", per);

        attendancebutton.setText(String.valueOf(((Float) per)));

        saveFloat("Percentage", (float) per);
    }


    public void saveFloat(String key, float value) {
       // sharedPreferences = this.getSharedPreferences(key, 0);
        //SharedPreferences.Editor editor = sharedPreferences.edit();
        SharedPreferences.Editor editor = getSharedPreferences("com.raghavi.attendancemanager", Context.MODE_PRIVATE).edit();
        editor.putFloat(key, value);
        editor.apply();


    }

    public Float loadFloat(String key) {

        sharedPreferences = this.getSharedPreferences("com.raghavi.attendancemanager", Context.MODE_PRIVATE);
        savedValue = sharedPreferences.getFloat(key, 0);
        return savedValue;
    }
}

