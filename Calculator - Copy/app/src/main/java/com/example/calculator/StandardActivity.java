package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StandardActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    private Button delete, delAll, effacer, plsOuMinus, virgul, equal, plus, minus, multiple, division, frac, carre, rac, prcBtn;

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
        } else if (id == R.id.rac) {
            if (!textView.getText().toString().isEmpty()) {
                try {
                    currentNumber = Double.parseDouble(textView.getText().toString());
                    currentNumber = Math.sqrt(currentNumber);
                    textView.setText(String.valueOf(currentNumber));
                } catch (NumberFormatException ignored) {}
            }
        } else if (id == R.id.carre) {
            if (!textView.getText().toString().isEmpty()) {
                try {
                    currentNumber = Double.parseDouble(textView.getText().toString());
                    currentNumber = currentNumber * currentNumber;
                    textView.setText(String.valueOf(currentNumber));
                } catch (NumberFormatException ignored) {}
            }
        } else if (id == R.id.frac) {
            if (!textView.getText().toString().isEmpty()) {
                try {
                    currentNumber = Double.parseDouble(textView.getText().toString());
                    currentNumber = 1 / currentNumber;
                    textView.setText(String.valueOf(currentNumber));
                } catch (NumberFormatException ignored) {}
            }
        } else if (id == R.id.plsOuMinus) {
            if (!textView.getText().toString().isEmpty()) {
                try {
                    currentNumber = Double.parseDouble(textView.getText().toString());
                    currentNumber = -currentNumber;
                    textView.setText(String.valueOf(currentNumber));
                } catch (NumberFormatException ignored) {}
            }
        } else if (id == R.id.prcBtn) {
            if (!textView.getText().toString().isEmpty()) {
                try {
                    currentNumber = Double.parseDouble(textView.getText().toString());
                    currentNumber = currentNumber / 100;
                    textView.setText(String.valueOf(currentNumber));
                } catch (NumberFormatException ignored) {}
            }
        } else if (id == R.id.equal) {
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
                                Toast.makeText(StandardActivity.this, "you can't divide by 0", Toast.LENGTH_LONG).show();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        menuButton = findViewById(R.id.menuButton);

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

        delete = findViewById(R.id.delete);
        equal = findViewById(R.id.equal);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiple = findViewById(R.id.multiple);
        division = findViewById(R.id.division);
        delAll = findViewById(R.id.delAll);
        effacer = findViewById(R.id.effacer);
        plsOuMinus = findViewById(R.id.plsOuMinus);
        virgul = findViewById(R.id.virgul);
        frac = findViewById(R.id.frac);
        carre = findViewById(R.id.carre);
        rac = findViewById(R.id.rac);
        prcBtn = findViewById(R.id.prcBtn);

        delete.setOnClickListener(this);
        equal.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiple.setOnClickListener(this);
        division.setOnClickListener(this);
        delAll.setOnClickListener(this);
        effacer.setOnClickListener(this);
        plsOuMinus.setOnClickListener(this);
        virgul.setOnClickListener(this);
        frac.setOnClickListener(this);
        carre.setOnClickListener(this);
        rac.setOnClickListener(this);
        prcBtn.setOnClickListener(this);

        menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(StandardActivity.this, menuButton);

            popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();

                if (id == R.id.standard) {
                    Intent intent = new Intent(StandardActivity.this, StandardActivity.class);
                    startActivity(intent);
                } else if (id == R.id.scientific) {
                    Intent intent = new Intent(StandardActivity.this, ScientificActivity.class);
                    startActivity(intent);
                }
                else if(id == R.id.devise){
                    Intent intent = new Intent(StandardActivity.this , deviseActivity.class);
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