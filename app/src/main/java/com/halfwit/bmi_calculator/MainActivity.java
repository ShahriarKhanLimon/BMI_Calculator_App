package com.halfwit.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(v -> {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft * 12 + in;

                double totalCm = totalIn * 2.53;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                // Format BMI to 2 decimal places for better readability
                String bmiFormatted = String.format("%.2f", bmi);

                if (bmi > 25) {
                    txtResult.setText("BMI: " + bmiFormatted + "\n" + getString(R.string.resultOw));
                    llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.yellow));
                } else if (bmi < 18) {
                    txtResult.setText("BMI: " + bmiFormatted + "\n" + getString(R.string.resultUw));
//                    txtResult.setText(R.string.resultUw);
//                    llMain.setBackgroundColor(getResources().getColor(R.color.red));
                    llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red));
                } else{
                    txtResult.setText("BMI: " + bmiFormatted + "\n" + getString(R.string.resultH));
                    llMain.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
                }
        });
    }
}


