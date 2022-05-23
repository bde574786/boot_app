package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TGA";
    private TextView zero;
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView seven;
    private TextView five;
    private TextView six;
    private TextView eight;
    private TextView nine;
    private TextView ca;
    private TextView plus;
    private TextView result;
    private TextView multiply;
    private TextView substaract;
    private TextView divide;
    private TextView equal;


    String oldvalue = "0";
    String newvalue = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        initData();
        addEventListener();
    }


    private void initData() {
//        r = 주소값
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ca = findViewById(R.id.ca);
        plus = findViewById(R.id.plus);
        multiply= findViewById(R.id.multiply);
        substaract = findViewById(R.id.substract);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);
        result = findViewById(R.id.result);



        System.out.println("initData 메서드 호출");
    }


    private void addEventListener() {
        zero.setOnClickListener(view -> {
            newvalue = newvalue + "0";
            System.out.println(newvalue);
            System.out.println(newvalue.substring(0, 1));
            if(newvalue.substring(0,1).equals("0")){
                if(newvalue.length()>0){
                    newvalue = newvalue.substring(1, newvalue.length()-1);
                }

            }
            result.setText(newvalue);
        });

        one.setOnClickListener(view -> {
            newvalue = newvalue + "1";
            result.setText(newvalue);
        });

        two.setOnClickListener(view -> {
            newvalue = newvalue + "2";
            result.setText(newvalue);
        });

        three.setOnClickListener(view -> {
            newvalue = newvalue + "3";
            result.setText(newvalue);
        });
        four.setOnClickListener(view -> {
            newvalue = newvalue + "4";
            result.setText(newvalue);
        });
        five.setOnClickListener(view -> {
            newvalue = newvalue + "5";
            result.setText(newvalue);
        });
        six.setOnClickListener(view -> {
            newvalue = newvalue + "6";
            result.setText(newvalue);
        });
        seven.setOnClickListener(view -> {
            newvalue = newvalue + "7";
            result.setText(newvalue);
        });
        eight.setOnClickListener(view -> {
            newvalue = newvalue + "8";
            result.setText(newvalue);
        });
        nine.setOnClickListener(view -> {
            newvalue = newvalue + "9";
            result.setText(newvalue);
        });
        ca.setOnClickListener(view -> {
            newvalue = "";
            result.setText("0");
        });

        plus.setOnClickListener(view -> {
        });

        multiply.setOnClickListener(view -> {
            Log.d(TAG, "*");
        });

        substaract.setOnClickListener(view -> {
            Log.d(TAG, "-");
        });

        divide.setOnClickListener(view -> {
            Log.d(TAG, "%");
        });

        equal.setOnClickListener(view -> {



            Log.d(TAG, "=");
        });
    }

}