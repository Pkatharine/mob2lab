package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ThridActivity extends AppCompatActivity {

    TextView siteText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
        siteText = (TextView) findViewById(R.id.display_message);
    }

    public void onCheckboxClickedSite(View view) {
        CheckBox site = (CheckBox) view;
        // Получаем, отмечен ли данный флажок
        boolean checked = site.isChecked();
        if(checked) {
            siteText.setTextColor(Color.RED);
        }
        else {
            siteText.setTextColor(Color.BLACK);
        }

    }

    public void onToggleClicked(View view) {

        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            Toast.makeText(this, "You unliked calculator :(", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You liked calculator :)", Toast.LENGTH_LONG).show();
        }
    }

    public void onGoToCalc(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void OnSendFeedback(View view) {
        Toast.makeText(this, "Thank you for your feedback!", Toast.LENGTH_LONG).show();
    }

}