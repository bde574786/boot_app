package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
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

    ArrayList<String> arrListFormularValues;
    String newvalue = "0";

    String formula = "";
    boolean operatorOnOff = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        initData();
        addEventListener();
    }


    private void initData() {
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
        multiply = findViewById(R.id.multiply);
        substaract = findViewById(R.id.substract);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);
        result = findViewById(R.id.result);
        arrListFormularValues = new ArrayList<>();
    }

    private void setResultTextView(String number) {
        if (newvalue.equals("0")) {
            result.setText(number);
            newvalue = "";
        }
        newvalue += number;
        result.setText(newvalue);
        operatorOnOff = false;
    }

    private void setOperatorToFormula(String operator) {

        if (!operatorOnOff) {
            formula += operator;
        }

        operatorOnOff = false;

    }


    private ArrayList<String> removeStartEndOperArrList(ArrayList<String> arrListFormularValues) {

        int arrListSize = arrListFormularValues.size();
        if (arrListFormularValues.get(arrListSize - 1).equals("+") |
                arrListFormularValues.get(arrListSize - 1).equals("-") |
                arrListFormularValues.get(arrListSize - 1).equals("*") |
                arrListFormularValues.get(arrListSize - 1).equals("/")) {
            arrListFormularValues.remove(arrListSize - 1);
        }
        return arrListFormularValues;
    }

    private int findIndex(ArrayList<String> arrListFormularValues) {
        int idx1;
        int idx2;
        int opIndex = 0;
        if ((arrListFormularValues.indexOf("*") != -1) || (arrListFormularValues.indexOf("/") != -1)) {
            idx1 = arrListFormularValues.indexOf("*");
            idx2 = arrListFormularValues.indexOf("/");
            if (idx1 == -1 && idx2 != -1) {
                opIndex = idx2;
            } else if (idx2 == -1 && idx1 != -1) {
                opIndex = idx1;

            } else {
                opIndex = (idx1 < idx2) ? idx1 : idx2;
            }
        } else if ((arrListFormularValues.indexOf("+") != -1) || (arrListFormularValues.indexOf("-") != -1)) {
            idx1 = arrListFormularValues.indexOf("+");
            idx2 = arrListFormularValues.indexOf("-");

            if (idx1 == -1 && idx2 != -1) {
                opIndex = idx2;
            } else if (idx2 == -1 && idx1 != -1) {
                opIndex = idx1;
            } else {
                opIndex = (idx1 < idx2) ? idx1 : idx2;
            }
        }

        return opIndex;
    }



    private ArrayList<String> subCalaulate(int opIndex) {
        double leftNumber = Double.parseDouble(arrListFormularValues.get(opIndex - 1));
        double rightNumber = Double.parseDouble(arrListFormularValues.get(opIndex + 1));
        double result = 0.0;

        String operator = arrListFormularValues.get(opIndex);

        switch (operator) {
            case "*":
                result = leftNumber * rightNumber;
                break;
            case "/":
                result = leftNumber / rightNumber;
                break;
            case "+":
                result = leftNumber + rightNumber;
                break;
            case "-":
                result = leftNumber - rightNumber;
                break;

        }


        arrListFormularValues.set(opIndex - 1, String.valueOf(result));
        arrListFormularValues.remove(opIndex);
        arrListFormularValues.remove(opIndex);



        return arrListFormularValues;
    }

    private ArrayList<String> operateByPriority(ArrayList<String> arrListFormularValues) {
        while (arrListFormularValues.size() > 1) {
            arrListFormularValues = subCalaulate(findIndex(arrListFormularValues));
        }
        return arrListFormularValues;
    }

    private void addEventListener() {

        one.setOnClickListener(view -> {
            formula += "1";
            setResultTextView("1");
        });


        two.setOnClickListener(view -> {
            formula += "2";
            setResultTextView("2");
        });

        three.setOnClickListener(view -> {
            formula += "3";
            setResultTextView("3");
        });

        four.setOnClickListener(view -> {
            formula += "4";
            setResultTextView("4");
        });

        five.setOnClickListener(view -> {
            formula += "5";
            setResultTextView("5");
        });

        six.setOnClickListener(view -> {
            formula += "6";
            setResultTextView("6");
        });

        seven.setOnClickListener(view -> {
            formula += "7";
            setResultTextView("7");
        });

        eight.setOnClickListener(view -> {
            formula += "8";
            setResultTextView("8");
        });

        nine.setOnClickListener(view -> {
            formula += "9";
            setResultTextView("9");
        });

        zero.setOnClickListener(view -> {
            formula += "0";
            setResultTextView("0");
        });


        ca.setOnClickListener(view -> {
            arrListFormularValues.clear();
            newvalue = "0";
            formula = "";
            result.setText("0");
        });


        plus.setOnClickListener(view -> {
            String strTemp = String.valueOf(result.getText());
            arrListFormularValues.add(strTemp);
            setOperatorToFormula("+");
            operatorOnOff = true;
            arrListFormularValues.add("+");
            newvalue = "0";
        });

        multiply.setOnClickListener(view -> {
            String strTemp = String.valueOf(result.getText());
            arrListFormularValues.add(strTemp);
            setOperatorToFormula("*");
            operatorOnOff = true;
            arrListFormularValues.add("*");
            newvalue = "0";
        });

        substaract.setOnClickListener(view -> {
            String strTemp = String.valueOf(result.getText());
            arrListFormularValues.add(strTemp);
            setOperatorToFormula("-");
            operatorOnOff = true;
            arrListFormularValues.add("-");
            newvalue = "0";
        });

        divide.setOnClickListener(view -> {
            String strTemp = String.valueOf(result.getText());
            arrListFormularValues.add(strTemp);
            setOperatorToFormula("/");
            operatorOnOff = true;
            arrListFormularValues.add("/");
            newvalue = "0";
        });

        equal.setOnClickListener(view -> {
            String strTemp = String.valueOf(result.getText());
            arrListFormularValues.add(strTemp);
            arrListFormularValues = removeStartEndOperArrList(arrListFormularValues);
            arrListFormularValues = operateByPriority(arrListFormularValues);
            result.setText(arrListFormularValues.get(0));
            arrListFormularValues.clear();
        });


    }

}