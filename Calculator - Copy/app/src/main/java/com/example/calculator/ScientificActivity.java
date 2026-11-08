package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import kotlin.TuplesKt;

public class ScientificActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    private Button logarithm, delAll, effacer, plsOuMinus, virgul, equal, plus, minus, multiple, division , sin , cos , tan , log , fac , abs , exp , pi  ;

    private String operateur;
    private TextView textView;
    private Double firstNumber, secondNumber, result, currentNumber;

    private Button menuButton;



    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button0) {
            textView.setText(textView.getText() + "0");
        } else if (id == R.id.button1) {
            textView.setText(textView.getText() + "1");
        } else if (id == R.id.button2) {
            textView.setText(textView.getText() + "2");
        } else if (id == R.id.button3) {
            textView.setText(textView.getText() + "3");
        } else if (id == R.id.button4) {
            textView.setText(textView.getText() + "4");
        } else if (id == R.id.button5) {
            textView.setText(textView.getText() + "5");
        } else if (id == R.id.button6) {
            textView.setText(textView.getText() + "6");
        } else if (id == R.id.button7) {
            textView.setText(textView.getText() + "7");
        } else if (id == R.id.button8) {
            textView.setText(textView.getText() + "8");
        } else if (id == R.id.button9) {
            textView.setText(textView.getText() + "9");
        } else if (id == R.id.delete) {
            textView.setText("");
        } else if (id == R.id.delAll) {
            textView.setText("");
            firstNumber = null;
            secondNumber = null;
            operateur = null;
        } else if (id == R.id.plus) {
            if (!textView.getText().toString().isEmpty()) {
                try {
                    firstNumber = Double.parseDouble(textView.getText().toString());
                    textView.setText("");
                    operateur = "+";
                } catch (NumberFormatException ignored) {}
            }
        } else if (id == R.id.minus) {
            if (!textView.getText().toString().isEmpty()) {
                try {
                    firstNumber = Double.parseDouble(textView.getText().toString());
                    textView.setText("");
                    operateur = "-";
                } catch (NumberFormatException ignored) {}
            }
        } else if (id == R.id.multiple) {
            if (!textView.getText().toString().isEmpty()) {
                try {
                    firstNumber = Double.parseDouble(textView.getText().toString());
                    textView.setText("");
                    operateur = "x";
                } catch (NumberFormatException ignored) {}
            }
        } else if (id == R.id.division) {
            if (!textView.getText().toString().isEmpty()) {
                try {
                    firstNumber = Double.parseDouble(textView.getText().toString());
                    textView.setText("");
                    operateur = "/";
                } catch (NumberFormatException ignored) {}
            }
        } else if (id == R.id.effacer) {
            if (!textView.getText().toString().isEmpty()) {
                textView.setText(textView.getText().toString().substring(0, textView.getText().toString().length() - 1));
            }
        } else if (id == R.id.virgul) {
            String currentText = textView.getText().toString();
            if (!currentText.contains(".")) {
                if (currentText.isEmpty()) {
                    textView.setText("0.");
                } else {
                    textView.setText(currentText + ".");
                }
            }
        }
        else if(id == R.id.plsOuMinus){
            if (!textView.getText().toString().isEmpty()){
                try {
                    currentNumber =Double.parseDouble(textView.getText().toString());
                    currentNumber = - currentNumber;
                    textView.setText(String.valueOf(currentNumber));
                }
                catch (NumberFormatException ignored){}
            }
        }
        else if(id == R.id.logarithm){
            if (!textView.getText().toString().isEmpty()){
                try {
                    currentNumber = Double.parseDouble(textView.getText().toString());
                    currentNumber = Math.log(currentNumber);
                    textView.setText(String.valueOf(currentNumber));
                }
                catch (NumberFormatException ignored){}

            }
        }
        else if(id == R.id.log){
            if (!textView.getText().toString().isEmpty()){
                try {
                    currentNumber = Double.parseDouble(textView.getText().toString());
                    currentNumber = Math.log10(currentNumber);
                    textView.setText(String.valueOf(currentNumber));
                }
                catch (NumberFormatException ignored){}
            }
        }
        else if(id == R.id.exp){

                currentNumber = Math.E;
                textView.setText(String.valueOf(currentNumber));

        }

        else if(id == R.id.abs){
            if (!textView.getText().toString().isEmpty()){
                try {
                    currentNumber = Double.parseDouble(textView.getText().toString());
                    if (currentNumber < 0){
                        currentNumber = - currentNumber;
                        textView.setText(String.valueOf(currentNumber));
                    }
                } catch (NumberFormatException ignored) {}

            }
        }
        else if (id == R.id.sin){
            if (!textView.getText().toString().isEmpty()){
                currentNumber = Double.parseDouble(textView.getText().toString());
                try {
                    currentNumber = Math.sin(currentNumber);
                    textView.setText(String.valueOf(currentNumber));
                }
                catch (NumberFormatException ignored){}
            }
        }
        else if (id == R.id.cos){
            if (!textView.getText().toString().isEmpty()){
                currentNumber = Double.parseDouble(textView.getText().toString());
                try {
                    currentNumber = Math.cos(currentNumber);
                    textView.setText(String.valueOf(currentNumber));
                }
                catch (NumberFormatException ignored){}
            }
        }
        else if (id == R.id.tan){
            if (!textView.getText().toString().isEmpty()){
                currentNumber = Double.parseDouble(textView.getText().toString());
                try {
                    currentNumber = Math.tan(currentNumber);
                    textView.setText(String.valueOf(currentNumber));
                }
                catch (NumberFormatException ignored){}
            }
        }
        else if(id == R.id.fac){
            if (!textView.getText().toString().isEmpty()){
                try {
                    int factoriel = Integer.parseInt(textView.getText().toString());
                    int resultat = 1;
                    for(int i = factoriel ; i>=1;i--){
                        resultat *=i;
                    }
                    textView.setText(String.valueOf(resultat));
                }
                catch (NumberFormatException ignored){}

            }
            else{
                textView.setText("0");
            }
        }

        else if(id == R.id.pi){
                currentNumber = Math.PI;
                textView.setText(String.valueOf(currentNumber));
        }


        else if (id == R.id.equal) {
            if (!textView.getText().toString().isEmpty() && operateur != null && firstNumber != null) {
                try {
                    secondNumber = Double.parseDouble(textView.getText().toString());

                    switch (operateur) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "x":
                            result = firstNumber * secondNumber;
                            break;
                        case "/":
                            if (secondNumber == 0) {
                                Toast.makeText(ScientificActivity.this, "you can't divide by 0", Toast.LENGTH_LONG).show();
                                result = 0.0;
                            } else {
                                result = firstNumber / secondNumber;
                            }
                            break;
                        default:
                            result = 0.0;
                    }

                    textView.setText(String.valueOf(result));
                    operateur = null;
                } catch (NumberFormatException ignored) {}
            }
        }


    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        textView = findViewById(R.id.textView);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        equal = findViewById(R.id.equal);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiple = findViewById(R.id.multiple);
        division = findViewById(R.id.division);
        delAll = findViewById(R.id.delAll);
        effacer = findViewById(R.id.effacer);
        plsOuMinus = findViewById(R.id.plsOuMinus);
        virgul = findViewById(R.id.virgul);

        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);
        log = findViewById(R.id.log);
        logarithm = findViewById(R.id.logarithm);
        fac = findViewById(R.id.fac);
        exp = findViewById(R.id.exp);
        pi = findViewById(R.id.pi);
        abs = findViewById(R.id.abs);

        equal.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiple.setOnClickListener(this);
        division.setOnClickListener(this);
        delAll.setOnClickListener(this);
        effacer.setOnClickListener(this);
        plsOuMinus.setOnClickListener(this);
        virgul.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        log.setOnClickListener(this);
        logarithm.setOnClickListener(this);
        fac.setOnClickListener(this);
        exp.setOnClickListener(this);
        pi.setOnClickListener(this);
        abs.setOnClickListener(this);

        Button menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(v -> {

            PopupMenu popup = new PopupMenu(ScientificActivity.this, menuButton);

            popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {

                int id = item.getItemId();

                if (id == R.id.standard) {
                    Intent intent = new Intent(ScientificActivity.this, StandardActivity.class);
                    startActivity(intent);
                }

                else if (id == R.id.scientific) {
                    Intent intent = new Intent(ScientificActivity.this, ScientificActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.devise){
                    Intent intent = new Intent(ScientificActivity.this , deviseActivity.class);
                    startActivity(intent);
                }

                return true;
            });

            popup.show();
        });
    }


}