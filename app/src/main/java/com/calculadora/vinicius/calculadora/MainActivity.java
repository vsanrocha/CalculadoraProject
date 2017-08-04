package com.calculadora.vinicius.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String values ="";
    boolean plus = false;
    boolean minus = false;
    String values1 = "";


    public void display(int number) {
        TextView displayTextView = (TextView) findViewById(R.id.calculatorDisplay);
        displayTextView.setText("" + number);
    }

    public void display(String value) {
        TextView displayTextView = (TextView) findViewById(R.id.calculatorDisplay);
        displayTextView.setText(value);
    }

    public void onButtonNumberClick(View view){
        String numberButton = ((Button)view).getText().toString();
        values = values.concat(numberButton);
        display(Integer.parseInt(values));
    }

    public void onPlusClick(View view){
        plus = true;
        values1 = values;
        values = "";
    }

    public void onClearClick(View view){
        values = "";
        values1 = "";
        plus = false;
        minus = false;
        display("");
    }

    public void onMinusClick(View view){
        minus = true;
        values1 = values;
        values = "";
    }

    public void buttonEqual (View view){
       int result = 0;
        if(plus){
            result = Integer.parseInt(values1) + Integer.parseInt(values);
        }
        else if(minus){
            result = Integer.parseInt(values1) - Integer.parseInt(values);
        }
        values = "";
        values1 = "";
        display(result);

    }


}
