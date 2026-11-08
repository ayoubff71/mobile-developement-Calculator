package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class deviseActivity extends AppCompatActivity {
    private Spinner spinnerFrom , spinnerTo;
    private EditText amount;
    private Button menuButton , convert;
    private TextView resultTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_devise);

        ArrayList<String> currencies = new ArrayList<>();
        spinnerFrom = findViewById(R.id.spinnerFrom);
        amount = findViewById(R.id.amount);
        spinnerTo = findViewById(R.id.spinnerTo);
        convert = findViewById(R.id.convert);
        menuButton = findViewById(R.id.menuButton);
        resultTextView = findViewById(R.id.resultTextView);

        currencies.add("USD");
        currencies.add("EUR");
        currencies.add("MAD");
        currencies.add("GPB");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                currencies
        );
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String currencie = parent.getItemAtPosition(position).toString();
                if (currencie.equals("USD")){
                    Toast.makeText(deviseActivity.this , "you selected USD" , Toast.LENGTH_LONG).show();
                }
                if (currencie.equals("EUR")){
                    Toast.makeText(deviseActivity.this , "you selected EUR" , Toast.LENGTH_LONG).show();
                }
                if (currencie.equals("MAD")){
                    Toast.makeText(deviseActivity.this , "you selected MAD" , Toast.LENGTH_LONG).show();
                }
                if (currencie.equals("GPB")){
                    Toast.makeText(deviseActivity.this , "you selected GPB" , Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String currencie = parent.getItemAtPosition(position).toString();
                if (currencie.equals("USD")){
                    Toast.makeText(deviseActivity.this , "you selected USD" , Toast.LENGTH_LONG).show();
                }
                if (currencie.equals("EUR")){
                    Toast.makeText(deviseActivity.this , "you selected EUR" , Toast.LENGTH_LONG).show();
                }
                if (currencie.equals("MAD")){
                    Toast.makeText(deviseActivity.this , "you selected MAD" , Toast.LENGTH_LONG).show();
                }
                if (currencie.equals("GPB")){
                    Toast.makeText(deviseActivity.this , "you selected GPB" , Toast.LENGTH_LONG).show();
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convert.setOnClickListener(v->{
            String inputAmount = amount.getText().toString();
            if (inputAmount.isEmpty()){
                Toast.makeText(deviseActivity.this , "please enter an amount" , Toast.LENGTH_LONG).show();
                return;
            }
            try {
                String fromCurrency = spinnerFrom.getSelectedItem().toString();
                String toCurrency = spinnerTo.getSelectedItem().toString();
                Double convertisseur , money;
                money = Double.parseDouble(inputAmount);
                if (fromCurrency.equals(toCurrency)){
                    Toast.makeText(deviseActivity.this , "you can't convert to the same currency" , Toast.LENGTH_LONG).show();
                    return;
                }
                else if (fromCurrency.equals("USD") && toCurrency.equals("MAD")){
                    convertisseur = money * 9.82;
                    resultTextView.setText(String.valueOf(convertisseur));
                }
                else if (fromCurrency.equals("USD") && toCurrency.equals("EUR")){
                    convertisseur = money * 0.89;
                    resultTextView.setText(String.valueOf(convertisseur));

                }
                else if (fromCurrency.equals("USD") && toCurrency.equals("GPB")){

                    convertisseur = money * 0.75;
                    resultTextView.setText(String.valueOf(convertisseur));
                }
                else if(fromCurrency.equals("EUR") && toCurrency.equals("USD")){

                    convertisseur = money * 1.12;
                    resultTextView.setText(String.valueOf(convertisseur));

                }
                else if(fromCurrency.equals("EUR") && toCurrency.equals("MAD")){

                    convertisseur = money * 10.99;
                    resultTextView.setText(String.valueOf(convertisseur));
                }
                else if(fromCurrency.equals("EUR") && toCurrency.equals("GPB")) {

                    convertisseur = money * 0.83;
                    resultTextView.setText(String.valueOf(convertisseur));
                }
                else if(fromCurrency.equals("MAD") && toCurrency.equals("USD")){

                    convertisseur = money * 0.10;
                    resultTextView.setText(String.valueOf(convertisseur));

                }
                else if(fromCurrency.equals("MAD") && toCurrency.equals("EUR")) {

                    convertisseur = money * 0.091;
                    resultTextView.setText(String.valueOf(convertisseur));
                }
                else if(fromCurrency.equals("MAD") && toCurrency.equals("GPB")) {

                    convertisseur = money * 0.078;
                    resultTextView.setText(String.valueOf(convertisseur));
                }
                else if(fromCurrency.equals("GPB") && toCurrency.equals("USD")) {

                    convertisseur = money * 1.34;
                    resultTextView.setText(String.valueOf(convertisseur));
                }
                else if(fromCurrency.equals("GPB") && toCurrency.equals("EUR")) {

                    convertisseur = money * 1.20;
                    resultTextView.setText(String.valueOf(convertisseur));
                }

                else if(fromCurrency.equals("GPB") && toCurrency.equals("MAD")) {

                    convertisseur = money * 13.18;
                    resultTextView.setText(String.valueOf(convertisseur));
                }
            }
            catch (NumberFormatException ignored){}

        });



        menuButton.setOnClickListener(v -> {

            PopupMenu popup = new PopupMenu(deviseActivity.this, menuButton);

            popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item ->{
                int id = item.getItemId();

                if (id == R.id.standard) {
                    Intent intent = new Intent(deviseActivity.this, StandardActivity.class);
                    startActivity(intent);
                }

                else if (id == R.id.scientific) {
                    Intent intent = new Intent(deviseActivity.this, ScientificActivity.class);
                    startActivity(intent);
                }
                else if(id == R.id.devise){
                    Intent intent = new Intent(deviseActivity.this , deviseActivity.class);
                    startActivity(intent);
                }

                return true;
            });

            popup.show();
            });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}