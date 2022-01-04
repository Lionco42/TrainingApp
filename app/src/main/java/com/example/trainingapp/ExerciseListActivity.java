package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ExerciseListActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnReturn, btnInfo, btnCreate,btnConfirm;
    Dialog d;
    EditText etExName, etMovement;
    ExerciseList lst;
    SharedPreferences sp;
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

        sp=getSharedPreferences("details1",0);
        Gson gson = new Gson();
        String json = sp.getString("exerciseTypeList","");
        lst=gson.fromJson(json,ExerciseList.class);
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
            ExerciseType ex = new ExerciseType(etMovement.getText().toString(), etExName.getText().toString());
            lst.getLst().add(ex);
            sp=getSharedPreferences("details1",0);
            SharedPreferences.Editor editor=sp.edit();
            Gson gson=new Gson();
            String json = gson.toJson(lst);
            editor.putString("exerciseTypeList", json);
            editor.commit();
            d.dismiss();
        }
    }
}