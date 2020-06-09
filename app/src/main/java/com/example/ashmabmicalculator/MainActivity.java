package com.example.ashmabmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
    }

    public void calculateBMI(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)) {

            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);
            float bmi = weightValue / (heightValue * heightValue);
            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";
        if (Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 24.99f) <= 0) {
            bmiLabel = getString(R.string.normal_weight);
        } else if (Float.compare(bmi, 25) > 0 && Float.compare(bmi, 29.9f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else {
            bmiLabel = getString(R.string.obese_class_i);
        }
        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}