package com.example.trainingapp;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<Day> week1 = new ArrayList<>();
    ArrayAdapter<Day> weekAdapter;
    ListView week;
    SharedPreferences sp;
    int daycount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        ExerciseList exs = ExerciseList.sharedInstance();
        exs.createEx("Biceps Iso","BicepCurl");
        exs.createEx("Horizontal Push","BenchPress");
        exs.createEx("Horizontal Pull","CableRow");
        exs.createEx("Vertical Pull","Pullup");
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
            Day day1 = new Day(daycount);
            daycount++;
            week1.add(day1);
            weekAdapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int id=view.getId();
        Intent intent = new Intent(this,DayActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}