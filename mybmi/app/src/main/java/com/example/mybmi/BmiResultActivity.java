package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    TextView result;
    TextView bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        if(getIntent() != null){

            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("weight", 0);

            // 체중 / 신장(m) * 신장(m)
            double bmiValue = weight / Math.pow(height / 100.0, 2);
            Log.d("TAG", bmiValue + "");
            String resultText = "";


            if(bmiValue < 18.5){
                resultText = "저체중 입니다";
            }else if(bmiValue < 23){
                resultText = "정상 체중입니다";
            } else if(bmiValue < 25){
                resultText = "과체중 입니다";
            } else{
                resultText = "비만 입니다";
            }

            bmi = findViewById(R.id.bmi);
            bmi.setText("BMI = " + bmiValue);

            result = findViewById(R.id.result);

            result.setText(resultText);

        }



    }
}