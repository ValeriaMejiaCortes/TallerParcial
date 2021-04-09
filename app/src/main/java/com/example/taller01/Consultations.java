package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;

public class Consultations extends AppCompatActivity implements View.OnClickListener {


    private Button btnYoung;
    private Button btnOld;
    private Button btnPay;
    private Button btnList;
    private TextView textView;
    private EditText txtFindPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultations);

        btnYoung = findViewById(R.id.btnYoung);
        btnOld = findViewById(R.id.btnOld);
        btnPay = findViewById(R.id.btnPay);
        btnList = findViewById(R.id.btnList);
        textView = findViewById(R.id.textView);
        txtFindPosition = findViewById(R.id.txtFindPosition);

        btnYoung.setOnClickListener(this);
        btnOld.setOnClickListener(this);
        btnPay.setOnClickListener(this);
        btnList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String oldPerson = "";
        String youngPerson = "";

        int max = 0;
        for (int i = 0; i < FakeDatabase.getEmployeeList().size(); i++) {
            if (FakeDatabase.getEmployeeList().get(i).getEdad() > max) {
                max = FakeDatabase.getEmployeeList().get(i).getEdad();
                oldPerson = FakeDatabase.getEmployeeList().get(i).getName() + " " +FakeDatabase.getEmployeeList().get(i).getApellido();
            }
        }
        int min = max;
        for (int i = 0; i < FakeDatabase.getEmployeeList().size(); i++) {
            if (FakeDatabase.getEmployeeList().get(i).getEdad() < min) {
                min = FakeDatabase.getEmployeeList().get(i).getEdad();
                youngPerson = FakeDatabase.getEmployeeList().get(i).getName() + " " +FakeDatabase.getEmployeeList().get(i).getApellido();
            }
        }

        Double maxSalary = 0.0;
        Double sumSalary = 0.0;
        for (int i = 0; i < FakeDatabase.getEmployeeList().size(); i++) {
            sumSalary += FakeDatabase.getEmployeeList().get(i).getSalario() ;
            if (FakeDatabase.getEmployeeList().get(i).getSalario() > maxSalary) {
                maxSalary = FakeDatabase.getEmployeeList().get(i).getSalario();
                oldPerson = FakeDatabase.getEmployeeList().get(i).getName() + " " +FakeDatabase.getEmployeeList().get(i).getApellido();
            }
        }
        Double minSalary = maxSalary;
        for (int i = 0; i < FakeDatabase.getEmployeeList().size(); i++) {
            if (FakeDatabase.getEmployeeList().get(i).getSalario() < minSalary) {
                minSalary = FakeDatabase.getEmployeeList().get(i).getSalario();
                youngPerson = FakeDatabase.getEmployeeList().get(i).getName() + " " +FakeDatabase.getEmployeeList().get(i).getApellido();
            }
        }

        if (v.getId() == R.id.btnOld){
            textView.setText("El más adulto es: " + oldPerson + " con " + max + " años");
        }
        if (v.getId() == R.id.btnYoung){
            textView.setText("El más jovén es: " + youngPerson + " con " + min + " años");
        }
        if (v.getId() == R.id.btnPay){
            textView.setText("El salario más alto es: " + maxSalary);
            textView.append(" - El salario más bajo es: " + minSalary);
            Double promedio = sumSalary/(FakeDatabase.getEmployeeList().size());
            textView.append(" - El promedio es de: " + promedio);
        }
        if (v.getId() == R.id.btnList){

            String position = txtFindPosition.getText().toString();

            if (position.isEmpty()){
                CustomToastView.makeErrorToast(this, "Error al validar el Cargo", R.layout.custom_toast).show();
                return;
            }
            Intent myIntent = new Intent( this, Show.class);
            myIntent.putExtra("cargo", position);
            startActivity(myIntent);
        }

    }


}
