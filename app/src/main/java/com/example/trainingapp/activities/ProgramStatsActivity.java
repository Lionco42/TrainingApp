package com.example.trainingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.ExerciseList;
import com.example.trainingapp.model.ExerciseType;
import com.example.trainingapp.model.MuscleCount;
import com.example.trainingapp.model.Week;
import com.google.gson.Gson;

public class ProgramStatsActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnReturnFromStats;
    ArrayAdapter<String> muscleCountArrayAdapter;
    ListView muscleCountListView;
    SharedPreferences sp;
    MuscleCount muscleCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_stats);
        btnReturnFromStats=findViewById(R.id.btnReturnFromStats);
        btnReturnFromStats.setOnClickListener(this);
        sp=getSharedPreferences("details1",0);
        Gson gson = new Gson();
        String json = sp.getString("MuscleCount","");
        muscleCount=gson.fromJson(json, MuscleCount.class);

        muscleCountArrayAdapter = new ArrayAdapter<Exercise>(this, android.R.layout.activity_list_item, android.R.id.text1, dayx) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Exercise ex1 = (Exercise) muscleCountListView.getAdapter().getItem(position);
                TextView text = view.findViewById(android.R.id.text1);
                if(!dayx.isEmpty())
                    text.setText(ex1.getName()+" ("+ex1.getType()+")"+", Reps: "+ex1.getReps()+", Sets: "+ex1.getSets());
                return view;
            }
        };
        muscleCountListView.setAdapter(dayAdapter);
        muscleCountListView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnReturnFromStats){
            finish();
        }
    }
}