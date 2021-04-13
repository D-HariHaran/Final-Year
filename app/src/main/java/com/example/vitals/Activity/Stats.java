package com.example.vitals.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vitals.R;


public class Stats extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_page);
        getSupportActionBar().hide();
        TextView name,age,gender;

        name = findViewById(R.id.vital_name);
        age = findViewById(R.id.vital_age);
        gender=findViewById(R.id.vital_gender);
        final SharedPreferences preferences = getSharedPreferences("register",0);

        name.setText(preferences.getString("Patient_name","Error"));
        int set_age=preferences.getInt("Age",0);
        age.setText(String.valueOf(set_age));
        int male= preferences.getInt("gender",0);
        gender.setText(male==1?"Male":"Female");




    }
}
