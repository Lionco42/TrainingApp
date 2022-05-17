package com.example.trainingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.trainingapp.model.Day;
import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.ExerciseList;
import com.example.trainingapp.model.ExerciseType;
import com.example.trainingapp.R;
import com.example.trainingapp.model.MuscleList;
import com.example.trainingapp.model.Week;
import com.google.gson.Gson;

import java.util.ArrayList;

public class  DayActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {
    Button btnReturn, btnAddToDay, btnConfirmAdd;
    EditText etAddName, etAddReps, etAddSets;
    TextView tv;
    Week week2;
    Day dayx;
    Switch sw;
    Boolean delFlag=false;
    ExerciseList exs;
    ArrayAdapter<Exercise> dayAdapter;
    ListView day;
    Dialog d;
    int dayNumber;
    Spinner spinner;
    ExerciseType selectedEx;
    ArrayAdapter<ExerciseType> spinnerAdapter;
    MuscleList muscleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        btnReturn=findViewById(R.id.btnReturnFromDayToMain);
        btnReturn.setOnClickListener(this);
        btnAddToDay=findViewById(R.id.btnAddToDay);
        btnAddToDay.setOnClickListener(this);
        tv=findViewById(R.id.tvDayName);
        day=findViewById(R.id.day);
        sw=findViewById(R.id.swDelete);
        sw.setOnCheckedChangeListener(this);

        week2=Week.getInstance(this);
        exs= ExerciseList.getInstance(this);
        muscleList =muscleList.getInstance(this);
        dayNumber = getIntent().getExtras().getInt("dayNumber");
        dayx=week2.get(dayNumber);
        tv.setText("Day " + Integer.toString(dayNumber+1));
        dayAdapter = new ArrayAdapter<Exercise>(this, android.R.layout.activity_list_item, android.R.id.text1, dayx) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Exercise ex1 = (Exercise) day.getAdapter().getItem(position);
                TextView text = view.findViewById(android.R.id.text1);
                if(!dayx.isEmpty())
                    text.setText(ex1.getName()+" ("+ex1.getType().getMovement()+")"+", Reps: "+ex1.getReps()+", Sets: "+ex1.getSets());
                return view;
            }
        };
        day.setAdapter(dayAdapter);
        day.setOnItemClickListener(this);

        spinnerAdapter = new ArrayAdapter<ExerciseType>(this, android.R.layout.simple_spinner_dropdown_item, exs);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


    }

    @Override
    public void onClick(View view){
        if(view==btnReturn){
            finish();
        }
        if(view==btnAddToDay){
            d=new Dialog(this);
            d.setContentView(R.layout.exerciseadd_dialog);
            d.setTitle("Create Exercise");
            d.setCancelable(true);
            etAddName=(EditText)d.findViewById(R.id.etExName);
            etAddReps=(EditText)d.findViewById(R.id.etAddReps);
            etAddSets=(EditText)d.findViewById(R.id.etAddSets);
            btnConfirmAdd=(Button)d.findViewById(R.id.btnConfirmAdd);
            btnConfirmAdd.setOnClickListener(this);

            spinner = (Spinner)d.findViewById(R.id.spin);
            spinner.setAdapter(spinnerAdapter);
            spinner.setOnItemSelectedListener(this);

            d.show();
        }
        if(view==btnConfirmAdd){
            Exercise ex = new Exercise(Integer.valueOf(etAddSets.getText().toString()),selectedEx, etAddReps.getText().toString());
            dayx.add(ex);
            week2.saveDataFile();
            muscleList.addSets(selectedEx.getMuscles(),Integer.valueOf(etAddSets.getText().toString()));
            dayAdapter.notifyDataSetChanged();
            d.dismiss();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(delFlag){
            muscleList.addSets(dayx.get(i).getType().getMuscles(),(-1)*(dayx.get(i).getSets()));
            dayx.remove(i);
            dayAdapter.notifyDataSetChanged();
            week2.saveDataFile();
            muscleList.saveDataFile();
        }
        selectedEx = exs.get(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedEx = exs.get(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b)
            delFlag=true;
        else
            delFlag=false;

    }
}