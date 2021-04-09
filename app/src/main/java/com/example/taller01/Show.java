package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Show extends AppCompatActivity{

    private ListView listView;
    private ArrayList<String> namesList = new ArrayList<String>();
    private TextView txtSalaryAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        listView = (ListView)findViewById(R.id.listView);
        txtSalaryAverage = findViewById(R.id.txtSalaryAverage);

        Intent intent = getIntent();
        String position = intent.getStringExtra("cargo");

        Double sumSalary = 0.0;
        int cont = 0;
        for (int i = 0; i < FakeDatabase.getEmployeeList().size(); i++){
            if (FakeDatabase.getEmployeeList().get(i).getPosition().equals(position)){
                cont ++;
                sumSalary += FakeDatabase.getEmployeeList().get(i).getSalario();
                namesList.add(FakeDatabase.getEmployeeList().get(i).getName().toString());
            }
        }

        Double average = sumSalary/cont;
        txtSalaryAverage.setText("El promedio de los salario por este cargo es: " + average);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, namesList);
        listView.setAdapter(adapter);
    }


}