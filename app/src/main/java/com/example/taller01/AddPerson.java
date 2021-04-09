package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.regex.Pattern;

public class AddPerson extends AppCompatActivity implements View.OnClickListener {

    private Button btnDone;
    private EditText txtName;
    private EditText txtLastName;
    private EditText txtAge;
    private EditText txtPosition;
    private EditText txtSalary;
    private EditText txtEmail;
    private int id = 0;

    Person personita[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        btnDone = findViewById(R.id.btnDone);
        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtAge = findViewById(R.id.txtAge);
        txtPosition = findViewById(R.id.txtPosition);
        txtSalary = findViewById(R.id.txtSalary);
        txtEmail = findViewById(R.id.txtEmail);

        btnDone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDone){
            String name = txtName.getText().toString();
            String lastName = txtLastName.getText().toString();
            int age = Integer.parseInt(txtAge.getText().toString());
            String position = txtPosition.getText().toString();
            Double salary = Double.parseDouble(txtSalary.getText().toString());
            String email = txtEmail.getText().toString();

            if (name.isEmpty()){
                CustomToastView.makeErrorToast(this, "Error al validar el Nombre", R.layout.custom_toast).show();
                return;
            }
            if (lastName.isEmpty()){
                CustomToastView.makeErrorToast(this, "Error al validar el Apellido", R.layout.custom_toast).show();
                return;
            }
            if (age == 0){
                CustomToastView.makeErrorToast(this, "Error al validar la Edad", R.layout.custom_toast).show();
                return;
            }
            if (position.isEmpty()){
                CustomToastView.makeErrorToast(this, "Error al validar el Cargo", R.layout.custom_toast).show();
                return;
            }
            if (salary == 0){
                CustomToastView.makeErrorToast(this, "Error al validar el Salario", R.layout.custom_toast).show();
                return;
            }

            if (!isValidEmail(email)){
                CustomToastView.makeErrorToast(this, "Error al validar el Email", R.layout.custom_toast).show();
                return;
            }

            id = generateId();
            FakeDatabase.AddEmployee(id, name, lastName,age,position,salary,email);
            saved();
            clean();
        }
    }

    private Boolean isValidEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private int generateId(){
        int index = FakeDatabase.getEmployeeList().size() - 1;
        int id = FakeDatabase.getEmployeeList().get(index).getId();
        return id++;
    }

    private void saved(){
        for (int i = 0; i < FakeDatabase.getEmployeeList().size(); i++) {
            if (FakeDatabase.getEmployeeList().get(i).getId() == id) {
                CustomToastView.makeSuccessToast(this, "Guardado con exito", R.layout.custom_toast).show();
                return;
            }
        }
    }

    private void clean(){
        txtName.setText("");
        txtLastName.setText("");
        txtAge.setText("0");
        txtPosition.setText("");
        txtSalary.setText("0");
        txtEmail.setText("");
    }
}