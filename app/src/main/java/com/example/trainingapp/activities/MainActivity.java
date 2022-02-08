package com.example.trainingapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.ExerciseList;
import com.example.trainingapp.R;
import com.example.trainingapp.model.MuscleCount;
import com.example.trainingapp.model.Week;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Week week1;
    ArrayAdapter<Day> weekAdapter;
    ListView week;
    ExerciseList exs;
    SharedPreferences sp;
    MuscleCount muscleCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("details1",0);
        Gson gson = new Gson();
        String json = sp.getString("Week","");
        week1=gson.fromJson(json,Week.class);
        if(week1==null)
            week1=Week.sharedInstance();

        week=findViewById(R.id.week);
        weekAdapter = new ArrayAdapter<Day>(this, android.R.layout.activity_list_item, android.R.id.text1, week1) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Day day = (Day) week.getAdapter().getItem(position);
                TextView text = view.findViewById(android.R.id.text1);
                text.setText(day.toString());
                return view;
            }
        };
        week.setAdapter(weekAdapter);
        week.setOnItemClickListener(this);

        json = sp.getString("exerciseTypeList","");
        exs=gson.fromJson(json,ExerciseList.class);
        if(exs==null){
            exs=ExerciseList.sharedInstance();
            SharedPreferences.Editor editor=sp.edit();
            exs.createEx("Biceps Iso","BicepCurl");
            exs.createEx("Horizontal Push","BenchPress");
            exs.createEx("Horizontal Pull","CableRow");
            exs.createEx("Vertical Pull","Pullup");
            json = gson.toJson(exs);
            editor.putString("exerciseTypeList", json);
            editor.commit();}

        muscleCount=new MuscleCount();
        SharedPreferences.Editor editor=sp.edit();
        gson=new Gson();
        json = gson.toJson(muscleCount);
        editor.putString("MuscleCount", json);
        editor.commit();
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

            SharedPreferences.Editor editor=sp.edit();
            Gson gson=new Gson();
            String json = gson.toJson(week1);
            editor.putString("Week", json);
            editor.commit();
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