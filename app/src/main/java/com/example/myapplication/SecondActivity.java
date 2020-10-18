package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText numberField;
    String operation = "";
    EditText resultField;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch simpleSwitch;
    LinearLayout layout;
    GridLayout Gridlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        numberField = (EditText) findViewById(R.id.numberField);
        resultField = (EditText) findViewById(R.id.resultField);
        simpleSwitch = (Switch) findViewById(R.id.simpleSwitch);
        layout = (LinearLayout) findViewById(R.id.activity_second);
        Gridlayout = (GridLayout) findViewById(R.id.grid);
        simpleSwitch.setTextOn("dark mode"); // displayed text of the Switch whenever it is in checked or on state
        simpleSwitch.setTextOff("light mode");
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    layout.setBackgroundColor(Color.BLACK);
                    Gridlayout.setBackgroundColor(Color.BLACK);
                }
                else {
                    layout.setBackgroundColor(Color.WHITE);
                    Gridlayout.setBackgroundColor(Color.WHITE);
                }
            }
        });

    }

    public void onNumberClick(View view){
        Button button = (Button)view;
        numberField.append(button.getText());
    }
    public void onOperationClick(View view){

        Button button = (Button)view;
        String op = button.getText().toString();
        String number = numberField.getText().toString();
        if(number.length()>0){
            try{
                performOperation(Double.valueOf(number), op);
            }catch (NumberFormatException ex){
                numberField.setText("");
            }
        }
        operation = op;
    }

    @SuppressLint("SetTextI18n")
    private void performOperation(Double number, String operation){

            switch(operation){

                case "в наносекунди":
                    number *= 1000000000;
                    break;
                case "в мікросекунди":
                    number *= 1000000;
                    break;
                case "в секунди":
                    break;
                case "в хвилини":
                    number /= 60;
                    break;
                case "в години":
                    number /= 3600;
                    break;
                case "в добу":
                    number /= 86400;
                    break;
                case "в неділю":
                    number /= 604800;
                    break;
                case "в рік":
                    number /= 31536000;
                    break;
            }

        resultField.setText(number.toString());
        numberField.setText("");
    }
}