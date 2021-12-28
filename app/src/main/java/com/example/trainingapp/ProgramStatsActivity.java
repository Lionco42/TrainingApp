package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgramStatsActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnReturnFromStats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_stats);
        btnReturnFromStats=findViewById(R.id.btnReturnFromStats);
        btnReturnFromStats.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnReturnFromStats){
            finish();
        }
    }
}