package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseInfo extends AppCompatActivity implements View.OnClickListener {
    Button btnReturnFromInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_info);
        btnReturnFromInfo=findViewById(R.id.btnReturnFromInfo);
        btnReturnFromInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnReturnFromInfo){
            Intent intent = new Intent(this,ExerciseList.class);
            startActivity(intent);
        }
    }
}