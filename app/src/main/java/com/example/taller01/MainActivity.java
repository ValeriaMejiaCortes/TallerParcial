package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAddEmployee;
    private Button btnConsultations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddEmployee = findViewById(R.id.btnAddEmployee);
        btnConsultations = findViewById(R.id.btnConsultations);

        btnAddEmployee.setOnClickListener(this);
        btnConsultations.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddEmployee){
            Intent myIntent = new Intent( this, AddPerson.class);
            startActivity(myIntent);
        }
        if (v.getId() == R.id.btnConsultations){
            Intent myIntent = new Intent( this, Consultations.class);
            startActivity(myIntent);
        }
    }
}