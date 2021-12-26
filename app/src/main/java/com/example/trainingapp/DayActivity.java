package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DayActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnReturn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        btnReturn=findViewById(R.id.btnReturnFromDayToMain);
        btnReturn.setOnClickListener(this);
        tv=findViewById(R.id.dayTitleTv);
    }

    @Override
    public void onClick(View view){
        if(view==btnReturn){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}