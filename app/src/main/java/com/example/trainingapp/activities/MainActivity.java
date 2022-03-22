package com.example.trainingapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trainingapp.model.Day;
import com.example.trainingapp.model.ExerciseList;
import com.example.trainingapp.R;
import com.example.trainingapp.model.Muscle;
import com.example.trainingapp.model.MuscleList;
import com.example.trainingapp.model.Week;
import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Week week1;
    ArrayAdapter<Day> weekAdapter;
    ListView week;
    ExerciseList exs;
    MuscleList muscleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        muscleList=MuscleList.getInstance(this);
        week1=Week.getInstance(this);

        week=findViewById(R.id.week);
        weekAdapter = new ArrayAdapter<Day>(this, android.R.layout.activity_list_item, android.R.id.text1, week1) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Day day1 = (Day) week1.get(position);
                TextView text = view.findViewById(android.R.id.text1);
                text.setText(day1.toString());
                return view;
            }
        };
        week.setAdapter(weekAdapter);
        week.setOnItemClickListener(this);
        exs= new ExerciseList(this);
        if(muscleList.isEmpty()){
            muscleList.add(new Muscle("Pecs"));
            muscleList.add(new Muscle("Back"));
            muscleList.add(new Muscle("AntDelts"));
            muscleList.add(new Muscle("MedDelts"));
            muscleList.add(new Muscle("RearDelts"));
            muscleList.add(new Muscle("Biceps"));
            muscleList.add(new Muscle("Triceps"));
            muscleList.add(new Muscle("Quads"));
            muscleList.add(new Muscle("Hamstrings"));
            muscleList.add(new Muscle("Calves"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id=item.getItemId();
        if(id==R.id.itemExList){
            Intent intent = new Intent(this, ExerciseListActivity.class);
            startActivity(intent);
        }
        if(id==R.id.itemStats){
            Intent intent = new Intent(this, ProgramStatsActivity.class);
            startActivity(intent);
        }
        if(id==R.id.itemAddDay){
            Day day1 = new Day(week1.size()+1);
            week1.addDay(day1);
            weekAdapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this,DayActivity.class);
        intent.putExtra("dayNumber", i);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}