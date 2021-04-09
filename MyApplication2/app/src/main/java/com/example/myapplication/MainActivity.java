package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etLoginName;
    private EditText etLoginPassword;
    private Button btnLoginSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView();

        btnLoginSend.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
    }
    private void setContentView(){
        etLoginName = findViewById(R.id.txtUserName);
        etLoginPassword = findViewById(R.id.txtUserName);
        btnLoginSend = findViewById(R.id.btnLogin);
    }
}