package com.birzeit.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView welcomeTxtView;
    TextView nameTxtView;
    TextView genderTxtView;
    TextView birthDateTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcomeTxtView = findViewById(R.id.welcomeTxtView);
        nameTxtView = findViewById(R.id.nameTxtView);
        genderTxtView = findViewById(R.id.genderTxtView);
        birthDateTxtView = findViewById(R.id.birthDateTxtView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nameData");
        String fullName = intent.getStringExtra("fullNameData");
        String gender = intent.getStringExtra("genderData");
        String date = intent.getStringExtra("dateData");

        welcomeTxtView.setText("Welcome "+ name);
        nameTxtView.setText(fullName);
        genderTxtView.setText(gender);
        birthDateTxtView.setText(date);
    }
}