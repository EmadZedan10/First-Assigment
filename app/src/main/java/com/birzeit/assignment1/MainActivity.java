package com.birzeit.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText firstName_edtText;
    EditText lastName_edtText;
    RadioButton male_rdBtn;
    RadioButton female_rdBtn;
    Spinner daySpinner;
    Spinner monthSpinner;
    Spinner yearSpinner;
    Button submitBtn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName_edtText = findViewById(R.id.firstName_edtText);
        lastName_edtText = findViewById(R.id.lastName_edtText);
        male_rdBtn = findViewById(R.id.male_rdBtn);
        female_rdBtn = findViewById(R.id.female_rdBtn);
        daySpinner = findViewById(R.id.daySpinner);
        monthSpinner = findViewById(R.id.monthSpinner);
        yearSpinner = findViewById(R.id.yearSpinner);
        submitBtn = findViewById(R.id.submitBtn);

        populateSpinner();
    }

    private void populateSpinner() {

        ArrayList<String> dayData = new ArrayList<>();
        for(int i = 1; i <= 31 ; i++){
            dayData.add(i + "");
        }

        ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,dayData);
        daySpinner.setAdapter(dayAdapter);

        ArrayList<String> monthData = new ArrayList<>();
        monthData.add("Jan");monthData.add("Feb");monthData.add("Mar");monthData.add("Apr");monthData.add("May");monthData.add("Jun");
        monthData.add("Jul");monthData.add("Aug");monthData.add("Sep");monthData.add("Oct");monthData.add("Nov");monthData.add("Dec");

        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, monthData);
        monthSpinner.setAdapter(monthAdapter);

        ArrayList<String> yearData = new ArrayList<>();
        for(int i = 1980; i <= 2021 ; i++){
            yearData.add(i + "");
        }

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yearData);
        yearSpinner.setAdapter(yearAdapter);
    }

    public void submitButtonOnAction(View view) {

        InputMethodManager mgr = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);

        Intent intent = new Intent(this, MainActivity2.class);
        String name = firstName_edtText.getText().toString();
        String fullName = firstName_edtText.getText().toString() + " " + lastName_edtText.getText().toString();

        String selectedDay = daySpinner.getSelectedItem().toString();
        String selectedMonth = monthSpinner.getSelectedItem().toString();
        String selectedYear = yearSpinner.getSelectedItem().toString();

        String date = selectedDay + " / " + selectedMonth +  " / " + selectedYear +" ";
        String gender = " ";
        if(male_rdBtn.isChecked()){
            gender = "Male";
        }else if(female_rdBtn.isChecked()){
            gender = "Female";
        }

        intent.putExtra("nameData", name);
        intent.putExtra("fullNameData", fullName);
        intent.putExtra("genderData", gender);
        intent.putExtra("dateData", date);
        startActivity(intent);
    }
}