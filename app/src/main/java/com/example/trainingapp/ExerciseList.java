package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseList extends AppCompatActivity implements View.OnClickListener {
    Button btnReturn, btnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        btnReturn=findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
        btnInfo=findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnReturn){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        if(view==btnInfo){
            Intent intent = new Intent(this,ExerciseInfo.class);
            startActivity(intent);
        }
    }
}