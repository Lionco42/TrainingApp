package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExerciseListActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnReturn, btnInfo, btnCreate,btnConfirm;
    Dialog d;
    EditText etExName, etMovement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        btnReturn=findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
        btnInfo=findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(this);
        btnCreate=findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnReturn){
            finish();
        }
        if(view==btnInfo){
            Intent intent = new Intent(this, ExerciseInfoActivity.class);
            startActivity(intent);
        }
        if(view==btnCreate){
            d=new Dialog(this);
            d.setContentView(R.layout.exercisecreate_dialog);
            d.setTitle("Create Exercise");
            d.setCancelable(true);
            etExName=(EditText)d.findViewById(R.id.etExName);
            etMovement=(EditText)d.findViewById(R.id.etMovement);
            btnConfirm=(Button)d.findViewById(R.id.btnConfirm);
            btnConfirm.setOnClickListener(this);
            d.show();
        }
        if(view==btnConfirm){
            d.dismiss();
        }
    }
}