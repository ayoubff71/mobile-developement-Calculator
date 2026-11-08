package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity {
    private Button calculatorBtn;
    private EditText edtTxt1 , editText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        calculatorBtn = findViewById(R.id.calcBtn);
        edtTxt1 = findViewById(R.id.edtTxt1);
        editText = findViewById(R.id.editText);

        calculatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTxt1.getText().toString().trim().isEmpty() || editText.getText().toString().trim().isEmpty()){
                    Snackbar.make(v , "PLEASE ENTER YOUR USERNAME AND PASSWORD" , Snackbar.LENGTH_LONG).show();
                    return;
                }
                Snackbar.make(v , "YOU ARE REDIRECTING TO CALCULATOR" , Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(Login.this , StandardActivity.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}