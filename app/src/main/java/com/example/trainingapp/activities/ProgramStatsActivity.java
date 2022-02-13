package com.example.trainingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.Muscle;
import com.example.trainingapp.model.MuscleList;
import com.google.gson.Gson;

public class ProgramStatsActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    Button btnReturnFromStats;
    ArrayAdapter<Muscle> muscleCountArrayAdapter;
    ListView muscleCountListView;
    SharedPreferences sp;
    MuscleList muscleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_stats);
        btnReturnFromStats=findViewById(R.id.btnReturnFromStats);
        btnReturnFromStats.setOnClickListener(this);
        sp=getSharedPreferences("details1",0);
        Gson gson = new Gson();
        String json = sp.getString("MuscleCount","");
        muscleList =gson.fromJson(json, MuscleList.class);

        muscleCountArrayAdapter = new ArrayAdapter<Muscle>(this, android.R.layout.activity_list_item, android.R.id.text1, muscleList.getMuscles()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                String muscle1 = (String) muscleCountListView.getAdapter().getItem(position);
                TextView text = view.findViewById(android.R.id.text1);
                text.setText(muscle1+": "+ muscleList.get(position).getCount());
                return view;
            }
        };
        muscleCountListView.setAdapter(muscleCountArrayAdapter);
        muscleCountListView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnReturnFromStats){
            finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}